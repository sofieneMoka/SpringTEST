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
import tn.esprit.model.Rayon;
import tn.esprit.services.RayonServiceImp;

@RestController
@RequestMapping("api/Rayon")
@Api(tags="Rayon management")
public class RayonController {
	
	@Autowired
	RayonServiceImp R;
	
	public RayonController(RayonServiceImp R) {
		this.R=R;
	}
	
	@GetMapping("/AllRayon")
	@ResponseBody
	public List <Rayon> getAllRayon(){
		return R.getAllRayon();	
		}
	@GetMapping("/{id}")
	@ResponseBody
	public Rayon getRayonById(@PathVariable long id) {
		return R.getRayonById(id);
	}
	@PostMapping("/AddRayon")
	@ResponseBody
		public String AddRayon(Rayon rayon) {
			R.addRayon(rayon);
			return "Rayon add successfully !!";
		}
	@DeleteMapping("/DeleteAllRayon")
	@ResponseBody
		public String DeleteAllRayon() {
		R.DeleteAllRayon();
		return "All rayon are deleted successfully !!";
	}
	@DeleteMapping("/DeleteRayonById/{id}")
	@ResponseBody
	public String DeleteRayonById(@PathVariable long id) {
		R.DeleteRayon(id);
		return "Rayon deleted successfully !!";
	}
	@PutMapping("UpdateRayon")
	@ResponseBody
	public String UpdateRayon(Rayon rayon) {
		R.UpdateRayon(rayon);
		return"Rayon updated successfully !!";
	}
	@PutMapping("AssignProduitToStock")
	@ResponseBody
	public void assignProduitToStock(Long idProduit, Long idStock) {
		R.assignProduitToStock(idProduit, idStock);
	}
	@PutMapping("AssignFournisseurToProduit")
	@ResponseBody
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		R.assignFournisseurToProduit(fournisseurId, produitId);
	}

}
