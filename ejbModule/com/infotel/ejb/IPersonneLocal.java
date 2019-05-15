package com.infotel.ejb;

import java.util.List;

import javax.ejb.Local;

import com.infotel.metier.Lotissement;
import com.infotel.metier.Personne;

@Local
public interface IPersonneLocal {
	
	public void ajouterPersonne(Personne p);
	public List<Personne> findAllPersonne();
	public void modifierPersonne(Personne p);
	public void supprimerPersonne(Personne p);
	public Personne getPersonne(Long idPersonne);
	public Personne affichagePersonne(Long idPersonne);
	
	public void ajouterLotissement(Lotissement l);
	public List<Lotissement> findAllLotissement();
	public void modifierLotissement(Lotissement l);
	public void supprimerLotissement(Lotissement l);
	public Lotissement getLotissement(Long idLot);
	public Lotissement affichageLotissement(Long idLot);
	
	
	
	public void acheterLotissement(Personne p, Lotissement l);
	public void seMarier (Personne p1, Personne p2);

}
