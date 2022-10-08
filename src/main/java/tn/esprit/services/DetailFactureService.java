package tn.esprit.services;

import java.util.Date;
import java.util.List;

import tn.esprit.model.DetailFacture;


public interface DetailFactureService {
    void AddDetailFacture(DetailFacture detailFacture);
    DetailFacture getDetailFacture(long id);
    void supprimerDetailFacture(long id);
    void supprimerToutLesDetailsFactures();
    List<DetailFacture> getAllDetailFacture();
    void  updateDetailFacture(DetailFacture d);
    public Float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
