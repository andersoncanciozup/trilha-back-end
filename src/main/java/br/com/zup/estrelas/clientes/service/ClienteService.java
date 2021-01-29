package br.com.zup.estrelas.clientes.service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
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

    private static final String CLIENTE_EXCLUÍDO_COM_SUCESSO = "Cliente excluído com sucesso!";

    private static final String CLIENTE_ALTERADO_COM_SUCESSO = "Cliente alterado com sucesso!";

    private static final String CPF_NÃO_ENCONTRADO = "Operação não realizada, cliente com CPF digitado não encontrado!";

    private static final String CLIENTE_ADICIONADO_COM_SUCESSO = "Cliente adicionado com sucesso!";

    private static final String CLIENTE_JÁ_CADASTRADO = "Cliente com o CPF já cadastrado!";

    static Logger logger = Logger.getLogger(ClienteService.class.getName());
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public MensagemDTO criarCliente(ClienteDTO clienteDTO) {

        if (clienteRepository.existsByCpf(clienteDTO.getCpf())) {
            logger.warn(CLIENTE_JÁ_CADASTRADO);
            return new MensagemDTO(CLIENTE_JÁ_CADASTRADO);
        }
        
        logger.info(CLIENTE_ADICIONADO_COM_SUCESSO);
        
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        
        clienteRepository.save(cliente);
        
        return new MensagemDTO(CLIENTE_ADICIONADO_COM_SUCESSO);
    }

    
    public MensagemDTO alterarCliente(String cpf, AlteraClienteDTO alteracao) {

        Optional<Cliente> clienteBD = clienteRepository.findByCpf(cpf);
        
        if (clienteBD.isEmpty()) {
            logger.warn(CPF_NÃO_ENCONTRADO);
            return new MensagemDTO(CPF_NÃO_ENCONTRADO);
        }
 
        logger.info(CLIENTE_ALTERADO_COM_SUCESSO);
        
        Cliente cliente = clienteBD.get();
        
        BeanUtils.copyProperties(alteracao, cliente);
        
        clienteRepository.save(cliente);
        
       return new MensagemDTO(CLIENTE_ALTERADO_COM_SUCESSO);
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
            logger.info(CLIENTE_EXCLUÍDO_COM_SUCESSO);
            clienteRepository.deleteByCpf(cpf);
            
            return new MensagemDTO(CLIENTE_EXCLUÍDO_COM_SUCESSO);
        }
        logger.warn(CPF_NÃO_ENCONTRADO);
        return new MensagemDTO(CPF_NÃO_ENCONTRADO);
    }

}
