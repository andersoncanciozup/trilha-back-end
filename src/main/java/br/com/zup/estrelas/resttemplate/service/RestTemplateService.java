package br.com.zup.estrelas.resttemplate.service;

import java.util.List;
import br.com.zup.estrelas.resttemplate.dto.MensagemDTO;
import br.com.zup.estrelas.resttemplate.entity.Comic;

public interface RestTemplateService {
    
    public MensagemDTO sincronizar();
    
    public List<Comic> listarComics();
}
