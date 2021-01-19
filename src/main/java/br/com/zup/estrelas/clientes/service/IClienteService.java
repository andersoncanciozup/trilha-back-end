package br.com.zup.estrelas.clientes.service;

import java.util.List;
import br.com.zup.estrelas.clientes.dto.AlteraClienteDTO;
import br.com.zup.estrelas.clientes.dto.MensagemDTO;
import br.com.zup.estrelas.clientes.entity.Cliente;

public interface IClienteService {
    
    public MensagemDTO criarCliente(Cliente cliente);

    public MensagemDTO alterarCliente(String cpf, AlteraClienteDTO cliente);
    
    public List<Cliente> ListarClientes();
    
    public Cliente consultarCliente(String cpf);
    
    public MensagemDTO excluirCliente(String cpf);
}
