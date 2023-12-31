package com.example.form.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Usuario {

    //@NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;
    @NotEmpty

    private String apellido;
    // "Doble back slash d significa de 0-9
    //@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    private String identificacion;
    @NotEmpty
    @Size(min = 3, max = 8)
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    @Email(message = "Formato invalido")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getidentificacion() {
        return identificacion;
    }

    public void setidentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
