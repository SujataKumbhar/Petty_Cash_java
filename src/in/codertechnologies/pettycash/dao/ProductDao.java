package in.codertechnologies.pettycash.dao;

import java.util.List;


import in.codertechnologies.pettycash.dto.Product;
import in.codertechnologies.pettycash.exceptions.ProductNotFoundException;



public interface ProductDao {

	boolean addpub(Product product);
	Product findpub(int productId)throws ProductNotFoundException;
	boolean updatepub(Product product);
	boolean deletepub(int productId)throws ProductNotFoundException;
	
	List<Product> getAllProduct();
	int getProductIdByProductName(String pName);
	
	
	}
