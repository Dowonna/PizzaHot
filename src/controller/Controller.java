 package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;


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
				addbasket(request, response);
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
	
	public void addbasket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String[] item = {request.getParameter("menu"), request.getParameter("price")};
			ArrayList<String[]> arr = (ArrayList<String[]>)request.getSession().getAttribute("basket");
			arr.add(item);
			request.getSession().setAttribute("basket", arr);
			request.setAttribute("menuAll", instance.getAllMenu());
			url = "demo2.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
