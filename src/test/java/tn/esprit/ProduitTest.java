package tn.esprit;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.Repositories.FourniseurRepository;
import tn.esprit.model.*;
import tn.esprit.services.*;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class ProduitTest {
    @Autowired
    FourniseurRepository fourniseurRepository;

    @Autowired
    ProduitServiceImpl produitService;

    @Autowired
    detailProduitImpl detailProduitService;



    @Autowired
    RayonServiceImp rayonServiceImp;

    @Autowired
    DetailFactureImpl detailFactureImpl;


    @Autowired
    StockServiceImpl stockServiceImpl;

    @Autowired
    FournisseurServiceImpl fournisseurService;


    @Test
    public void Test(){
        //!!!!!!!!!!!!!Noté Bien changer les Ids pour les quatre instructions suivantes selon les valeurs de la base !!!!
        //!!!!!! Il faut exécutez-les teste detail Produit, Rayon, Detail Facture, Stock avant de tester cette classe!!!!



        /*Add Detail product*/
        DetailProduit detailProduit=detailProduitService.getDetailProduitById(3);

        //*******************************************************************
        //Add Rayon =================
        Rayon r=rayonServiceImp.getRayonById(6);

        //================================================
        //detail Facture ==============
        DetailFacture d=detailFactureImpl.getDetailFacture(2);

        //==============================
        //Add Stock =======================
        Stock s=stockServiceImpl.getStockById(7);

        // Produit ==========================
        Produit p=new Produit();
        Fournisseur fournisseur=fourniseurRepository.findById(5L).get();
        Set<Fournisseur> f = new HashSet<Fournisseur>();
        f.add(fournisseur);
        p.setIdprixUnitaire(2);
        p.setCode("6963");
        p.setIdlibelle("aliii");
        p.setIdprixUnitaire(100);
        p.setRayon(r);
        p.setDetailProduit(detailProduit);
        p.setDetailFacture(d);
        p.setStock(s);
        p.setFournisseurProduit(f);
        produitService.addProduit(p);

    }
}
