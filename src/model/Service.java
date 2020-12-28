package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.GuestDTO;
import model.dto.Menu;
import model.dto.ReservationDTO;

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
	
	// 2. Reservation - CRUD
		// 검색
	public static ArrayList<ReservationDTO> getAllReservations() throws SQLException {
		return ReservationDAO.getAllReservations();
	}

		// 특정검색
	public static ReservationDTO getReservation(String reservationNum) throws SQLException {
		return ReservationDAO.getReservation(reservationNum);
	}

		// 저장
//	public static boolean addReservation(ArrayList<String[]> arr) throws SQLException {
//		boolean result = false;
//		for(String[] i : arr) {
//			String name = i[0];
//			String number = i[2];			
//			result = ReservationDAO.addReservation(name, number);
//		}
//		
//		return result;
//	}
	
	public static boolean addReservation(ArrayList<String[]> arr) throws SQLException {
		boolean result = false;			
		result = ReservationDAO.addReservation(arr);
		return result;
	}
	
//	public static boolean confirmReservation(int id) {
//		boolean result = false;
//		try {
//			ArrayList<ReservationDTO> temp = ReservationDAO.getAllReservations();
//			for(ReservationDTO r : temp) {
//				if(r.getId() == 0) {
//					ReservationDTO t = ReservationDAO.confirmReservation(r, id);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return true;		
//	}
	
	public static boolean confirmReservation(int id) throws SQLException {
		boolean result = false;
		result = ReservationDAO.confirmReservation(id);
		return result;		
	}
		// 수정
	public static boolean updateReservation(String reservationNum, String menuName) throws SQLException {
		boolean result = false;
		result = ReservationDAO.updateReservation(reservationNum, menuName);
		return result;
	}

		// 삭제
	public static boolean deleteReservation(String reservationNum) throws SQLException {
		boolean result = false;
		result = ReservationDAO.deleteReservation(reservationNum);
		return result;
	}
	public static ArrayList<ReservationDTO> getSomeReservation(int id) throws SQLException{
		return ReservationDAO.getSomeReservation(id);
	}
	
	public static int addGuset(GuestDTO guest) throws SQLException {
		int result = GuestDAO.addGuest(guest);
		return result;
	}
	
	public static boolean deleteGuset(int id) throws SQLException {
		boolean result = false;
		result = GuestDAO.deleteGuest(id);
		return result;
	}
	
	public static List<GuestDTO> getAllguests() throws SQLException{
		return GuestDAO.getGuests();
	}
	
	public static ArrayList<GuestDTO> someguest(String name,String phone) throws SQLException{
		return GuestDAO.getsomeGuest(name, phone);
	}
}
