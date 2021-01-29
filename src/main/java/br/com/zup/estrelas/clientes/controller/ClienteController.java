package br.com.zup.estrelas.clientes.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.estrelas.clientes.ZupEstrelasClientesApplication;
import br.com.zup.estrelas.clientes.dto.AlteraClienteDTO;
import br.com.zup.estrelas.clientes.dto.ClienteDTO;
import br.com.zup.estrelas.clientes.dto.MensagemDTO;
import br.com.zup.estrelas.clientes.entity.Cliente;
import br.com.zup.estrelas.clientes.service.IClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
//    static Logger logger = Logger.getLogger(ClienteController.class.getName());
    
    @Autowired
    IClienteService clienteService;
    
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public MensagemDTO criarCliente(@RequestBody ClienteDTO cliente) {
//        logger.info("Criando novo cliente");
        return clienteService.criarCliente(cliente);
    }
    
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Cliente> listaClientes() {
        return clienteService.ListarClientes();
    }
    
    @GetMapping(path = "/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Cliente consultarCliente(@PathVariable String cpf) {
        return clienteService.consultarCliente(cpf);
    }
    
    @PutMapping(path = "/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public MensagemDTO alteraCliente(@PathVariable String cpf, @RequestBody AlteraClienteDTO alteraClienteDTO) {
        return clienteService.alterarCliente(cpf, alteraClienteDTO);
    }
    
    @Transactional
    @DeleteMapping(path = "/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE }) 
    public MensagemDTO excluirCliente(@PathVariable String cpf) {
        return clienteService.excluirCliente(cpf);
    }
    
}