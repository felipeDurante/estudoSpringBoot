package br.com.tomCat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tomCat.entitys.PdvEntity;

@Repository
public interface PdvRepository extends CrudRepository<PdvEntity, Long> {

	Iterable<PdvRepository> findByCdDddRegiao(String dddRegiao);
	
	
}
