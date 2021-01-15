package br.com.zup.estrelas.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.zup.estrelas.model.dao.ClienteDao;
import br.com.zup.estrelas.model.domain.Cliente;

@WebServlet("/clienteServlet")
public class ClienteServlet extends HttpServlet {

	private ClienteDao clienteDao = new ClienteDao();
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String acao = request.getParameter("acao");
			if (acao != null) {
				if (acao.equals("CREATE")) {
					Cliente cliente = criaCliente(request);
				
					if (clienteDao.cpfCadastrado(cliente.getCpf())) {
						clienteDao.salvar(cliente);
						request.setAttribute("mensagem", "Cliente salvo com sucesso");
					} else {
						clienteDao.atualizar(cliente);
						request.setAttribute("mensagem", "Cliente atualizado com sucesso");
					}
				} else if (acao.equals("RETRIEVE")) {
					String cpf = request.getParameter("cpf");
					Cliente cliente = clienteDao.getClienteId(cpf);
					request.setAttribute("cliente", cliente);
	
				} else if (acao.equals("DELETE")) {
					String cpf = request.getParameter("cpf");
					clienteDao.excluir(cpf);
					request.setAttribute("mensagem", "Cliente excluido");
				}
			}
			request.setAttribute("clientes", clienteDao.getClientes());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/clientes.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException | ClassNotFoundException | IllegalArgumentException e) {
			request.setAttribute("mensagem", "Erro: " + e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/paginas/erro.jsp");
			dispatcher.forward(request, response);
		}
	}

	private Cliente criaCliente(HttpServletRequest request) {
	    Cliente cliente = new Cliente();

	    cliente.setNome(request.getParameter("nome"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setIdade(request.getParameter("idade"));
		
		return cliente;
	}

}
