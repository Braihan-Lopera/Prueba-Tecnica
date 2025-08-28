// correo válido: debe contener @ y al menos 4 letras después del @
export function esUnCorreoValido(correo) {
  const regex = /^[^@]+@.{4,}$/;
  return regex.test(correo);
}

// (opcional) nombre válido: solo letras y espacios
export function esUnNombreValido(nombre) {
  const regex = /^[A-Za-zÁÉÍÓÚáéíóúñÑ\s]+$/;
  return regex.test(nombre);
}