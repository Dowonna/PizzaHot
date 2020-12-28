package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.dto.GuestDTO;
import model.util.PublicCommon;

public class GuestDAO {
	
	public static int addGuest(GuestDTO guest) {
		int result = 0;
		EntityManager em = PublicCommon.getEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try{
			em.persist(guest);
			tx.commit();
			result = guest.getId();
			return result;
		} catch(EntityExistsException e) {
			return result;
		}finally {
			em.close();
		}
	}
	
	public static boolean updateGuest(GuestDTO guest) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			GuestDTO temp = em.find(GuestDTO.class, guest.getName());
			temp.setPeople(guest.getPeople());
			temp.setData(guest.getData());
			temp.setPhone(guest.getPhone());
			em.persist(temp);
			tx.commit();
			return true;
		} catch(EntityExistsException e) {
			return false;
		} finally {
			em.close();
		}	
	}
	
	public static boolean deleteGuest(int id) {
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			GuestDTO temp = em.find(GuestDTO.class, id);
			em.remove(temp);
			tx.commit();
			return true;
		} catch (EntityExistsException e) {
			return false;
		}finally {
			em.close();
		}
	}
	
	public static GuestDTO getGuest(String name) {
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.find(GuestDTO.class, name);
		} finally {
			em.close();
		}
	}
	
	public static ArrayList<GuestDTO> getsomeGuest(String name,String phone){
		EntityManager em = PublicCommon.getEntityManager();
		ArrayList<GuestDTO> guests = new ArrayList<>();
		try {
			
			List<GuestDTO> getGuests = (List<GuestDTO>) em.createNativeQuery("select * from guest", GuestDTO.class).getResultList();
			for(GuestDTO temp : getGuests) {
				System.out.println(temp.getName());
				if(temp.getName().equals(name) && temp.getPhone().equals(phone)) {
					guests.add(temp);
				}
			}
		} finally {
			em.close();
		}
		return guests;		
	}
	
	public static List<GuestDTO> getGuests(){
		EntityManager em = PublicCommon.getEntityManager();
		try {
			return em.createNativeQuery("select * from guest", GuestDTO.class).getResultList();
		} finally {
			em.close();
		}
	}
}
