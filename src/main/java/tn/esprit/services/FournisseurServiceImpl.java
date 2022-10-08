package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.FourniseurRepository;
import tn.esprit.model.Fournisseur;

@Service
public class FournisseurServiceImpl implements FournisseurService{
    @Autowired
    FourniseurRepository fourniseurRepository;
    @Override
    public void addFournisseur(Fournisseur fournisseur) {
        if(!fourniseurRepository.findById(fournisseur.getIdFournisseur()).isPresent()){
            fourniseurRepository.save(fournisseur);
        }else{
            System.out.println("Fournisseur existe déja");
        }
    }

    @Override
    public Fournisseur getFournisseurById(long id) {
        return fourniseurRepository.findById(id).get();
    }
    
    @Override
    public List<Fournisseur> getAllFournisseur() {
    	List<Fournisseur> LF = new ArrayList<Fournisseur>();
    	LF.addAll(fourniseurRepository.findAll());
    	return LF;
    }

    @Override
    public void DeleteFournisseur(long id) {
    	fourniseurRepository.deleteById(id);
    }
    
    @Override
    public void updateFournisseur(Fournisseur fournisseur) {
        fourniseurRepository.save(fournisseur);
    }
    
    @Override
    public void DeleteAllFournisseur() {
    	fourniseurRepository.deleteAll();
    }

}
