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
import tn.esprit.model.Facture;
import tn.esprit.services.FactureServiceImpl;

@RestController
@RequestMapping("/api/Facture")
@Api(tags="Facture management")
public class FactureController {
	@Autowired
	FactureServiceImpl F;
	
	public FactureController(FactureServiceImpl F) {
		this.F=F;
	}
	
	@GetMapping("/AllFacture")
	@ResponseBody
	public List <Facture> getAllFacture(){
		return F.chercherFacture();
		}
	@GetMapping("/{id}")
	@ResponseBody
	public Facture getFactureById(@PathVariable long id) {
		return F.chercherFactureById(id);
	}
	@PostMapping("/AddFacture")
	@ResponseBody
		public String AddFacture(Facture f) {
			F.ajouterFacture(f);
			return "Facture add successfully !!";
		}
	@DeleteMapping("/DeleteAllFacture")
	@ResponseBody
		public String DeleteAllFacture() {
		F.supprimerToutLesFactures();
		return "All Facture are deleted successfully !!";
	}
	@DeleteMapping("/DeleteFactureById/{id}")
	@ResponseBody
	public String DeleteFactureById(@PathVariable long id) {
		F.supprimerFacture(id);
		return "Facture deleted successfully !!";
	}
	@PutMapping("UpdateFacture")
	@ResponseBody
	public String UpdateClient(Facture f) {
		F.updateFacture(f);
		return"Facture updated successfully !!";
	}
	@GetMapping("/{idClient}")
	@ResponseBody
	public List<Facture> getFacturesByClient(@PathVariable long idClient){
		return F.getFacturesByClient(idClient);
	}
	@PostMapping("/addFactureClient")
	public Facture addFacture(Facture f, Long idClient) {
		return F.addFacture(f, idClient);
	}
}
