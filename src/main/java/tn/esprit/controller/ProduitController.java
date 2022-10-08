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
import tn.esprit.model.Produit;
import tn.esprit.services.ProduitServiceImpl;

@RestController
@RequestMapping("/api/Produit")
@Api(tags="Produit management")
public class ProduitController {

	@Autowired
	ProduitServiceImpl P;
	
	public ProduitController(ProduitServiceImpl P) {
		this.P=P;
	}
	
	@GetMapping("/AllProduit")
	@ResponseBody
	public List <Produit> getAllProduit(){
		return P.getAllProduit();
		}
	@GetMapping("/{id}")
	@ResponseBody
	public Produit getProduitById(@PathVariable long id) {
		return P.getProduitById(id);
	}
	@PostMapping("/AddProduit")
	@ResponseBody
		public String AddProduit(Produit produit) {
			P.addProduit(produit);
			return "Produit add successfully !!";
		}
	@DeleteMapping("/DeleteAllProduit")
	@ResponseBody
		public String DeleteAllProduit() {
		P.DeleteAllProduit();
		return "All Produit are deleted successfully !!";
	}
	@DeleteMapping("/DeleteProduitById/{id}")
	@ResponseBody
	public String DeleteProduitById(@PathVariable long id) {
		P.DeleteProduitById(id);
		return "Produit deleted successfully !!";
	}
	@PutMapping("UpdateProduit")
	@ResponseBody
	public String UpdateProduit(Produit produit) {
		P.UpdateProduit(produit);
		return"Produit updated successfully !!";
	}
}
