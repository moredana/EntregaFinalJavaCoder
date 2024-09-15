package edu.coder.FacturacionSegundaEntregaMore.controller;

import edu.coder.FacturacionSegundaEntregaMore.model.Producto;
import edu.coder.FacturacionSegundaEntregaMore.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/agregar")
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos(){
        List<Producto> productos =  productoService.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Producto> buscarProducto(@PathVariable Long id) {
        return productoService.buscarProducto(id);
    }

    @DeleteMapping ("eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        boolean eliminado =  productoService.eliminarProducto(id);
        if (eliminado) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
        }
    }
}
