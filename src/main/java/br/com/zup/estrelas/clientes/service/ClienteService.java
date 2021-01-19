package br.com.zup.estrelas.clientes.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.zup.estrelas.clientes.dto.AlteraClienteDTO;
import br.com.zup.estrelas.clientes.dto.MensagemDTO;
import br.com.zup.estrelas.clientes.entity.Cliente;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    EntityManager manager;

    @Transactional
    public MensagemDTO criarCliente(Cliente cliente) {

        Cliente clienteConsultado = manager.find(Cliente.class, cliente.getCpf());

        if (clienteConsultado != null) {
            return new MensagemDTO("Cliente com o CPF já cadastrado!");
        }

        manager.persist(cliente);

        return new MensagemDTO("Cliente adicionado com sucesso!");
    }

    @Transactional
    public MensagemDTO alterarCliente(String cpf, AlteraClienteDTO alteracao) {

        Cliente clienteConsultado = manager.find(Cliente.class, cpf);

        if (clienteConsultado.equals(null)) {
            return new MensagemDTO(
                    "Operação não realizada, cliente com CPF digitado não encontrado!");
        }

        BeanUtils.copyProperties(alteracao, clienteConsultado);
   
        manager.merge(clienteConsultado);
   
        return new MensagemDTO("Cliente alterado com sucesso!");
    }


    public List<Cliente> ListarClientes() {

        Query query = manager.createQuery("select c from Cliente c");

        List<Cliente> clientes = query.getResultList();
        return clientes;
    }


    public Cliente consultarCliente(String cpf) {

        Cliente clienteConsultado = manager.find(Cliente.class, cpf);

        if (clienteConsultado.equals(null)) {
            return new Cliente();
        }

        return clienteConsultado;
    }

    @Transactional
    public MensagemDTO excluirCliente(String cpf) {
        Cliente clienteARemover = manager.find(Cliente.class, cpf);

        if (clienteARemover == null) {
            return new MensagemDTO(
                    "Operação não realizada, cliente com CPF digitado não encontrado!");
        }
        
        manager.remove(clienteARemover);
        
        return new MensagemDTO("Cliente excluído com sucesso!");
    }

}
