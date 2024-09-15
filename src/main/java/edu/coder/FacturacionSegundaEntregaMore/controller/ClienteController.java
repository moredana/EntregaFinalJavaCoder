package edu.coder.FacturacionSegundaEntregaMore.controller;
import edu.coder.FacturacionSegundaEntregaMore.model.Cliente;
import edu.coder.FacturacionSegundaEntregaMore.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/clientes") //El controlador recibe la petición del front. Linkea el front donde está la lógica que es donde generalmente están las validaciones, etc.

public class ClienteController{ //Se crea instancia del servicio.
    @Autowired
    private ClienteService clienteService;

        @PostMapping("/agregar")
        public Cliente agregarCliente(@RequestBody Cliente cliente) {
                return clienteService.agregarCliente(cliente);
            }

        @GetMapping("/buscar/{id}")
        public Optional<Cliente> buscarCliente(@PathVariable Long id){
            return clienteService.buscarCliente(id);
        }

        @GetMapping("/todos")
        public ResponseEntity<List<Cliente>> obtenerTodosLosClientes(){
            List<Cliente> clientes =  clienteService.obtenerTodosLosClientes();
            return ResponseEntity.ok(clientes);
        }

        @DeleteMapping ("eliminar/{id}")
        public ResponseEntity<Void> eliminarCliente(@PathVariable Long id){
            boolean eliminado =  clienteService.eliminarCliente(id);
            if (eliminado) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
            }
        }
    }


