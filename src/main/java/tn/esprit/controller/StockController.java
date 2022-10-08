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
import tn.esprit.model.Stock;
import tn.esprit.services.StockServiceImpl;

@RestController
@RequestMapping("/api/Stock")
@Api(tags="Stock management")
public class StockController {
	
	@Autowired
	StockServiceImpl S;
	
	public StockController(StockServiceImpl S) {
		this.S=S;
	}
	
	@GetMapping("/AllStock")
	@ResponseBody
	public List <Stock> getAllStock(){
		return S.getAllStocks();
		}
	@GetMapping("/{id}")
	@ResponseBody
	public Stock getStockById(@PathVariable long id) {
		return S.getStockById(id);
	}
	@PostMapping("/AddStock")
	@ResponseBody
		public String AddStock(Stock s) {
			S.addStock(s);
			return "Stock add successfully !!";
		}
	@DeleteMapping("/DeleteAllStock")
	@ResponseBody
		public String DeleteAllStock() {
		S.deleteAllStocks();
		return "All Stock are deleted successfully !!";
	}
	@DeleteMapping("/DeleteStockById/{id}")
	@ResponseBody
	public String DeleteStockById(@PathVariable long id) {
		S.deleteStockById(id);
		return "Stock deleted successfully !!";
	}
	@PutMapping("/UpdateStock")
	@ResponseBody
	public String UpdateClient(Stock s) {
		S.updateStock(s);
		return"Stock updated successfully !!";
	}
	@GetMapping("/StatutStock")
	@ResponseBody
	public void StatutStock() {
		S.StatutStock();
	}

}
