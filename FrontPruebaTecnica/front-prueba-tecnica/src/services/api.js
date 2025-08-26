const URL_BASE = "http://localhost:8080/api"

export async function registrarUsuario(datos){
    const respuesta = await fetch(`${URL_BASE}/usuarios`,{
        method:"POST",
        headers:{"Content-Type": "application/json"},
        body:JSON.stringify(datos)
    })

    if(!respuesta.ok){
        const texto = await respuesta.ok()
        throw new Error(texto || "Error al registrar")
    }

    try{
        return await respuesta.json()
    }catch{
        return {}
    }

}