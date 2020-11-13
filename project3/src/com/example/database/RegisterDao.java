package com.example.database;

import javax.transaction.SystemException;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.example.product.Product;
import com.example.util.HibernateUtil;



public class RegisterDao {

	
		
	public void insert(Product product) throws IllegalStateException, SystemException  {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(product);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public int validate(Product product) throws IllegalStateException, SystemException {
		Transaction transaction = null;
		//Product product1=null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Product product1 = session.get(Product.class, product.getBarcode());
			if(product1 !=null) {
				transaction.commit();
				return(0);
			}
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return (1);
	}
	
	
}
