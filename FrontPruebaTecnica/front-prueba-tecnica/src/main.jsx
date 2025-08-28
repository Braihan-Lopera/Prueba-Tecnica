import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import MarcaForm from "./components/MarcaForm";
import "./styles/MarcaForm.css"
import Switch from "./components/Switch";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <Switch/>
    <MarcaForm />
  </StrictMode>
);
