 package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.dto.Menu;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	public static Service instance = Service.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//command pattern
		String command = request.getParameter("command");
		
		try{
			if(command.equals("menuAll")){
				menuAll(request, response);
			} else if(command.equals("addBasket")) {
				addBasket(request, response);
			} else if(command.equals("deleteBasket")) {
				deleteBasket(request, response);
			} else if(command.equals("menuManage")) {
				menuManage(request, response);
			} else if(command.equals("menuInsert")) {
				menuInsert(request, response);
			} else if(command.equals("menuDelete")) {
				menuDelete(request, response);
			}

		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void menuAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("menuAll", instance.getAllMenu());
			request.getSession().setAttribute("basket", new ArrayList<String[]>());
			url = "demo2.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void addBasket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			double cost=0;
			boolean check=true;
			ArrayList<String[]> arr = (ArrayList<String[]>)request.getSession().getAttribute("basket");
			for (String[] i : arr) {
				cost+=Double.parseDouble(i[2])*Double.parseDouble(i[1]);
				if (i[0].equals(request.getParameter("menu"))) {
					i[2]=Integer.toString(Integer.parseInt(i[2])+1);
					check=false;
					cost+=Double.parseDouble(i[1]);
				}
			}
			if (check) {
				String[] item = {request.getParameter("menu"), request.getParameter("price"),"1"};
				arr.add(item);
				cost+=Double.parseDouble(item[1]);
			}
			request.setAttribute("cost",cost);
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "demo2.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void deleteBasket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			double cost=Double.parseDouble(request.getParameter("cost"));
			ArrayList<String[]> arr = (ArrayList<String[]>)request.getSession().getAttribute("basket");
			for (String[] i : arr) {
				if (i[0].equals(request.getParameter("menu"))) {
					i[2]=Integer.toString(Integer.parseInt(i[2])-1);
					cost-=Double.parseDouble(i[1]);
					if (i[2].equals("0")) {
						arr.remove(i);
					}
					break;
				}
			}
			request.setAttribute("cost",cost);
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "demo2.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	
	
	
	public void menuManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "menuManage.jsp";
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
			url = "menuManage.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void menuInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			instance.addMenu(new Menu(request.getParameter("name"), request.getParameter("config")
						, request.getParameter("status"), request.getParameter("category")
						, Double.parseDouble(request.getParameter("price"))));
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "menuManage.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
