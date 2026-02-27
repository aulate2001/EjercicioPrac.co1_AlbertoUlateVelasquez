/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.salon.domain;

/**
 *
 * @author alber
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_cliente", nullable = false, length = 100)
    @NotBlank(message = "El nombre no puede estar vacio.")
    @Size(max = 100, message = "El campo no puede tener más de 100 caracteres.")
    private String nombreCliente;

    @Column(columnDefinition = "TEXT")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Servicio servicio;
    
}