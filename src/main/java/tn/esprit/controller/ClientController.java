package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.model.Client;
import tn.esprit.services.ClientServiceImlp;

@RestController
@RequestMapping("/api/Client")
@Api(tags="Client management")
public class ClientController {

	@Autowired
	ClientServiceImlp C;
	
	public ClientController(ClientServiceImlp C) {
		this.C=C;
	}
	
	@GetMapping("/AllClient")
	@ResponseBody
	public List <Client> getAllClient(){
		return C.chercherClient();	
		}
	@GetMapping("/{id}")
	@ResponseBody
	public Client getClientById(@PathVariable long id) {
		return C.chercherClientByID(id);
	}
	@PostMapping("/AddClient")
	@ResponseBody
		public String AddClient(Client client) {
			C.ajouterClient(client);
			return "Client add successfully !!";
		}
	@DeleteMapping("/DeleteAllClient")
	@ResponseBody
		public String DeleteAllClient() {
		C.supprimerToutLesClients();
		return "All client are deleted successfully !!";
	}
	@DeleteMapping("/DeleteClientById/{id}")
	@ResponseBody
	public String DeleteClientById(@PathVariable long id) {
		C.supprimerClient(id);
		return "Client deleted successfully !!";
	}
	@PutMapping("UpdateClient")
	@ResponseBody
	public String UpdateClient(Client client) {
		C.updateClient(client);
		return"Client updated successfully !!";
	}
}
