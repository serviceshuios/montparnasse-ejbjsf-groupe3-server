package com.infotel.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.infotel.dao.IdaoRemote;
import com.infotel.metier.Lotissement;
import com.infotel.metier.Personne;

@Stateless(name="Personne")
public class PersonneEjbImpl implements IPersonneLocal, IPersonneRemote {
	
	@EJB
	private IdaoRemote dao;
	
	public IdaoRemote getDao() {
		return dao;
	}

	public void setDao(IdaoRemote dao) {
		this.dao = dao;
	}

	@Override
	public void ajouterPersonne(Personne p) {
		dao.ajouterPersonne(p);

	}

	@Override
	public List<Personne> findAllPersonne() {
		// TODO Auto-generated method stub
		return dao.findAllPersonne();
	}

	@Override
	public void modifierPersonne(Personne p) {
		dao.modifierPersonne(p);

	}

	@Override
	public void supprimerPersonne(Long idPersonne) {
		dao.supprimerPersonne(idPersonne);

	}

	@Override
	public Personne getPersonne(Long idPersonne) {
		// TODO Auto-generated method stub
		return dao.getPersonne(idPersonne);
	}

	@Override
	public Personne affichagePersonne(Long idPersonne) {
		// TODO Auto-generated method stub
		return dao.affichagePersonne(idPersonne);
	}

	@Override
	public void ajouterLotissement(Lotissement l) {
		dao.ajouterLotissement(l);

	}

	@Override
	public List<Lotissement> findAllLotissement() {
		// TODO Auto-generated method stub
		return dao.findAllLotissement();
	}

	@Override
	public void modifierLotissement(Lotissement l) {
		dao.modifierLotissement(l);

	}

	@Override
	public void supprimerLotissement(Long idLot) {
		dao.supprimerLotissement(idLot);

	}

	@Override
	public Lotissement getLotissement(Long idLot) {
		// TODO Auto-generated method stub
		return dao.getLotissement(idLot);
	}

	@Override
	public Lotissement affichageLotissement(Long idLot) {
		// TODO Auto-generated method stub
		return dao.affichageLotissement(idLot);
	}

	@Override
	public void acheterLotissement(Long idPersonne, Long idLot) {
		dao.acheterLotissement(idPersonne, idLot);;

	}

	@Override
	public void seMarier(Long idPersonne1, Long idPersonne2) {
		dao.seMarier(idPersonne1, idPersonne2);
		
	}

}
