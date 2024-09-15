package edu.coder.FacturacionSegundaEntregaMore.service;
import edu.coder.FacturacionSegundaEntregaMore.service.ProductoService;
import edu.coder.FacturacionSegundaEntregaMore.model.Cliente;
import edu.coder.FacturacionSegundaEntregaMore.model.Producto;
import edu.coder.FacturacionSegundaEntregaMore.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private static ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerTodosLosProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarProducto(Long id) {
        return productoRepository.findById(id);
    }

    public boolean eliminarProducto(Long id){
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public static Producto findById(Long id){
        return productoRepository.findById(id).orElse(null);
    }
}
