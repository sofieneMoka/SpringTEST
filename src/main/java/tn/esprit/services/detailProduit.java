package tn.esprit.services;

import java.util.List;

import tn.esprit.model.DetailProduit;

public interface detailProduit {
    void addDetailProduit(DetailProduit detailProduit);
    DetailProduit getDetailProduitById(long id);
    List <DetailProduit> getAllDetailProduit();
    void deleteAllDetailProduit();
    void deleteDetailProduitById(long id);
    void updateDetailProduit(DetailProduit Dp);
}
