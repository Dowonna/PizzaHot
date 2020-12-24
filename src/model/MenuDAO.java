package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.Menu;
import model.util.PublicCommon;

public class MenuDAO {
	
//	public static void main(String[] args) {
//		try {
//			addMenu(new Menu("Margherita", "Fresh tomatoes, fresh mozzarella, fresh basil","none","pizza",12.5));
//			addMenu(new Menu("Formaggio", "Four cheeses (mozzarella, parmesan, pecorino, jarlsberg)","none","pizza",15.5));
//			addMenu(new Menu("Chicken", "Fresh tomatoes, mozzarella, chicken, onions","none","pizza",17));
//			addMenu(new Menu("Pineapple'o'clock", "Fresh tomatoes, mozzarella, fresh pineapple, bacon, fresh basil","none","pizza",16.5));
//			addMenu(new Menu("Meat Town", "Fresh tomatoes, mozzarella, hot pepporoni, hot sausage, beef, chicken","Hot","pizza",20));
//			addMenu(new Menu("Parma", "Fresh tomatoes, mozzarella, parma, bacon, fresh arugula","New","pizza",21.5));
//			
//			addMenu(new Menu("Lasagna", "Special sauce, mozzarella, parmesan, ground beef", "Popular", "pasta", 13.5));
//			addMenu(new Menu("Ravioli",	"Ravioli filled with cheese", "none", "pasta", 14));
//			addMenu(new Menu("Spaghetti", "Classica	Fresh tomatoes, onions, ground beef", "none", "pasta", 11));
//			addMenu(new Menu("Seafood pasta", "Salmon, shrimp, lobster, garlic", "none", "pasta", 25.5));
//			
//			addMenu(new Menu("Today's Soup", "Ask the waiter", "Seasonal", "starter", 5.5));
//			addMenu(new Menu("Bruschetta", "Bread with pesto, tomatoes, onion, garlic", "none", "starter", 8.5));
//			addMenu(new Menu("Garlic bread", "Grilled ciabatta, garlic butter, onions", "none", "starter", 9.5));
//			addMenu(new Menu("Tomozzarella", "Tomatoes and mozzarella", "none", "starter", 10.5));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static boolean addMenu(Menu menu) throws SQLException{
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(menu);
			tx.commit();
		} catch (EntityExistsException e) {
			return false;
		}
		finally {
			em.close();
		}
		return true;
	}
	
	public static boolean updateMenu(String name, String status, double price) throws SQLException{
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Menu menu = em.find(Menu.class, name);
			if (menu==null) {
				return false;
			}
			menu.setPrice(price);
			menu.setStatus(status);
			tx.commit();
		} finally {
			em.close();
		}
		return true;
	}
	
	public static boolean deleteMenu(String name) throws SQLException{
		
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Menu menu = em.find(Menu.class, name);
			if (menu==null) {
				return false;
			}
			em.remove(menu);
			tx.commit();
		} finally {
			em.close();
		}
		return true;
	}
	
	public static ArrayList<Menu> getMenus(){
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return (ArrayList<Menu>)em.createNativeQuery("select * from menu", Menu.class).getResultList();
		} finally {
			em.close();
		}
		
	}
}
