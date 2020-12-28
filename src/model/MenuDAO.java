package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.jupiter.api.Test;

import model.dto.MenuDTO;
import model.util.PublicCommon;

public class MenuDAO {
	public static void main(String[] args) {
		try {
			addMenu(new MenuDTO("Margherita", "Fresh tomatoes, fresh mozzarella, fresh basil","none","pizza",12.5));
			addMenu(new MenuDTO("Formaggio", "Four cheeses (mozzarella, parmesan, pecorino, jarlsberg)","none","pizza",15.5));
			addMenu(new MenuDTO("Chicken", "Fresh tomatoes, mozzarella, chicken, onions","none","pizza",17));
			addMenu(new MenuDTO("Pineapple'o'clock", "Fresh tomatoes, mozzarella, fresh pineapple, bacon, fresh basil","none","pizza",16.5));
			addMenu(new MenuDTO("Meat Town", "Fresh tomatoes, mozzarella, hot pepporoni, hot sausage, beef, chicken","Hot","pizza",20));
			addMenu(new MenuDTO("Parma", "Fresh tomatoes, mozzarella, parma, bacon, fresh arugula","New","pizza",21.5));
			
			addMenu(new MenuDTO("Lasagna", "Special sauce, mozzarella, parmesan, ground beef", "Popular", "pasta", 13.5));
			addMenu(new MenuDTO("Ravioli",	"Ravioli filled with cheese", "none", "pasta", 14));
			addMenu(new MenuDTO("Spaghetti", "Classica	Fresh tomatoes, onions, ground beef", "none", "pasta", 11));
			addMenu(new MenuDTO("Seafood pasta", "Salmon, shrimp, lobster, garlic", "none", "pasta", 25.5));
			
			addMenu(new MenuDTO("Today's Soup", "Ask the waiter", "Seasonal", "starter", 5.5));
			addMenu(new MenuDTO("Bruschetta", "Bread with pesto, tomatoes, onion, garlic", "none", "starter", 8.5));
			addMenu(new MenuDTO("Garlic bread", "Grilled ciabatta, garlic butter, onions", "none", "starter", 9.5));
			addMenu(new MenuDTO("Tomozzarella", "Tomatoes and mozzarella", "none", "starter", 10.5));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean addMenu(MenuDTO menu) throws SQLException{
		
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
			MenuDTO menu = em.find(MenuDTO.class, name);
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
			MenuDTO menu = em.find(MenuDTO.class, name);
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
	
	public static ArrayList<MenuDTO> getMenus(){
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return (ArrayList<MenuDTO>)em.createNativeQuery("select * from menu", MenuDTO.class).getResultList();
		} finally {
			em.close();
		}
		
	}
}
