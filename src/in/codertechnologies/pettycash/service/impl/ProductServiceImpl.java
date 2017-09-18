package in.codertechnologies.pettycash.service.impl;

import java.util.List;

import in.codertechnologies.pettycash.dao.DailyDao;
import in.codertechnologies.pettycash.dao.ProductDao;
import in.codertechnologies.pettycash.dao.impl.DailyDaoImpl;
import in.codertechnologies.pettycash.dao.impl.ProductDaoImpl;
import in.codertechnologies.pettycash.dto.Product;
import in.codertechnologies.pettycash.exceptions.ProductNotFoundException;
import in.codertechnologies.pettycash.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private ProductDao productdao;
	
	public ProductServiceImpl()
	{
		productdao=new ProductDaoImpl();
	}
	@Override
	public boolean addpub(Product product) {
		// TODO Auto-generated method stub
		return productdao.addpub(product);
	}


	@Override
	public boolean updatepub(Product product) {
		// TODO Auto-generated method stub
		return productdao.updatepub(product);
	}

	@Override
	public boolean deletepub(int productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return productdao.deletepub(productId);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productdao.getAllProduct();
	}

	@Override
	public int getProductIdByProductName(String pName) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Product findpub(int productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return productdao.findpub(productId);
	}

}
