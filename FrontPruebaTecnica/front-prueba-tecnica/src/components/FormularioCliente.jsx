
import { useState } from "react";



const data = {
  1: { // Colombia
    departamentos: {
      1: ["Medellín"], // Antioquia
      2: ["Bogotá"],   // Cundinamarca
      3: ["Cali"],     // Valle del Cauca
      8: ["Bucaramanga"], // Santander
      9: ["Barranquilla"], // Atlántico
      10: ["Cartagena"] // Bolívar
    }
  },
  2: { // Perú
    departamentos: {
      4: ["Lima"],
      5: ["Cusco"],
      11: ["Arequipa"],
      12: ["Trujillo"]
    }
  },
  3: { // Ecuador
    departamentos: {
      6: ["Quito"], // Pichincha
      7: ["Guayaquil"], // Guayas
      13: ["Manta"], // Manabí
      14: ["Cuenca"] // Azuay
    }
  },
  4: { // México
    departamentos: {
      15: ["Ciudad de México"],
      16: ["Guadalajara"], // Jalisco
      17: ["Monterrey"] // Nuevo León
    }
  }
};


const Form = () => {
        const [pais, setPais] = useState("");
        const [departamento, setDepartamento] = useState("");
        const [ciudad, setCiudad] = useState("");
    const {values, setValues} = useState({
        userName :"",
        userLastName : "",
        userEmail:"",
        userPhone:"",
        userDate:"",
        userAdress:"",
        userDocumentNumber:"",
        userTypeIdentification:"",
        userCountry:"",
        userDepartment:"",
        userCity:""
})
    const manejarEntradaDatos = (event) =>{
        const {name, value} = event.target;
        setValues({
            ...values, [name]:value,
        });
    };
    return(
        <div>
            <input
            type="text"
            name="userName"
            value={values.userName}
            placeholder="Ingresa tu nombre"
            onChange = {manejarEntradaDatos}
            />
            <input type="text" 
            name="userLastName"
            value={values.userLastName}
            placeholder="Ingresa tu apelido"
            onChange={manejarEntradaDatos}
            />
            <input type="text" 
            name="userEmail"
            value={values.userEmail}
            placeholder="Ingresa tu correo electronico"
            onChange={manejarEntradaDatos}
            />
            <input type="text" 
            name="userPhone"
            value={values.userPhone}
            placeholder="Ingresa tu numero de celular"
            onChange={manejarEntradaDatos}
            />
            <input type="date" 
            name="userDate"
            value={values.userDate}
            placeholder="tu fecha de nacimiento"
            onChange={manejarEntradaDatos}
            />
            <input type="text" 
            name="userAdress"
            value={values.userAdress}
            placeholder="Ingresa tu direccion"
            onChange={manejarEntradaDatos}
            />
            <input type="number" 
            name="userDocumentNumber"
            value={values.userDocumentNumber}
            placeholder="Ingresa tu numero de documento"
            onChange={manejarEntradaDatos}
            />
            <label>Tipo de documento:</label>
            <select
              name="userTypeIdentification"
              value={values.userTypeIdentification}
              onChange={manejarEntradaDatos}
            >
              <option value="">Seleccione</option>
              <option value="1">CC</option>
              <option value="2">CE</option>
              <option value="3">Pasaporte</option>
              <option value="4">TI</option>
              <option value="5">NIT</option>
            </select>
                <div>
            {/* País */}
            <select value={pais} onChange={(e) => { 
                setPais(e.target.value); 
                setDepartamento(""); 
                setCiudad(""); 
              }}>
              <option value="">Selecciona país</option>
              <option value="1">Colombia</option>
              <option value="2">Perú</option>
              <option value="3">Ecuador</option>
              <option value="4">México</option>
            </select>
          
            {/* Departamento (se muestra según país) */}
            {pais && (
              <select value={departamento} onChange={(e) => { 
                  setDepartamento(e.target.value); 
                  setCiudad(""); 
                }}>
                <option value="">Selecciona departamento</option>
                {Object.keys(data[pais].departamentos).map((depId) => (
                  <option key={depId} value={depId}>
                    {depId} - {Object.keys(data[pais].departamentos).length > 0 ? depId : ""}
                  </option>
                ))}
              </select>
            )}

            {/* Ciudad (se muestra según departamento) */}
            {departamento && (
              <select value={ciudad} onChange={(e) => setCiudad(e.target.value)}>
                <option value="">Selecciona ciudad</option>
                {data[pais].departamentos[departamento].map((c, i) => (
                  <option key={i} value={c}>{c}</option>
                ))}
              </select>
            )}
            </div>
        </div>
    )
}

export default Form;