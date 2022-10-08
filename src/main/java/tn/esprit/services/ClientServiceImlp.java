package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Repositories.ClientRepository;
import tn.esprit.model.Client;
@Service
public class ClientServiceImlp implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public void ajouterClient(Client client) {
		clientRepository.save(client);
		
	}

	@Override
	public Client chercherClientByID(long id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public void supprimerClient(long id) {
		clientRepository.deleteById(id);
		
	}

	@Override
	public void supprimerToutLesClients() {
		clientRepository.deleteAll();
		
	}

	@Override
	public List<Client> chercherClient() {
		List<Client> LC = new ArrayList<Client>();
		LC.addAll(clientRepository.findAll());
		return LC;
	}

	@Override
	public void updateClient(Client client) {
        clientRepository.save(client);
	}

}
