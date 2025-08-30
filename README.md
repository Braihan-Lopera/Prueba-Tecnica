# 🚀 Prueba Técnica

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=FFD62E)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

Este repositorio contiene una aplicación **fullstack** dividida en dos módulos principales:  
- **BackPruebaTecnica** → API REST con Spring Boot + JPA.  
- **FrontPruebaTecnica** → Interfaz web con React + Vite.  
- **dumpMysql** → Scripts SQL para inicializar la base de datos MySQL.  

---

## 📖 Descripción general
La aplicación permite **registrar y consultar usuarios** desde una interfaz web que consume la API backend.

- **Backend (Spring Boot + JPA)**  
  - Punto de entrada: `PruebaTecnicaApplication`  
  - Entidades principales: `Usuario`, `Pais`, `Departamento`, `Ciudad`, `Marca`, `Tipo_Identificacion`.  
  - `ServicioUsuario`: valida unicidad de correo y documento antes de guardar, además expone métodos de búsqueda.  
  - `ControladorUsuario`: endpoints para registrar usuarios y consultarlos por distintos criterios.  
  - Configuración BD: `BackPruebaTecnica/src/main/resources/application.properties`.
  - en el proyecto se consume la base de datos para las listas desde el back.

- **Frontend (React + Vite)**  
  - Ubicación: `FrontPruebaTecnica/front-prueba-tecnica`.  
  - Interfaz moderna con **styled-components**.  
  - Se comunica con el backend para registrar y listar usuarios.  

- **Base de Datos (MySQL)**  
  - Nombre: `RegistroUsuarios`  
  - Se inicializa importando los scripts de la carpeta `dumpMysql/`.  

---

## ⚙️ Ejecución del Backend
```bash
cd BackPruebaTecnica
mvn spring-boot:run
