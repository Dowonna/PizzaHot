package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GuestDAO;
import model.ReservationDAO;
import model.Service;
import model.dto.GuestDTO;
import model.dto.MenuDTO;
//http://localhost/project_pizzahot/Controller
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	public static Service instance = Service.getInstance();

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}*/
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		
		try{
			if(command.equals("addGuest")){//모든 probono project 정보 검색
				addGuest(request, response);
			}else if(command.equals("deleteGuest")) {
				deleteGuest(request, response);
			}else if(command.equals("getAllguests")){//모든 재능 기부자 검색
				getAllguests(request, response);
			}else if(command.equals("someguest")){//특정 재능 기부자 정보 검색
				someguest(request, response);
			}else if(command.equals("verification")) {
				verification(request,response);
			}else if(command.equals("menuManage")) {
				menuManage(request, response);
			} else if(command.equals("menuInsert")) {
				menuInsert(request, response);
			} else if(command.equals("menuDelete")) {
				menuDelete(request, response);
			} else if(command.equals("menuUpdate")) {
				menuUpdate(request, response);
			} else if(command.equals("addReservation")) {
				addReservation(request, response);
			} else if(command.equals("getSomeReservation")) {
				getSomeReservation(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void addGuest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		GuestDTO guest = new GuestDTO();
		guest.setName(request.getParameter("Name"));
		guest.setPeople(request.getParameter("People"));
		guest.setData(request.getParameter("date"));
		guest.setPhone(request.getParameter("Phone"));
		try {
			int result =  Service.addGuset(guest);
			System.out.println(result);
			if(result !=0 ) {
				Service.confirmReservation(result);
				request.setAttribute("guest", guest);
				System.out.println(guest);
			}else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}		
		request.getRequestDispatcher(url).forward(request, response);	
	}
	
	public void deleteGuest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String url = "showError.jsp";
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			GuestDAO.deleteGuest(id);
			String name = request.getParameter("Name");
			String phone = request.getParameter("Phone");
			request.setAttribute("guestAll", GuestDAO.getsomeGuest(name, phone));
			url = "someList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getAllguests(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String url = "showError.jsp";
		try {
			request.setAttribute("guestAll", Service.getAllguests());
			url = "guestList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void someguest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String url = "showError.jsp";
		try {
			String name = request.getParameter("Name");
			String phone = request.getParameter("Phone");
			request.setAttribute("guestAll", Service.someguest(name, phone));
			url = "someList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void verification(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String url = "showError.jsp";
		if(request.getParameter("id").equals("hot")&&request.getParameter("pw").equals("11")) {
			url = "Controller?command=getAllguests";
		}else {
			String e = "알맞은 로그인 정보가 아닙니다";
			request.setAttribute("errorMsg", e);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void menuManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("menu", request.getParameter("menu"));
			request.setAttribute("config", request.getParameter("config"));
			request.setAttribute("status", request.getParameter("status"));
			request.setAttribute("price", request.getParameter("price"));
			request.setAttribute("category", request.getParameter("category"));
			
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "menuManage_axios.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void menuDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			instance.deleteMenu(request.getParameter("menu"));
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "menuManage_axios.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void menuInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String name = request.getParameter("name");
			name = name.replaceAll("'", "&apos;");
			instance.addMenu(new MenuDTO(name, request.getParameter("config")
						, request.getParameter("status"), request.getParameter("category")
						, Double.parseDouble(request.getParameter("price"))));
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "menuManage_axios.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void menuUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			instance.updateMenu(request.getParameter("menu"), request.getParameter("status"), Double.parseDouble(request.getParameter("price")));
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "menuManage_axios.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void addReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "reservationInsert.jsp";
		String[] s = request.getParameter("basket").split("_,");
		s[s.length-1] = s[s.length-1].substring(0, s[s.length-1].length()-1);
		ArrayList<String[]> arr = new ArrayList<>();
		for (String i : s) {
			arr.add(i.split(","));
		}
		
		try {
			Service.addReservation(arr);
		} catch (SQLException e) {
			url = "showError.jsp";
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void getSomeReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String temp = request.getParameter("id");
			int id = Integer.parseInt(temp);
			request.setAttribute("reservationAll", Service.getSomeReservation(id));
			url = "somereservationList.jsp";
		} catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}

