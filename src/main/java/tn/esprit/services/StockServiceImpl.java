package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.Repositories.StockRepository;
import tn.esprit.model.Stock;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements stockService{
    @Autowired
    StockRepository stockRepository;

    @Override
    public void addStock(Stock stock) {
        if(!stockRepository.findById(stock.getIdStock()).isPresent()){
            stockRepository.save(stock);
        }
    }

    @Override
    public Stock getStockById(long id) {
        return stockRepository.findById(id).get();
    }

    @Override
    public List<Stock> getAllStocks() {
    	List<Stock> ListStock =new ArrayList<Stock>();
    	ListStock.addAll(stockRepository.findAll());
        return ListStock;
    }

    @Override
    public void deleteStockById(long id) {
        stockRepository.deleteById(id);
    }

    @Override
    public void deleteAllStocks() {
        stockRepository.deleteAll();
    }


    @Override
    public void updateStock(Stock s) {
		stockRepository.save(s);
    }

    @Scheduled(fixedRate = 60000)
	@Override
	public void StatutStock() {
    	List<Stock> ListStock = new ArrayList<Stock>();
    	ListStock.addAll(getAllStocks());
    	for(int i=0;i<ListStock.size();i++) {
    		if(ListStock.isEmpty()) {
    			System.out.println("Aucun Stock");
    		}
    		else {
    			if((ListStock.get(i)).getQte()==0) {
    				System.out.println("Rupture du stock id = " + (ListStock.get(i)).getIdStock());
    			}else {
    				System.out.println("Stock id = " + (ListStock.get(i)).getIdStock()+ " N'est pas en rupture");
    			}
    		}
    	}
    }
}
