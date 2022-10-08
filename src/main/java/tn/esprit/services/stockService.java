package tn.esprit.services;

import tn.esprit.model.Stock;

import java.util.List;

public interface stockService {

     void addStock(Stock stock);
     Stock getStockById(long id);
     List<Stock> getAllStocks();
     void deleteStockById(long id);
     void deleteAllStocks();
     void updateStock(Stock stock);
     void StatutStock();
}
