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
import tn.esprit.model.DetailFacture;
import tn.esprit.services.DetailFactureImpl;
@RestController
@RequestMapping("/api/detailfacture")
@Api(tags ="DetailFacture  management")
public class DetailFactureController {

	@Autowired
	DetailFactureImpl D;
	
	public DetailFactureController(DetailFactureImpl D) {
		this.D=D;
	}
	
	@GetMapping("/AllDetailFacture")
	@ResponseBody
	public List <DetailFacture> getAllDetailFacture(){
		return D.getAllDetailFacture();
		}
	@GetMapping("/{id}")
	@ResponseBody
	public DetailFacture getDetailFactureById(@PathVariable long id) {
		return D.getDetailFacture(id);
	}
	@PostMapping("/AddDetailFacture")
	@ResponseBody
		public String AddDetailFacture(DetailFacture df) {
			D.AddDetailFacture(df);
			return "DetailFacture add successfully !!";
		}
	@DeleteMapping("/DeleteAllDetailFacture")
	@ResponseBody
		public String DeleteAllDetailFacture() {
		D.supprimerToutLesDetailsFactures();
		return "All DetailFacture are deleted successfully !!";
	}
	@DeleteMapping("/DeleteDetailFactureById/{id}")
	@ResponseBody
	public String DeleteDetailFactureById(@PathVariable long id) {
		D.supprimerDetailFacture(id);
		return "DetailFacture deleted successfully !!";
	}
	@PutMapping("UpdateDetailFacture")
	@ResponseBody
	public String UpdateDetailFacture(DetailFacture df) {
		D.updateDetailFacture(df);
		return"DetailFacture updated successfully !!";
	}

}
