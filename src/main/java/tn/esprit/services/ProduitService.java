package tn.esprit.services;


import java.util.Date;
import java.util.List;

import tn.esprit.model.Produit;

public interface ProduitService {
    void addProduit(Produit produit);
    Produit getProduitById(long id);
    List <Produit> getAllProduit();
    void DeleteAllProduit();
    void DeleteProduitById(long id);
    void UpdateProduit(Produit p);
    float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
