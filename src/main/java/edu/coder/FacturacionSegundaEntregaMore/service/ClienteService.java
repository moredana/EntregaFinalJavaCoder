package edu.coder.FacturacionSegundaEntregaMore.service;

import edu.coder.FacturacionSegundaEntregaMore.model.Cliente;
import edu.coder.FacturacionSegundaEntregaMore.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private static ClienteRepository clienteRepository;

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public boolean eliminarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public static Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}
