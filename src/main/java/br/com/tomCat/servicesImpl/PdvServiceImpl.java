//package br.com.tomCat.servicesImpl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//
//import org.springframework.stereotype.Service;
//
//import br.com.tomCat.entitys.PdvEntity;
//import br.com.tomCat.services.PdvService;
//
//@Service
//public class PdvServiceImpl implements PdvService {
//
//	@PersistenceContext
//	private EntityManager em;
//
//	@Override
//	public List<PdvEntity> getThenPdv() {
//		TypedQuery<PdvEntity> query = em.createQuery("pdv from PdvEntity pdv", PdvEntity.class);
//		query.setMaxResults(10);
//		List<PdvEntity> lista = query.getResultList();
//		return lista;
//	}
//
//}
