package tn.esprit.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.DetailFactureRepository;
import tn.esprit.model.DetailFacture;

@Service
public class DetailFactureImpl implements DetailFactureService{

    @Autowired
    DetailFactureRepository detailFactureRepository;


    @Override
    public void AddDetailFacture(DetailFacture detailFacture) {
        if(!detailFactureRepository.findById(detailFacture.getIdDetailFacture()).isPresent()){
            detailFactureRepository.save(detailFacture);
        }else{
            System.out.println("Detail Facture Existe déja !!");
        }
    }

    @Override
    public DetailFacture getDetailFacture(long id) {
        return detailFactureRepository.findById(id).get();
    }

	@Override
	public void supprimerDetailFacture(long id) {
		detailFactureRepository.deleteById(id);
	}

	@Override
	public void supprimerToutLesDetailsFactures() {
		detailFactureRepository.deleteAll();	
	}

	@Override
	public List<DetailFacture> getAllDetailFacture() {
		List<DetailFacture>LDF = new ArrayList<DetailFacture>();
		LDF.addAll(detailFactureRepository.findAll());
		return LDF;
	}

	@Override
	public void updateDetailFacture(DetailFacture d) {
        detailFactureRepository.save(d);
	}

	@Override
	public Float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		return detailFactureRepository.getRevenuBrutProduit(idProduit,startDate,endDate);
	}
}
