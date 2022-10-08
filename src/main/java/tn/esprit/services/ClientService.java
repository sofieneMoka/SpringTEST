package tn.esprit.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.model.Client;

public interface ClientService {
	void ajouterClient(Client client);
    Client chercherClientByID(long id);
    void supprimerClient(long id);
    void supprimerToutLesClients();
    List<Client> chercherClient();
    void  updateClient(Client client);

}
