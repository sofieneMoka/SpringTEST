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
import tn.esprit.model.DetailProduit;
import tn.esprit.services.detailProduitImpl;

@RestController
@RequestMapping("/api/DetailProduit")
@Api(tags="DetailProduit management")
public class DetailProduitController {

	@Autowired
	detailProduitImpl Dp;
	
	DetailProduitController(detailProduitImpl Dp){
		this.Dp=Dp;
	}
	@GetMapping("/AllDetailProduit")
	@ResponseBody
	public List <DetailProduit> getDetailProduit(){
		return Dp.getAllDetailProduit();
		}
	@GetMapping("/{id}")
	@ResponseBody
	public DetailProduit getDetailProduitById(@PathVariable long id) {
		return Dp.getDetailProduitById(id);
	}
	@PostMapping("/AddDetailProduitk")
	@ResponseBody
		public String AddDetailProduit(DetailProduit dp) {
			Dp.addDetailProduit(dp);
			return "DetailProduit add successfully !!";
		}
	@DeleteMapping("/DeleteAllDetailProduit")
	@ResponseBody
		public String DeleteAllDetailProduit() {
		Dp.deleteAllDetailProduit();
		return "All DetailProduit are deleted successfully !!";
	}
	@DeleteMapping("/DeleteDetailProduitById/{id}")
	@ResponseBody
	public String DeleteDetailProduitById(@PathVariable long id) {
		Dp.deleteDetailProduitById(id);
		return "DetailProduit deleted successfully !!";
	}
	@PutMapping("UpdateDetailProduit")
	@ResponseBody
	public String UpdateDetailProduit(DetailProduit s) {
		Dp.updateDetailProduit(s);
		return"DetailProduit updated successfully !!";
	}
	
}
