import React from "react";

export default function CampoTexto({
  tipo = "text",
  placeholder,
  valor,
  alCambiar,
  clase = "",
}) {
  return (
    <input
      type={tipo}
      placeholder={placeholder}
      required
      value={valor}
      onChange={alCambiar}
      className={clase}
    />
  );
}
