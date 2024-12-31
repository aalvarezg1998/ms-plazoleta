package com.aalvarezg.ms_plazoleta.domain.model;

public class Restaurante {
    private Long id;
    private String nombre;
    private String direccion;
    private Long idPropietario;
    private String telefono;
    private String urlLogo;
    private String nit;

    public Restaurante() {
    }

    public Restaurante(Long id, String nombre, String direccion, Long idPropietario, String telefono, String urlLogo, String nit) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idPropietario = idPropietario;
        this.telefono = telefono;
        this.urlLogo = urlLogo;
        this.nit = nit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
