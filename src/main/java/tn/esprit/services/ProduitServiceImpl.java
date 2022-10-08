package tn.esprit.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.model.Produit;

@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public void addProduit(Produit produit) {
        produitRepository.save(produit);


    }

    @Override
    public Produit getProduitById(long id) {
        return  produitRepository.findById(id).get();
    }

	@Override
	public List<Produit> getAllProduit() {
		List<Produit> LP = new ArrayList<Produit>();
		LP.addAll(produitRepository.findAll());
		return LP;
	}

	@Override
	public void DeleteAllProduit() {
		produitRepository.deleteAll();
		
	}

	@Override
	public void DeleteProduitById(long id) {
		produitRepository.deleteById(id);
		
	}

	@Override
	public void UpdateProduit(Produit p) {
		produitRepository.save(p);
	}

	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
}
