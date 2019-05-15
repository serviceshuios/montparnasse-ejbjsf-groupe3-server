package com.infotel.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infotel.metier.Lotissement;
import com.infotel.metier.Personne;
@Singleton
public class DaoImpl implements IdaoLocal, IdaoRemote {
	
	@PersistenceContext(unitName="BP_UNIT")
    private EntityManager em;
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void ajouterPersonne(Personne p) {
		// TODO Auto-generated method stub
         em.persist(p);
	}

	@Override
	public List<Personne> findAllPersonne() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Personne p").getResultList();
	}

	@Override
	public void modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		em.merge(p);
	}

	@Override
	public void supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		em.remove(p);
	}

	@Override
	public Personne getPersonne(Long idPersonne) {
		// TODO Auto-generated method stub
		return em.getReference(Personne.class, idPersonne);
	}

	@Override
	public Personne affichagePersonne(Long idPersonne) {
		// TODO Auto-generated method stub
		return em.find(Personne.class, idPersonne);
	}

	@Override
	public void ajouterLotissement(Lotissement l) {
		// TODO Auto-generated method stub
		em.persist(l);
	}

	@Override
	public List<Lotissement> findAllLotissement() {
		// TODO Auto-generated method stub
		return em.createQuery("select l from Lotissement l").getResultList();
	}

	@Override
	public void modifierLotissement(Lotissement l) {
		// TODO Auto-generated method stub
		em.merge(l);
	}

	@Override
	public void supprimerLotissement(Lotissement l) {
		// TODO Auto-generated method stub
		em.remove(l);
	}

	@Override
	public Lotissement getLotissement(Long idLot) {
		// TODO Auto-generated method stub
		return em.getReference(Lotissement.class, idLot);
	}

	@Override
	public Lotissement affichageLotissement(Long idLot) {
		// TODO Auto-generated method stub
		return em.find(Lotissement.class, idLot);
	}

	@Override
	public void acheterLotissement(Personne p, Lotissement l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void seMarier(Personne p1, Personne p2) {
		// TODO Auto-generated method stub

	}

}
