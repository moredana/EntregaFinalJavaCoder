package edu.coder.FacturacionSegundaEntregaMore.service;

import edu.coder.FacturacionSegundaEntregaMore.model.VentaProducto;
import edu.coder.FacturacionSegundaEntregaMore.repository.VentaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VentaProductoService {
    @Autowired
    private VentaProductoRepository ventaProductoRepository;

    public VentaProducto agregarVentaProducto(VentaProducto ventaProducto) {
        return ventaProductoRepository.save(ventaProducto);
    }

    public Optional<VentaProducto> buscarVentaProducto(Long id) {
        return ventaProductoRepository.findById(id);
    }
}
