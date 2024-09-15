package edu.coder.FacturacionSegundaEntregaMore.controller;
import edu.coder.FacturacionSegundaEntregaMore.model.VentaProducto;
import edu.coder.FacturacionSegundaEntregaMore.model.Venta;
import edu.coder.FacturacionSegundaEntregaMore.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/crear/{clienteId}")
    public Venta realizarVenta(
            @PathVariable Long clienteId,
            @RequestBody VentaProducto ventaProducto){
        return ventaService.realizarVenta(clienteId, ventaProducto.getProducto().getId(), ventaProducto.getCantidad());
    }

}