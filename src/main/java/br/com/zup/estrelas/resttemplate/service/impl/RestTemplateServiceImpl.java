package br.com.zup.estrelas.resttemplate.service.impl;

import java.util.Date;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.estrelas.resttemplate.dto.MensagemDTO;
import br.com.zup.estrelas.resttemplate.entity.Comic;
import br.com.zup.estrelas.resttemplate.entity.ComicResponse;
import br.com.zup.estrelas.resttemplate.repository.RestTemplateRepository;
import br.com.zup.estrelas.resttemplate.service.RestTemplateService;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private static final MensagemDTO SICRONIZADO_COM_SUCESSO =
            new MensagemDTO("Banco de dados sincronizado com API marvel!");

    private final String PRIVATE_KEY = "e0b382766e9abe7b3a05b8894a11a0659129675c";

    private final String PUBLIC_KEY = "3b3b5c9804ce9549be26627c50142f68";


    @Autowired
    RestTemplateRepository restTemplateRepository;

    public MensagemDTO sincronizar() {
        RestTemplate rt = new RestTemplate();

        Long ts = new Date().getTime();

        String hash = criotografia(ts);

        String uri = uri(ts, hash);
                     
        List<Comic> comics = rt.getForObject(uri, ComicResponse.class).getData().getResults();

        restTemplateRepository.saveAll(comics);

        return SICRONIZADO_COM_SUCESSO;
    }

    private String criotografia(Long ts) {
        String key = ts + PRIVATE_KEY + PUBLIC_KEY;

        String hash = DigestUtils.md5Hex(key);
        return hash;
    }

    public List<Comic> listarComics() {
        List<Comic> consulta = (List<Comic>) restTemplateRepository.findAll();

        return consulta;
    }

    private String uri(Long ts, String hash) {

        UriComponents uri = UriComponentsBuilder.newInstance().scheme("http")
                .host("gateway.marvel.com").path("/v1/public/comics").queryParam("ts", ts)
                .queryParam("apikey", PUBLIC_KEY).queryParam("hash", hash).build();

        return uri.toString();
    }
}
