/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.BackendEcomerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mota1
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    
            @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;
	
    @Column(name = "nombre", nullable = false)
	private String nombre;
    
    @Column(name = "descripcion", nullable = false)
	private String descripcion;
    

    
    @Column(name = "precio", nullable = false)
	private float precio;
    
    @Column(name = "precio_fabrica", nullable = false)
    private float precio_fabrica;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
        @Column(name = "descuento", nullable = false)
	private float descuento;
        
        
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
	private Calendar fecha_registro;
    
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orden_detalles> Orden_detalles;
    
    
        @ManyToOne()
    @JoinColumn(name = "cliente_empresa_id")
    private Cliente_empresa cliente_empreza;
}