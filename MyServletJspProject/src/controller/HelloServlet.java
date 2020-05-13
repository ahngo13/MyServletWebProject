package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.user.dao.UserDAO;
import jdbc.user.vo.UserVO;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    @Override
    public void init() throws ServletException{
    	System.out.println("HelloServlet init()");
    	userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet : " + request.getMethod());
		
		//���䵥������ content type�� �����ϰ�, �ѱ� ���ڵ�
//		response.setContentType("text/html;charset=utf-8");
		
		//��� ��Ʈ�� ����
//		PrintWriter out = response.getWriter();
//		Date myDate = new Date();
//		out.println("<h2>���糯¥�� " + myDate + " �Դϴ�.</h2>");
//		out.close();
		
		//command ���ڿ� �����ϱ�
		String cmd = request.getParameter("cmd");
		if(cmd.equals("user_list")) {
			getUsers(request, response);	
		}else if(cmd.equals("user_form")) {
			insertUserForm(request, response);
		}
		
		
	}//doGet

	private void insertUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<String> cityList = Arrays.asList("����", "���", "�λ�", "�뱸", "����");
		
		//Session ����
		//Session ��ü����
		HttpSession session = request.getSession();
		session.setAttribute("cityList", cityList);
		
		RequestDispatcher rd = request.getRequestDispatcher("userForm.jsp");
		rd.forward(request, response);
	}

	private void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����� ��� ��ȸ ó��
		System.out.println("doGet : " + request.getMethod());
		
		//1. UserDAO�� �޼��� ȣ��
		List<UserVO> users = userDAO.getUsers();
		//2. ���� ���� List ��ü�� JSP�� ����� �� �ֵ��� request scope�� �����ؾ� �մϴ�.
		request.setAttribute("userList", users);
		//3. List ��ü�� ������� JSP�� ������ �Ѵ�.
		RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}

}
