import React from "react";
const API_URL = "http://localhost:8080";


export async function obtenerTiposDocumento() {
  const res = await fetch(`${API_URL}/tipo-identificacion/listar`);
  if (!res.ok) throw new Error("Error al cargar tipos de documento");
  return res.json();
}


export async function obtenerPaises() {
  const res = await fetch(`${API_URL}/paises/listar`);
  if (!res.ok) throw new Error("Error al cargar países");
  return res.json();
}


export async function obtenerDepartamentos(idPais) {
  const res = await fetch(`${API_URL}/departamento/listar/${idPais}`);
  if (!res.ok) throw new Error("Error al cargar departamentos");
  return res.json();
}


export async function obtenerCiudades(idDepartamento) {
  const res = await fetch(`${API_URL}/ciudad/listar/${idDepartamento}`);
  if (!res.ok) throw new Error("Error al cargar ciudades");
  return res.json();
}



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
