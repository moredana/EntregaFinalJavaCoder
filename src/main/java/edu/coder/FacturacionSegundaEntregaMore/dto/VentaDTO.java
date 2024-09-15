package edu.coder.FacturacionSegundaEntregaMore.dto;

import java.util.List;

public class VentaDTO {
    private Long clienteId;
    private List<ProductoDTO> productos; // Lista de productos
    private Integer cantidad;

    // Constructor por defecto
    public VentaDTO() {
    }

    // Constructor con parámetros
    public VentaDTO(Long clienteId, List<ProductoDTO> productos, Integer cantidad) {
        this.clienteId = clienteId;
        this.productos = productos;
        this.cantidad = cantidad;
    }

    // Getter y Setter para clienteId
    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    // Getter y Setter para productos
    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    // Getter y Setter para cantidad
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    // Clase ProductoDTO
    public static class ProductoDTO {
        private Long productoId;
        private Integer cantidad;

        // Constructor por defecto
        public ProductoDTO() {
        }

        // Constructor con parámetros
        public ProductoDTO(Long productoId, Integer cantidad) {
            this.productoId = productoId;
            this.cantidad = cantidad;
        }

        // Getter y Setter para productoId
        public Long getProductoId() {
            return productoId;
        }

        public void setProductoId(Long productoId) {
            this.productoId = productoId;
        }

        // Getter y Setter para cantidad
        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }
    }
}
