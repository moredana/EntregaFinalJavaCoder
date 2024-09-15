package edu.coder.FacturacionSegundaEntregaMore.service;

import edu.coder.FacturacionSegundaEntregaMore.model.Cliente;
import edu.coder.FacturacionSegundaEntregaMore.model.Venta;
import edu.coder.FacturacionSegundaEntregaMore.model.Producto;
import edu.coder.FacturacionSegundaEntregaMore.model.VentaProducto;
import edu.coder.FacturacionSegundaEntregaMore.repository.ClienteRepository;
import edu.coder.FacturacionSegundaEntregaMore.repository.ProductoRepository;
import edu.coder.FacturacionSegundaEntregaMore.repository.VentaProductoRepository;
import edu.coder.FacturacionSegundaEntregaMore.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VentaProductoRepository ventaProductoRepository;

    public Venta agregarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> buscarVenta(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta realizarVenta(Long clienteId, Long productoId, int cantidad) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta = ventaRepository.save(venta);

        VentaProducto ventaProducto = new VentaProducto();
        ventaProducto.setVenta(venta);
        ventaProducto.setProducto(producto);
        ventaProducto.setCantidad(cantidad);
        ventaProductoRepository.save(ventaProducto);

        List<VentaProducto> ventaProductos = new ArrayList<>();
        ventaProductos.add(ventaProducto);
        venta.setVentaProductos(ventaProductos);

        return ventaRepository.save(venta);
    }
}
