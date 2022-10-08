package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.DetailProduitRepository;
import tn.esprit.model.DetailProduit;
import tn.esprit.model.Facture;

@Service
public class detailProduitImpl implements detailProduit{
    @Autowired
    DetailProduitRepository detailProduitRepository;
    @Override
    public void addDetailProduit(DetailProduit detailProduit) {
        if(!detailProduitRepository.findById(detailProduit.getIdDetailProduit()).isPresent()){
            detailProduitRepository.save(detailProduit);
        }else{
            System.out.println("Detail Produit existe déja !!");
        }
    }

    @Override
    public DetailProduit getDetailProduitById(long id) {
        return detailProduitRepository.findById(id).get();
    }

	@Override
	public List<DetailProduit> getAllDetailProduit() {
		List<DetailProduit> LDP = new ArrayList<DetailProduit>();
    	LDP.addAll((detailProduitRepository.findAll()));
    	return LDP;
	}

	@Override
	public void deleteAllDetailProduit() {
		detailProduitRepository.deleteAll();
		
	}

	@Override
	public void deleteDetailProduitById(long id) {
		detailProduitRepository.deleteById(id);
	}

	@Override
	public void updateDetailProduit(DetailProduit Dp) {
		detailProduitRepository.save(Dp);
	}
}
