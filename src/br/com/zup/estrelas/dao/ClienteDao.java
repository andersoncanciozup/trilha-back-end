package br.com.zup.estrelas.dao;


import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.zup.estrelas.main.Cliente;


public class ClienteDao {

    EntityManager manager;

    public ClienteDao() {
        this.manager = Persistence.createEntityManagerFactory("clientes").createEntityManager();
    }

    public List<Cliente> getClientes() throws SQLException, ClassNotFoundException {
        Query query = manager.createQuery("select c from Cliente c");

        List<Cliente> clientes = query.getResultList();
        return clientes;
    }

    public void salvar(Cliente cliente) {
        manager.getTransaction().begin();
        manager.persist(cliente);
        manager.getTransaction().commit();
    }

    public void excluir(String cpf) throws SQLException, ClassNotFoundException {
        Cliente clienteARemover = manager.find(Cliente.class, cpf);

        manager.getTransaction().begin();
        manager.remove(clienteARemover);
        manager.getTransaction().commit();
    }

    public Cliente getClienteId(String cpf)
            throws IllegalArgumentException, SQLException, ClassNotFoundException {
        Cliente clienteConsultado = manager.find(Cliente.class, cpf);
        return clienteConsultado;
    }

    public void atualizar(Cliente cliente) {

        Cliente clienteAlterado = manager.find(Cliente.class, cliente.getCpf());


        clienteAlterado.setEmail(cliente.getEmail());
        clienteAlterado.setNome(cliente.getNome());
        clienteAlterado.setIdade(cliente.getIdade());
        clienteAlterado.setTelefone(cliente.getTelefone());
        clienteAlterado.setEndereco(cliente.getEndereco());
        clienteAlterado.setCpf(cliente.getCpf());

        manager.getTransaction().begin();
        manager.merge(clienteAlterado);
        manager.getTransaction().commit();
    }

    public boolean cpfCadastrado(String cpf) {

        Cliente clienteConsultado = manager.find(Cliente.class, cpf);

        if (clienteConsultado != null) {
            return false;
        }
        return true;
    }
}
