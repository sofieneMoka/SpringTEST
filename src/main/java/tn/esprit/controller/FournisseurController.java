package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import tn.esprit.model.Fournisseur;
import tn.esprit.services.FournisseurServiceImpl;


@RestController
@RequestMapping("/api/fournisseur")
@Api(tags="Fournisseur management")
public class FournisseurController {
	
	
	@Autowired
	private FournisseurServiceImpl F;
	
	public FournisseurController(FournisseurServiceImpl F) {
		this.F=F;
	}

	
	@GetMapping("/AllFournisseur")
	@ResponseBody
	public List <Fournisseur> getAllFournisseur(){
		return F.getAllFournisseur();
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public Fournisseur findById(@PathVariable long id) {
		return F.getFournisseurById(id);
	}
	
	@PostMapping("/AddFournisseur")
	@ResponseBody
	public String AddFournisseur(@RequestBody Fournisseur fournisseur) {
		F.addFournisseur(fournisseur);
		return "Fournisseur add successfully!!";
	}
	
	@DeleteMapping("/DeleteFournisseur/{id}")
	@ResponseBody
	public String DeleteFournisseur(@PathVariable long id) {
		F.DeleteFournisseur(id);
		return "Fournisseur Deleted successfully !!";
	}
	
    @DeleteMapping("/updateFournisseur")
    @ResponseBody
    public String UpdateUser(@RequestBody Fournisseur fournisseur){
    
        F.updateFournisseur(fournisseur);
        return "Fournisseur updated successfuly Don !!";
    }
    
    @PutMapping("/DeleteAllFournisseur")
    @ResponseBody
    public String DeleteAllFournisseur() {
    	F.DeleteAllFournisseur();
    	return "All Fournisseur are deleted successfully !!";
    }
}
