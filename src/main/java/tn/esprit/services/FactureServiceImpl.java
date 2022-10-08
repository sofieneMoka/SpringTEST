package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.Repositories.ClientRepository;
import tn.esprit.Repositories.DetailFactureRepository;
import tn.esprit.Repositories.FactureRepository;
import tn.esprit.model.Client;
import tn.esprit.model.DetailFacture;
import tn.esprit.model.Facture;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FactureServiceImpl implements FactureService{

    private static final HashSet<Object> Facture = null;
	@Autowired
    private FactureRepository factureRepository;
    private ClientRepository clientRepository;
    private DetailFactureRepository detailFactureRepository;

    @Override
    public void ajouterFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public void supprimerFacture(long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public void supprimerToutLesFactures() {
        factureRepository.deleteAll();
    }

    @Override
    public List<Facture> chercherFacture() {
    	List<Facture> LF = new ArrayList<Facture>();
    	LF.addAll((factureRepository.findAll()));
    	return LF;
    }

	@Override
	public Facture chercherFactureById(long id) {
		return factureRepository.findById(id).get();
	}

	@Override
	public void updateFacture(Facture f) {
        factureRepository.save(f);
	}

	@Override
	public List<Facture> getFacturesByClient(Long idClient) {
		
		ArrayList<Facture> FactureClient = new ArrayList<Facture>();
		FactureClient.add(factureRepository.getById(idClient));
		return FactureClient;
	}

	@Override
	public Facture addFacture(Facture f, Long idClient) {
		Client C1 = clientRepository.findById(idClient).get();
		DetailFacture DF1 = new DetailFacture();
		f.setClient(C1);
		f.setMontantFacture(500);
		f.setMontantRemise(100);
		f.setDateFacture(new Date(System.currentTimeMillis()));
		
		DF1.setFacture(f);
		DF1.setDateCreation(f.getDateFacture());
		DF1.setDateDernierModification(new Date(System.currentTimeMillis()));
		
		detailFactureRepository.save(DF1);
		return factureRepository.save(f);
	}

	@Scheduled(cron = "* * * 1 1 *")
	@Override
	public void RevenuMagasin() {
		List<Facture> LF = new ArrayList<Facture>();
		LF.addAll(factureRepository.findAll());
		float somme=0;
		for (int i=0;i<LF.size();i++)
		{
			somme = somme + LF.get(i).getMontantFacture() - LF.get(i).getMontantRemise();
		}
		System.out.println("Revenu de la magasin = " + somme + "dt");
	}
}
