package br.com.zup.estrelas.resttemplate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.zup.estrelas.resttemplate.entity.Comic;

@Repository
public interface RestTemplateRepository extends CrudRepository<Comic, Long> { 

}
