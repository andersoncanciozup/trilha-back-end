package br.com.zup.estrelas.resttemplate.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.estrelas.resttemplate.dto.MensagemDTO;
import br.com.zup.estrelas.resttemplate.entity.Comic;
import br.com.zup.estrelas.resttemplate.service.RestTemplateService;

@RestController
@RequestMapping("/comic")
public class RestTemplateController {

    @Autowired
    RestTemplateService rtService;
    
    @PostMapping(path = "/sincronizar", produces = { MediaType.APPLICATION_JSON_VALUE })
    public MensagemDTO sincronizar() throws NoSuchAlgorithmException {
        return rtService.sincronizar();
    }
    
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Comic> listarComics() {
        return rtService.listarComics();
    }
}
