package edu.coder.FacturacionSegundaEntregaMore.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.coder.FacturacionSegundaEntregaMore.service.ClienteService;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    //@JsonBackReference // Evita la serialización recursiva
    @JsonIgnore
    private List<Venta> ventas;

    /*@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<Venta> ventas;*/

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public static class VentaProducto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "venta_id")
        private Venta venta;

        @ManyToOne
        @JoinColumn(name = "producto_id")
        private Producto producto;

        private Integer cantidad;

    // Getters y Setters


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
    }


}
