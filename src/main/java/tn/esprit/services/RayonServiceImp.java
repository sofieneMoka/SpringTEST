package tn.esprit.services;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repositories.FourniseurRepository;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.Repositories.RayonRepository;
import tn.esprit.Repositories.StockRepository;
import tn.esprit.model.Fournisseur;
import tn.esprit.model.Produit;
import tn.esprit.model.Rayon;
import tn.esprit.model.Stock;

@Service
public class RayonServiceImp implements RayonService{
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ProduitRepository produitRepository;
    FourniseurRepository fourniseurRepository;

    @Override
    public void addRayon(Rayon rayon) {
        if(!rayonRepository.findById(rayon.getIdRayon()).isPresent()){
            rayonRepository.save(rayon);
        }else{
            System.out.println("Rayon existe déja");
        }
    }

    @Override
    public Rayon getRayonById(long id) {
        return rayonRepository.findById(id).get();
    }

	@Override
	public List<Rayon> getAllRayon() {
		List<Rayon> ListRayon = new ArrayList<Rayon>();
		ListRayon.addAll(rayonRepository.findAll());
		return ListRayon;
	}

	@Override
	public void DeleteRayon(long id) {
		rayonRepository.deleteById(id);
		
	}

	@Override
	public void DeleteAllRayon() {
		rayonRepository.deleteAll();
		
	}

	@Override
	public void UpdateRayon(Rayon rayon) {
		rayonRepository.save(rayon);
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit P1 = produitRepository.findById(idProduit).get();
		Stock S1 = stockRepository.findById(idStock).get();
		P1.setStock(S1);
		produitRepository.save(P1);
		S1.setQte(S1.getQte()+1);
		stockRepository.save(S1);
	}

	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Fournisseur F1 =fourniseurRepository.findById(fournisseurId).get();
		Produit P1 = produitRepository.findById(produitId).get();
		Set<Fournisseur> hashSet = new HashSet<>();
		hashSet.add(F1);
		P1.setFournisseurProduit(hashSet);
		produitRepository.save(P1);
	}
}
