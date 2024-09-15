package edu.coder.FacturacionSegundaEntregaMore.model;
//01:08
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "venta_productos") // Nombre de la tabla en la base de datos
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "cantidad") // Opcional: definir nombre de la columna en la tabla
    private Integer cantidad;

    // Constructor
    public VentaProducto() {}

    public VentaProducto(Venta venta, Producto producto, Integer cantidad) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        VentaProducto that = (VentaProducto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(venta, that.venta) &&
                Objects.equals(producto, that.producto) &&
                Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, venta, producto, cantidad);
    }

    // toString
    @Override
    public String toString() {
        return "VentaProducto{" +
                "id=" + id +
                ", venta=" + venta +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
