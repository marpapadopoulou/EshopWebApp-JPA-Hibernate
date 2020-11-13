package com.example.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.database.RegisterDao;
import com.example.product.Product;

@WebServlet("/RegisterProduct")
public class connect_servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RegisterDao regDao;
	int res;
	
	public void init() {
		regDao= new RegisterDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			insertProduct(request,response);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			 //fetch product data from registration page
	        String barcode = request.getParameter("barcode");
	        String name = request.getParameter("name");
	        String color = request.getParameter("color");
	        String description = request.getParameter("description");
			
	      //create product model
	        Product product = new Product();
	        product.setBarcode(barcode);
	        product.setName(name);
	        product.setColor(color);
	        product.setDescription(description);
	        
	        res=regDao.validate(product);
	        
	        if(res==1) {
	        	regDao.insert(product);
	        	
	        	//fetch attributes
			    request.setAttribute("barcode", request.getParameter("barcode"));
			    request.setAttribute("name", request.getParameter("name") );
			    request.setAttribute("color", request.getParameter("color"));
			    request.setAttribute("description", request.getParameter("description") );
			    
			    request.getRequestDispatcher("/success.jsp").forward(request, response);
	        }
	        else {
	        	response.sendRedirect("error.jsp");
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}