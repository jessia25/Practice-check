package com.pack.service;

import java.util.List;


import com.pack.dao.LoginDaoImpl;
import com.pack.model.Login;
import com.pack.model.Product;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean checkDetails(Login l) {
		// TODO Auto-generated method stub
		boolean i=new LoginDaoImpl().checkDetails(l); 
		return i;
	}

	
	public int getCountValue(Login l) {
		// TODO Auto-generated method stub
        int i=new LoginDaoImpl().getCountValue(l); 
        return i;
	}


	public int incrementCount(Login l, int count) {
		// TODO Auto-generated method stub
		int i=new LoginDaoImpl().incrementCount(l,count); 
        return i;
	}


	public int setZeroCount(Login l) {
		// TODO Auto-generated method stub
		int i=new LoginDaoImpl().setZeroCount(l); 
        return i;
	}


	@Override
	public int insertProduct(Product p) {
		// TODO Auto-generated method stub
		int i=new LoginDaoImpl().insertProduct(p);
		return i;
	}


	public List<Product> fetchProducts() {
		// TODO Auto-generated method stub
		List<Product> l=new LoginDaoImpl().fetchProducts();
		return l;
	}


	@Override
	public Product fetchProduct(String pname) {
		Product p=new LoginDaoImpl().fetchProduct(pname);
		return p;
	}

	public int deleteProduct(String pname) {
		// TODO Auto-generated method stub
		int i=new LoginDaoImpl().deleteProduct(pname);
		return i;
	}


	@Override
	public String getUsername(Login l) {
		// TODO Auto-generated method stub
		String username=new LoginDaoImpl().getUsername(l);
		return username;
	}


	@Override
	public String getDesignation(Login l) {
		String designation=new LoginDaoImpl().getDesignation(l);
		return designation;
	}


	@Override
	public String getOffice(Login l) {
		// TODO Auto-generated method stub
		String office=new LoginDaoImpl().getOffice(l); 
		return office;
	}

}
