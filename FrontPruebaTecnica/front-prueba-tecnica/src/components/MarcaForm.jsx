import React, { useEffect, useState } from "react";
import "../styles/MarcaForm.css";

const brands = [
  { id: 1, name: "Americanino", img: "/assets/americaninoLogo.png", color: "#064998" },
  { id: 2, name: "American Eagle", img: "/assets/americanEagleLogo.webp", color: "#ffffffff" },
  { id: 3, name: "Chevignon", img: "/assets/chevignonLogo.webp", color: "#4e4949" },
  { id: 4, name: "Esprit", img: "/assets/espiritLogo.webp", color: "#f3080c" },
  { id: 5, name: "Naf Naf", img: "/assets/nafnafLogo.webp", color: "#000000" },
  { id: 6, name: "Rifle", img: "/assets/rifleLogo.webp", color: "#ffffffff" }
];

const MarcaForm = () => {
  const [selectedBrand, setSelectedBrand] = useState(null);
  const handleBrandChange = (e) => {
    const brandId = parseInt(e.target.value);
    const brand = brands.find((b) => b.id === brandId);
    setSelectedBrand(brand);
  };

    const [nomre, setNombre] = useState("")
    const [apellido, setApellido] = useState("")
    const [correo, setCorreo] = useState("")
    const [numero, setNumero] = useState("")
    const [fechaNacimiento, setFechaNacimiento] = useState("");
    const [numeroDoc, setNumeroDoc] = useState("")
    const [direccion, setDireccion] = useState("")

    const [tipoDocumento, setTipoDocumento] = useState([])
    const [tipoSeleccionado, setTipoSeleccionado] = useState("")

    useEffect(()=>{
        fetch("http://localhost:8080/tipo-identificacion/listar")
        .then((res) =>res.json())
        .then((data) => setTipoDocumento(data))
        .catch((err)=> console.log("Error al cargar tipos: ", err))
    }, []);

    const [paises, setPaises] = useState([]);
    const [paisSeleccionado, setPaisSeleccionado] = useState("");

    useEffect(() => {
      fetch("http://localhost:8080/paises/listar")
        .then((res) => res.json())
        .then((data) => setPaises(data))
        .catch((err) => console.log("Error al cargar países: ", err));
    }, []);

    const [departamentos, setDepartamentos] = useState([])
    const[departamentoSeleccionado, setDepartamentoSeleccionado] = useState("")

useEffect(() => {
  if (paisSeleccionado) {
    fetch(`http://localhost:8080/departamento/listar/${paisSeleccionado}`)
      .then((res) => {
        if (!res.ok) {
          throw new Error("Error en la respuesta del servidor");
        }
        return res.json();
      })
      .then((data) => setDepartamentos(data))
      .catch((err) => console.log("Error al cargar departamentos: ", err));
  } else {
    setDepartamentos([]);
  }
}, [paisSeleccionado]);

const [ciudades, setCiudades] = useState([]);
const [ciudadSeleccionada, setCiudadSeleccionada] = useState("");

// Cuando cambia el departamento, traemos las ciudades
useEffect(() => {
  if (departamentoSeleccionado) {
    fetch(`http://localhost:8080/ciudad/listar/${departamentoSeleccionado}`)
      .then((res) => {
        if (!res.ok) throw new Error("Error en la respuesta del servidor");
        return res.json();
      })
      .then((data) => setCiudades(data))
      .catch((err) => console.error("Error al cargar ciudades:", err));
  } else {
    setCiudades([]); // reset si no hay departamento seleccionado
  }
}, [departamentoSeleccionado]);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Registrado en marca:", selectedBrand);

const usuario = {
  nombreUsuario: nomre,
  apellidoUsuario: apellido,
  correoUsuario: correo,
  telefonoUsuario: numero,
  numeroDocumento: numeroDoc,
  direccionUsuario: direccion,
  fechaNacimiento: fechaNacimiento,
  tipoIdentificacion: { idTipoIdentificacion: tipoSeleccionado },
  marca: { idMarca: selectedBrand.id },
  pais: { idPais: paisSeleccionado },
  departamento: { idDepartamento: departamentoSeleccionado },
  ciudad: { idCiudad: ciudadSeleccionada }
};

  console.log("Objeto usuario listo para enviar:", usuario);

  fetch("http://localhost:8080/usuarios/guardar", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify(usuario),
})
  .then((res) => {
    if (!res.ok) throw new Error("Error en el registro");
    return res.json();
  })
  .then((data) => {
    console.log("Usuario registrado con éxito:", data);
    alert("Usuario registrado correctamente ✅");
  })
  .catch((err) => console.error("Error al registrar usuario:", err));



  };

  return (
    <div className="marca-form-wrapper">
      <h2>Selecciona una Marca</h2>

      {/* Select */}
      <select onChange={handleBrandChange} defaultValue="">
        <option value="" disabled>
          -- Selecciona --
        </option>
        {brands.map((brand) => (
          <option key={brand.id} value={brand.id}>
            {brand.name}
          </option>
        ))}
      </select>

      {/* Contenedor dinámico */}
      {selectedBrand && (
        <div className="marca-form-container">
          {/* Div de la marca */}
          <div
            className="brand-preview"
            style={{ backgroundColor: selectedBrand.color }}
          >
            <img src={selectedBrand.img} alt={selectedBrand.name} />
          </div>

          {/* Formulario */}
          <form className="formulario" onSubmit={handleSubmit}>
            <div className="grid-2">
              <input type="text" placeholder="Nombre" required 
                value ={nomre}
                onChange={(e) => setNombre(e.target.value)}
              />
              <input type="text" placeholder="Apellido" required 
                value ={apellido}
                onChange={(e) => setApellido(e.target.value)}
              />
            </div>
            <div className="grid-2">
              <input type="email" placeholder="Correo" required 
                value ={correo}
                onChange={(e) => setCorreo(e.target.value)}/>
              <input type="tel" placeholder="Número de celular" required 
              value ={numero}
              onChange={(e) => setNumero(e.target.value)}
              />
            </div>
            <div className="grid-2">
              <label>
                <select
                  value={tipoSeleccionado}
                  onChange={(e) => setTipoSeleccionado(Number(e.target.value))}
                  required
                >
                  <option value="">Seleccione tipo de documento</option>
                  {tipoDocumento.map((t) => (
                    <option key={t.idTipoIdentificacion} value={t.idTipoIdentificacion}>
                      {t.tipo_documento} ({t.abreviatura})
                    </option>
                  ))}
                </select>
                
              </label>
              <input type="text" placeholder="Número de documento" required
              value ={numeroDoc}
              onChange={(e) => setNumeroDoc(e.target.value)}/>

            </div>
            <input 
              type="date" 
              required 
              value={fechaNacimiento}
              onChange={(e) => setFechaNacimiento(e.target.value)}
              />


            <div className="grid-3">
              
                  <select
                    value={paisSeleccionado}
                    onChange={(e) => setPaisSeleccionado(Number(e.target.value))}
                    required
                  >
                    <option value="">Seleccione país</option>
                    {paises.map((p) => (
                      <option key={p.idPais} value={p.idPais}>
                        {p.pais}
                      </option>
                    ))}
                  </select>


                    <select
                      required
                      value={departamentoSeleccionado}
                      onChange={(e) => setDepartamentoSeleccionado(Number(e.target.value))}
                    >
                      <option value="">Seleccione departamento</option>
                      {departamentos.map((d) => (
                        <option key={d.idDepartamento} value={d.idDepartamento}>
                          {d.departamento}
                        </option>
                      ))}
                    </select>


                    <select
                      required
                      value={ciudadSeleccionada}
                      onChange={(e) => setCiudadSeleccionada(Number(e.target.value))}
                    >
                      <option value="">Seleccione ciudad</option>
                      {ciudades.map((c) => (
                        <option key={c.idCiudad} value={c.idCiudad}>
                          {c.ciudad}
                        </option>
                      ))}
                    </select>

            </div>


            {/* Dirección */}
            <div className="grid-1">
              <label>
                <input required type="text" placeholder="Direccion" className="inputDireccion"
                value ={direccion}
                onChange={(e) => setDireccion(e.target.value)}
                />
                
              </label>
            </div>
            <button type="submit">Registrar</button>
          </form>
        </div>
      )}
    </div>
  

);
};

export default MarcaForm;
