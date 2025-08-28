import React from "react";
const API_URL = "http://localhost:8080";

//traer los tipos de documentos
export async function obtenerTiposDocumento() {
  const res = await fetch(`${API_URL}/tipo-identificacion/listar`);
  if (!res.ok) throw new Error("Error al cargar tipos de documento");
  return res.json();
}

//traer los paises
export async function obtenerPaises() {
  const res = await fetch(`${API_URL}/paises/listar`);
  if (!res.ok) throw new Error("Error al cargar países");
  return res.json();
}

//traer los departamentios dependiendo del id del pais
export async function obtenerDepartamentos(idPais) {
  const res = await fetch(`${API_URL}/departamento/listar/${idPais}`);
  if (!res.ok) throw new Error("Error al cargar departamentos");
  return res.json();
}

//traer las ciudades dependiendo del id del departamento
export async function obtenerCiudades(idDepartamento) {
  const res = await fetch(`${API_URL}/ciudad/listar/${idDepartamento}`);
  if (!res.ok) throw new Error("Error al cargar ciudades");
  return res.json();
}


//(funcion de registrar)
export async function registrarUsuario(usuario) {
  const res = await fetch(`${API_URL}/usuarios/guardar`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(usuario),
  });

  if (!res.ok) throw new Error("Error en el registro");
  return res.json();
}