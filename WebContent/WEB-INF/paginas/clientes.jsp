<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de clientes</title>
</head>
<body>
	<form method="POST" action="clienteServlet">
		 <input type="hidden" name="acao" value="CREATE"/>
		
	     Telefone <input type="text" name="telefone" value="${cliente.telefone}"/> <br>
	     Nome <input type="text" name="nome" value="${cliente.nome}"/> <br>
	     Endereço <input type="text"  name="endereco" value="${cliente.endereco}"/> <br>
	     Cpf <input type="text"  name="cpf" value="${cliente.cpf}"/> <br>
	     Email <input type="text"  name="email" value="${cliente.email}"/> <br>
	     Idade <input type="text"  name="idade" value="${cliente.idade}"/> <br>
		 <input type="submit" value="Enviar" />
	</form>

	<font color="red"><h2>${mensagem}</h2></font>

	<h4>Clientes cadastrados</h4>
	<table border="1">
		<tr>
			<th>Cpf</th>
			<th>Nome</th>			
			<th>Telefone</th>
			<th>endereço</th>
			<th>Email</th>
			<th>Idade</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach var="f" items="${clientes}">
		<tr>
			<td>${f.cpf}</td>		
			<td>${f.nome}</td>
			<td>${f.telefone}</td>
			<td>${f.endereco}</td>
			<td>${f.email}</td>
			<td>${f.idade}</td>
			<td><a href=clienteServlet?acao=RETRIEVE&cpf=${f.cpf}>Editar</a>
			<td><a href=clienteServlet?acao=DELETE&cpf=${f.cpf}>Excluir</a>
		</tr>	
		</c:forEach>	
	</table>
</body>
</html>