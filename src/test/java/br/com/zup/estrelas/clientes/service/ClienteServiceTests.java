package br.com.zup.estrelas.clientes.service;

import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import br.com.zup.estrelas.clientes.dto.AlteraClienteDTO;
import br.com.zup.estrelas.clientes.dto.ClienteDTO;
import br.com.zup.estrelas.clientes.dto.MensagemDTO;
import br.com.zup.estrelas.clientes.entity.Cliente;
import br.com.zup.estrelas.clientes.repository.ClienteRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTests {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteService clienteService;

    @Test
    public void deveCriarClienteComSucesso() {
        ClienteDTO cliente = instanciaCliente();

        Mockito.when(clienteRepository.existsByCpf(cliente.getCpf())).thenReturn(false);

        MensagemDTO mensagemRetornada = this.clienteService.criarCliente(cliente);
        MensagemDTO mensagemEsperada = new MensagemDTO("Cliente adicionado com sucesso!");

        Assert.assertEquals("Deve criar um cliente com sucesso", mensagemEsperada,
                mensagemRetornada);
    }

    @Test
    public void naoDeveCriarClienteComCpfExistente() {
        ClienteDTO cliente = instanciaCliente();

        Mockito.when(clienteRepository.existsByCpf(cliente.getCpf())).thenReturn(true);

        MensagemDTO mensagemRetornada = this.clienteService.criarCliente(cliente);
        MensagemDTO mensagemEsperada = new MensagemDTO("Cliente com o CPF já cadastrado!");

        Assert.assertEquals("Não deve criar cliente com cpf já cadastrado", mensagemEsperada,
                mensagemRetornada);
    }

    @Test
    public void deveAlterarClienteComSucesso() {
        AlteraClienteDTO alteracaoCliente = new AlteraClienteDTO();
        alteracaoCliente.setIdade(30);
        alteracaoCliente.setEmail("anderson.cancio@zup.com.br");

        ClienteDTO cliente = instanciaCliente();
        Cliente clienteConsultado = new Cliente();
        BeanUtils.copyProperties(cliente, clienteConsultado);
        clienteConsultado.setIdCliente(1L);

        Optional<Cliente> clienteBD = Optional.of(clienteConsultado);

        Mockito.when(clienteRepository.findByCpf("015.976.912-90")).thenReturn(clienteBD);

        MensagemDTO mensagemRetornada =
                this.clienteService.alterarCliente("015.976.912-90", alteracaoCliente);
        MensagemDTO mensagemEsperada = new MensagemDTO("Cliente alterado com sucesso!");

        Assert.assertEquals("Deve alterar um cliente com sucesso", mensagemEsperada,
                mensagemRetornada);
    }

    @Test
    public void naoDeveAlterarClienteInexistente() {
        AlteraClienteDTO alteracaoCliente = new AlteraClienteDTO();
        alteracaoCliente.setIdade(30);
        alteracaoCliente.setEmail("anderson.cancio@zup.com.br");

        Optional<Cliente> clienteBD = Optional.empty();

        Mockito.when(clienteRepository.findByCpf("015.976.912-90")).thenReturn(clienteBD);

        MensagemDTO mensagemRetornada =
                this.clienteService.alterarCliente("015.976.912-90", alteracaoCliente);
        MensagemDTO mensagemEsperada =
                new MensagemDTO("Operação não realizada, cliente com CPF digitado não encontrado!");

        Assert.assertEquals("Deve alterar um cliente com sucesso", mensagemEsperada,
                mensagemRetornada);
    }

    @Test
    public void deveExcluirClienteComSucesso() {
        Mockito.when(clienteRepository.existsByCpf("015.976.912-90")).thenReturn(true);

        MensagemDTO mensagemRetornada = this.clienteService.excluirCliente("015.976.912-90");
        MensagemDTO mensagemEsperada = new MensagemDTO("Cliente excluído com sucesso!");

        Assert.assertEquals("Deve exluir um cliente com sucesso", mensagemEsperada,
                mensagemRetornada);
    }

    @Test
    public void naoDeveExcluirClienteInexistente() {
        Mockito.when(clienteRepository.existsByCpf("015.976.912-90")).thenReturn(false);

        MensagemDTO mensagemRetornada = this.clienteService.excluirCliente("015.976.912-90");
        MensagemDTO mensagemEsperada =
                new MensagemDTO("Operação não realizada, cliente com CPF digitado não encontrado!");

        Assert.assertEquals("Não deve excluir um cliente inexistente", mensagemEsperada,
                mensagemRetornada);
    }

    private ClienteDTO instanciaCliente() {
        ClienteDTO cliente = new ClienteDTO();
        cliente.setCpf("015.976.912-90");
        cliente.setEmail("anderson@zup.com.br");
        cliente.setEndereco("Av Oscar, n 840");
        cliente.setIdade(28);
        cliente.setNome("Anderson Oliveira Cancio");
        cliente.setTelefone("(92)99340-4313");
        return cliente;
    }


}
