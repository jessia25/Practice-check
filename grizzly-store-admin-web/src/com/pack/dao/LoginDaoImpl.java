package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pack.JdbcConnection;
import com.pack.model.Login;
import com.pack.model.Product;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean checkDetails(Login l) {
		// TODO Auto-generated method stub
		Connection con=null;
		boolean ans=false;
		try {
			con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select userid from admin where userid=? and password=?");
			ps.setInt(1,l.getUserId());
			ps.setString(2,l.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				ans=true;
		}
		catch(Exception e) {}
		return ans;
	}
	public int getCountValue(Login l) {
        int count=0;
        Connection con=null;
        try
        {
               con=JdbcConnection.getConnection();
               PreparedStatement ps=con.prepareStatement("select count from admin where userid=?");
               ps.setInt(1,l.getUserId());
               ResultSet rs=ps.executeQuery();
               if(rs.next())
               {
                     count=rs.getInt(1);
               }
               
        }
        catch(Exception e)
        {
               System.out.println(e);
        }
        
        return count;

	}
	public int incrementCount(Login l, int count) {
		// TODO Auto-generated method stub
        Connection con=null;
        int c=0;
        try
        {
               con=JdbcConnection.getConnection();
               PreparedStatement ps=con.prepareStatement("update  admin set count=? where userid=?");
               ps.setInt(1,count+1);
               ps.setInt(2, l.getUserId());
               c=ps.executeUpdate();
               
        }
        catch(Exception e)
        {
               System.out.println(e);
        }
        return c;

	}
	public int setZeroCount(Login l) {
		// TODO Auto-generated method stub
		Connection con=null;
        int c=0;
        try
        {
               con=JdbcConnection.getConnection();
               PreparedStatement ps=con.prepareStatement("update  admin set count=0 where userid=?");
               ps.setInt(1, l.getUserId());
               c=ps.executeUpdate();
               
        }
        catch(Exception e)
        {
               System.out.println(e);
        }
        return c;

	}
	public int insertProduct(Product p) {
		Connection con=null;
		int i=0;
		try
		{
			con=JdbcConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, p.getPid());
			ps.setString(2, p.getCategory());
			ps.setString(3, p.getPname());
			ps.setString(4,p.getDescription());
			ps.setFloat(5, p.getPrice());
			ps.setString(6, "samsung");
			ps.setFloat(7,(float) (4.5));
			ps.setString(8,"50%");
			ps.setInt(9,0);
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con!=null){
					con.close();
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		return i;
	}

	public List<Product> fetchProducts() {
		Connection con=null;
		List<Product> l=new ArrayList<>();
		try {
			con=JdbcConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select pname,brand,category,rating from product");
			System.out.println(rs);
			while(rs.next()) {
				Product p=new Product();
				p.setPname(rs.getString(1));
				p.setBrand(rs.getString(2));
				p.setCategory(rs.getString(3));
				p.setRating(rs.getFloat(4));
				l.add(p);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		
		return l;
	}
	public Product fetchProduct(String pname) {
		// TODO Auto-generated method stub
		//System.out.println("hello");
		Product p=null;
		Connection con=null;
		try {
		con=JdbcConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select pname,brand,rating,description,price,discount from product where pname=?");
		ps.setString(1, pname);
		ResultSet rs=ps.executeQuery();
		//System.out.println(rs);
		while(rs.next()) {
			p=new Product();
			p.setPname(rs.getString(1));
			p.setBrand(rs.getString(2));
			p.setRating(rs.getFloat(3));
			p.setDescription(rs.getString(4));
			p.setPrice(rs.getInt(5));
			p.setDiscount(rs.getString(6));
			
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		return p;
	}

	public int deleteProduct(String pname) {
		//System.out.println(pname);
		Connection con=null;
		int i=0;
		try {
		 con=JdbcConnection.getConnection();
		 //System.out.println("hello");
		PreparedStatement ps=con.prepareStatement("delete from product where pname=?");
		ps.setString(1,pname);
		System.out.println(ps);
		i=ps.executeUpdate();
		System.out.println(i);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		
		return i;
	}
	@Override
	public String getUsername(Login l) {
		// TODO Auto-generated method stub
		String username;
		Connection con=null;
		try {
		con=JdbcConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select username from profile where userid=?");
		ps.setInt(1, l.getUserId());
		ResultSet rs=ps.executeQuery();
		//System.out.println(rs);
		if(rs.next()) {
			l.setUsername(rs.getString(1));
			
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		username=l.getUsername();
		return username;
	}
	@Override
	public String getDesignation(Login l) {
		String designation;
		Connection con=null;
		try {
		con=JdbcConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select designation from profile where userid=?");
		ps.setInt(1, l.getUserId());
		ResultSet rs=ps.executeQuery();
		//System.out.println(rs);
		if(rs.next()) {
			l.setDesignation(rs.getString(1));
			
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		designation=l.getDesignation();
		return designation;
	}
	@Override
	public String getOffice(Login l) {
		String office;
		Connection con=null;
		try {
		con=JdbcConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select office from profile where userid=?");
		ps.setInt(1, l.getUserId());
		ResultSet rs=ps.executeQuery();
		//System.out.println(rs);
		if(rs.next()) {
			l.setOffice(rs.getString(1));
			
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				if(con!=null) {
					con.close();
				}
			}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		office=l.getOffice();
		return office;
	}

}
