package com.infotel.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public void supprimerPersonne(Long idPersonne) {
		Query q = null;
		q = em.createQuery("DELETE FROM Personne p WHERE p.idPersonne = :id").setParameter("id", idPersonne);
		idPersonne = (long) q.executeUpdate();
		
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
	public void supprimerLotissement(Long idLot) {
		Query q = null;
		q=em.createQuery("DELETE FROM Lotissement l WHERE l.idLot = :id").setParameter("id", idLot);
		idLot = (long) q.executeUpdate();
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
	public void acheterLotissement(Long idPersonne, Long idLot) {
		Query q = null;
		q=em.createQuery("UPDATE Lotissement l SET l.personne.idPersonne = :x WHERE l.idLot = :y").setParameter("x", idPersonne).setParameter("y", idLot);
		idLot= (long) q.executeUpdate();
	}

	@Override
	public void seMarier(Long idPersonne1, Long idPersonne2) {
		Query q = null;
		q=em.createQuery("UPDATE Personne SET personne_idpersonne =:x WHERE idPersonne = :y").setParameter("x", idPersonne2).setParameter("y", idPersonne1);
		idPersonne1 = (long) q.executeUpdate();
		q=em.createQuery("UPDATE Personne SET personne_idpersonne =:x WHERE idPersonne = :y").setParameter("x", idPersonne1).setParameter("y", idPersonne2);
		
		idPersonne2 = (long) q.executeUpdate();
	}

}
