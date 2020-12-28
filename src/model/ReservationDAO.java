package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.ReservationDTO;
import model.util.PublicCommon;

public class ReservationDAO {
	// 2. Reservation - CRUD
	// 검색 : 모든 예약정보 반환
	public static ArrayList<ReservationDTO> getAllReservations() throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		return (ArrayList<ReservationDTO>) em.createNamedQuery("getAllReservations", ReservationDTO.class)
				.getResultList();
	}

	// 특정검색 : id로 해당 예약정보 검색
	public static ReservationDTO getReservation(String reservationNum) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		return em.find(ReservationDTO.class, reservationNum);
	}

	// 저장 : 새로운 예약정보 저장
//	public static boolean addReservation(String name, String number) throws SQLException {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		tx.begin();
//		try {			
//			ReservationDTO r = new ReservationDTO();
//			r.setMenuName(name);
//			r.setFoodNum(number);
////			r.setId(0);
//			em.persist(r);
//			tx.commit();
//			return true;
//		} catch (Exception e) {
//			tx.rollback();
//			return false;
//		}
//	}
	
	public static boolean addReservation(ArrayList<String[]> arr) throws SQLException {
		boolean result = false;
		for(String[] i : arr) {
			EntityManager em = PublicCommon.getEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			String name = i[0];
			String number = i[2];			
			try {			
				ReservationDTO r = new ReservationDTO();
				r.setMenuName(name);
				r.setFoodNum(number);
//				r.setId(0);
				em.persist(r);
				tx.commit();
				result = true;
			} catch (Exception e) {
				tx.rollback();
				result = false;
			}
		}
		return result;
	}

	// 수정 : 예약번호를 통해 기존 reservation에서 메뉴 변경
	public static boolean updateReservation(String reservationNum, String menuName) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();// 여기 tx.begin();
		try {
			ReservationDTO reservation = em.find(ReservationDTO.class, reservationNum);
			reservation.setMenuName(menuName);
			em.persist(reservation);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
//	public static ReservationDTO confirmReservation(ReservationDTO r,int id) throws SQLException {
//		EntityManager em = PublicCommon.getEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			ReservationDTO temp = em.find(ReservationDTO.class, r.getReservationNum());
//			System.out.println("하하" +temp);
//			temp.setId(id);
//			System.out.println("호호" +temp);
//			em.persist(temp);
//			System.out.println("호호2" +temp);
//			tx.commit();
//			System.out.println("호호3" +temp);
//			return temp;
//		} catch (Exception e) {
//			tx.rollback();
//			return null;
//		} finally {
//			em.close();
//		}
//	}
	
	public static boolean confirmReservation(int id) throws SQLException {
		boolean result = false;
		ArrayList<ReservationDTO> temps = ReservationDAO.getAllReservations();//모든 reservation 데이터 받아온 뒤
		for(ReservationDTO r : temps) {// 여기는 한개씩 비교
			if(r.getId() == 0) {	// id가 0이면			잠시만요
				EntityManager em = PublicCommon.getEntityManager();
				EntityTransaction tx = em.getTransaction();
				try {
					tx.begin();
					ReservationDTO temp = em.find(ReservationDTO.class, r.getReservationNum());
					temp.setId(id);//id셋팅해주는 거에요
					em.persist(temp);//헷갈리실 수 있는데 이게 그래서 join을 안썼어요 reservation부터 만들고 그다음에 id를 셋팅해주니깐 
					tx.commit();
					result = true;
				} catch (Exception e) {
					tx.rollback();
					result = false;
				} finally {
					em.close();
				}		
			}
		}
		return result;
	}
	// 삭제 : 예약번호로 reservation 정보 삭제
	public static boolean deleteReservation(String reservationNum) throws SQLException {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			ReservationDTO reservation = em.find(ReservationDTO.class, reservationNum);
			em.remove(reservation);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
	public static ArrayList<ReservationDTO> getSomeReservation(int id) throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		ArrayList<ReservationDTO> reservations = new ArrayList<>();
		try {			
			List<ReservationDTO> getReservations = (List<ReservationDTO>) ReservationDAO.getAllReservations();
			for(ReservationDTO temp : getReservations) {
				if(temp.getId() == id) {
					reservations.add(temp);
				}
			}
		} finally {
			em.close();
		}
		return reservations;
	}
}