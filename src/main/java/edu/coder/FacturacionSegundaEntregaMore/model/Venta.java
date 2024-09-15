package edu.coder.FacturacionSegundaEntregaMore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ventas") // Definir nombre de la tabla
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id autoincrement
    private Long id; // Estructura de la tabla

    @ManyToOne(fetch = FetchType.EAGER) // Relación ManyToOne con Producto
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER) // Relación ManyToOne con Cliente
    @JoinColumn(name = "cliente_id")
    private Cliente cliente; // Usa simplemente Cliente

    @Column(name = "cantidad")
    private Integer cantidad;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VentaProducto> ventaProductos;

    // Constructor
    public Venta() {
    }

    public Venta(Producto producto, Cliente cliente, Integer cantidad) {
        this.producto = producto;
        this.cliente = cliente;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return Objects.equals(id, venta.id) &&
                Objects.equals(producto, venta.producto) &&
                Objects.equals(cliente, venta.cliente) &&
                Objects.equals(cantidad, venta.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producto, cliente, cantidad);
    }

    // toString
    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", producto=" + producto +
                ", cliente=" + cliente +
                ", cantidad=" + cantidad +
                '}';
    }

    public void agregarVentaProducto(VentaProducto ventaProducto){
        ventaProductos.add(ventaProducto);
        ventaProducto.setVenta(this);
    }

    public void eliminarVentaProducto(VentaProducto ventaProducto){
        ventaProductos.remove(ventaProducto);
        ventaProducto.setVenta(null);
    }

    public void setVentaProductos(List<VentaProducto> ventaProductos) {
        this.ventaProductos = ventaProductos;
    }

}
