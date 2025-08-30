export function esUnCorreoValido(correo) {
  const regex = /^[^@]+@.{4,}$/;
  return regex.test(correo);
}

export function esUnNombreValido(nombre) {
  const regex = /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;
  return regex.test(nombre);
}
