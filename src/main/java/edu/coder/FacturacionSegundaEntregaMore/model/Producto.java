package edu.coder.FacturacionSegundaEntregaMore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "productos") //Definir nombre de la tabla

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id autoincrement
    private Long id; //Estructura de la tabla.

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference // Evita la serialización recursiva
    private  Set<Venta> ventas;

    //Cosntructor
    public Producto() {
    }

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //Getters y Setters
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

    //Equals y Hashcodes. Sirve para diferenciar 2 objetos hijos de la misma clase

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(nombre, producto.nombre) && Objects.equals(precio, producto.precio) && Objects.equals(ventas, producto.ventas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, ventas);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", ventas=" + ventas +
                '}';
    }
}
