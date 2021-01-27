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


