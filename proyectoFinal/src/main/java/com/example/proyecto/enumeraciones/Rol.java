
package com.example.proyecto.enumeraciones;




public enum Rol {
    ADMIN("Administrador"),
    PROVEEDOR("Proveedor"),
    USUARIO("Residente");

    private final String descripcion;

    Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}


