package br.com.zup.estrelas.clientes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.zup.estrelas.clientes.dto.AlteraClienteDTO;
import br.com.zup.estrelas.clientes.dto.ClienteDTO;
import br.com.zup.estrelas.clientes.dto.MensagemDTO;
import br.com.zup.estrelas.clientes.entity.Cliente;
import br.com.zup.estrelas.clientes.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    
    public MensagemDTO criarCliente(ClienteDTO clienteDTO) {

        if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {
            return new MensagemDTO("Cliente com o CPF já cadastrado!");
        }
        
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        
        clienteRepository.save(cliente);
        
        return new MensagemDTO("Cliente adicionado com sucesso!");
    }

    
    public MensagemDTO alterarCliente(String cpf, AlteraClienteDTO alteracao) {

        Optional<Cliente> clienteBD = clienteRepository.findByCpf(cpf);
        
        if (clienteBD.isEmpty()) {
            return new MensagemDTO("Operação não realizada, cliente com CPF digitado não encontrado!");
        }
        
        Cliente cliente = clienteBD.get();
        
        BeanUtils.copyProperties(alteracao, cliente);
        
        clienteRepository.save(cliente);
        
       return new MensagemDTO("Cliente alterado com sucesso!");
    }
    
    public List<Cliente> ListarClientes() {
        
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        return clientes;
    }
    
    public Cliente consultarCliente(String cpf) {

        Optional<Cliente> clienteConsultado = clienteRepository.findByCpf(cpf);
        
        if (clienteConsultado.isEmpty()) {
            return new Cliente();
        }

        Cliente cliente = clienteConsultado.get();
        
        return cliente;
    }

    public MensagemDTO excluirCliente(String cpf) {

        if (clienteRepository.existsByCpf(cpf)) {
            
            clienteRepository.deleteByCpf(cpf);
            
            return new MensagemDTO("Cliente excluído com sucesso!");
        }
        
        return new MensagemDTO("Operação não realizada, cliente com CPF digitado não encontrado!");
    }

}
