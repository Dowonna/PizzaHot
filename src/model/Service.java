package model;

import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.Menu;

public class Service {

	private static Service instance = new Service();

	public static Service getInstance() {
		return instance;
	}

	public ArrayList<Menu> getAllMenu() throws SQLException{
		return MenuDAO.getMenus();
	}
	
	public boolean updateMenu(String name, String status, double price) throws SQLException{
		return MenuDAO.updateMenu(name, status, price);
	}
	
	public boolean deleteMenu(String name) throws SQLException{
		return MenuDAO.deleteMenu(name);
	}
	
	public boolean addMenu(Menu menu) throws SQLException{
		return MenuDAO.addMenu(menu);
	}
}
