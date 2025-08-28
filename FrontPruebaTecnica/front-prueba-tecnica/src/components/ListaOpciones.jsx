import React from "react";

function ListaOpciones({ valor, alCambiar, opciones, clave, mostrar, placeholder, clase = "" }) {
  return (
    <select value={valor} onChange={alCambiar} required className={clase}>
      <option value="">{placeholder}</option>
      {opciones.map((opcion) => (
        <option key={opcion[clave]} value={opcion[clave]}>
          {opcion[mostrar]}
        </option>
      ))}
    </select>
  );
}

export default  ListaOpciones;
