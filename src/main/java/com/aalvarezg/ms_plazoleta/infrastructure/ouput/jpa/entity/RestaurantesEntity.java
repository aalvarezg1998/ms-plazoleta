package com.aalvarezg.ms_plazoleta.infrastructure.ouput.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "restaurantes", schema = "public", catalog = "db_plazoleta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "id_propietario")
    private Long idPropietario;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "url_logo")
    private String urlLogo;
    @Basic
    @Column(name = "nit")
    private String nit;

}
