import React, { useEffect, useState } from "react";
import CampoTexto from "./CampoTexto";
import ListaOpciones from "./ListaOpciones";
import {
  obtenerTiposDocumento,
  obtenerPaises,
  obtenerDepartamentos,
  obtenerCiudades,
} from "../services/servicioUsuario";
import { registrarUsuario } from "../services/servicioUsuario";
import { esUnCorreoValido, esUnNombreValido } from "../services/validaciones";
import "../styles/MarcaForm.css";

const brands = [
  {
    id: 1,
    name: "Americanino",
    img: "/assets/americaninoLogo.png",
    color: "#064998",
  },
  {
    id: 2,
    name: "American Eagle",
    img: "/assets/americanEagleLogo.webp",
    color: "#ffffffff",
  },
  {
    id: 3,
    name: "Chevignon",
    img: "/assets/chevignonLogo.webp",
    color: "#4e4949",
  },
  { id: 4, name: "Esprit", img: "/assets/espiritLogo.webp", color: "#f3080c" },
  { id: 5, name: "Naf Naf", img: "/assets/nafnafLogo.webp", color: "#000000" },
  { id: 6, name: "Rifle", img: "/assets/rifleLogo.webp", color: "#ffffffff" },
];

const MarcaForm = () => {
  const [selectedBrand, setSelectedBrand] = useState(null);
  const handleBrandChange = (e) => {
    const brandId = parseInt(e.target.value);
    const brand = brands.find((b) => b.id === brandId);
    setSelectedBrand(brand);
  };

  const [nomre, setNombre] = useState("");
  const [apellido, setApellido] = useState("");
  const [correo, setCorreo] = useState("");
  const [numero, setNumero] = useState("");
  const [fechaNacimiento, setFechaNacimiento] = useState("");
  const [numeroDoc, setNumeroDoc] = useState("");
  const [direccion, setDireccion] = useState("");
  const [tipoDocumento, setTipoDocumento] = useState([]);
  const [tipoSeleccionado, setTipoSeleccionado] = useState("");
  const [paises, setPaises] = useState([]);
  const [paisSeleccionado, setPaisSeleccionado] = useState("");
  const [departamentos, setDepartamentos] = useState([]);
  const [departamentoSeleccionado, setDepartamentoSeleccionado] = useState("");
  const [ciudades, setCiudades] = useState([]);
  const [ciudadSeleccionada, setCiudadSeleccionada] = useState("");

  useEffect(() => {
    obtenerTiposDocumento()
      .then((data) => {
        setTipoDocumento(data);
      })
      .catch((err) => console.error(err));
  }, []);

  useEffect(() => {
    obtenerPaises()
      .then(setPaises)
      .catch((err) => console.error(err));
  }, []);
  useEffect(() => {
    if (paisSeleccionado) {
      obtenerDepartamentos(paisSeleccionado)
        .then(setDepartamentos)
        .catch((err) => console.error(err));
    } else {
      setDepartamentos([]);
    }
  }, [paisSeleccionado]);

  useEffect(() => {
    if (departamentoSeleccionado) {
      obtenerCiudades(departamentoSeleccionado)
        .then(setCiudades)
        .catch((err) => console.error(err));
    } else {
      setCiudades([]);
    }
  }, [departamentoSeleccionado]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!esUnCorreoValido(correo)) {
      return Swal.fire({
        icon: "error",
        text: "El correo debe tener un @ y al menos 4 caracteres después",
      });
    }

    if (!esUnNombreValido(nomre)) {
      return Swal.fire({
        icon: "error",
        text: "El número de teléfono no es válido",
      });
    }

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
      ciudad: { idCiudad: ciudadSeleccionada },
    };
    console.log("Objeto usuario listo para enviar:", usuario);

    registrarUsuario(usuario)
      .then((data) => {
        console.log("Usuario registrado con éxito:", data);

        Swal.fire({
          title: "Usuario registrado con éxito",
          icon: "success",
          draggable: true,
        });
      })
      .catch((err) => {
        console.error("Error al registrar usuario:", err);

        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Algo salió mal, por favor revisa bien la información",
        });
      });
  };

  return (
    <div className="form-marca">
      <h2>Selecciona una marca para el programa de fidelización</h2>
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

      {selectedBrand && (
        <div className="contenedor-marca">
          <div
            className="logo-marca"
            style={{ backgroundColor: selectedBrand.color }}
          >
            <img src={selectedBrand.img} alt={selectedBrand.name} />
          </div>

          <form className="formulario-marca" onSubmit={handleSubmit}>
            <div className="fila-2">
              <CampoTexto
                placeholder="Nombre"
                valor={nomre}
                alCambiar={(e) => setNombre(e.target.value)}
              />
              <CampoTexto
                placeholder="Apellido"
                valor={apellido}
                alCambiar={(e) => setApellido(e.target.value)}
              />
            </div>

            <div className="fila-2">
              <CampoTexto
                tipo="email"
                placeholder="Correo"
                valor={correo}
                alCambiar={(e) => setCorreo(e.target.value)}
              />
              <CampoTexto
                tipo="text"
                placeholder="Número de teléfono"
                valor={numero}
                alCambiar={(e) => setNumero(e.target.value)}
              />
            </div>

            <div className="fila-2">
              <ListaOpciones
                valor={tipoSeleccionado}
                alCambiar={(e) => setTipoSeleccionado(Number(e.target.value))}
                opciones={tipoDocumento}
                clave="idTipoIdentificacion"
                mostrar="tipoDocumento"
                placeholder="Seleccione tipo de documento"
              />
              <CampoTexto
                type="text"
                placeholder="Número de documento (Sin puntos ni guiones)"
                valor={numeroDoc}
                alCambiar={(e) => setNumeroDoc(e.target.value)}
              />
            </div>

            <input
              type="date"
              required
              value={fechaNacimiento}
              onChange={(e) => setFechaNacimiento(e.target.value)}
            />

            <div className="fila-3">
              <ListaOpciones
                valor={paisSeleccionado}
                alCambiar={(e) => setPaisSeleccionado(e.target.value)}
                opciones={paises}
                clave="idPais"
                mostrar="pais"
                placeholder="Seleccione el país"
              />
              <ListaOpciones
                valor={departamentoSeleccionado}
                alCambiar={(e) =>
                  setDepartamentoSeleccionado(Number(e.target.value))
                }
                opciones={departamentos}
                clave="idDepartamento"
                mostrar="departamento"
                placeholder="Seleccione departamento"
              />
              <ListaOpciones
                valor={ciudadSeleccionada}
                alCambiar={(e) => setCiudadSeleccionada(Number(e.target.value))}
                opciones={ciudades}
                clave="idCiudad"
                mostrar="ciudad"
                placeholder="Seleccione ciudad"
              />
            </div>

            <div className="fila-1">
              <label>
                <input
                  required
                  type="text"
                  placeholder="Dirección"
                  className="input-direccion"
                  value={direccion}
                  onChange={(e) => setDireccion(e.target.value)}
                />
              </label>
            </div>

            <button type="submit" className="btn-registrar">
              Registrar
            </button>
          </form>
        </div>
      )}
    </div>
  );
};

export default MarcaForm;
