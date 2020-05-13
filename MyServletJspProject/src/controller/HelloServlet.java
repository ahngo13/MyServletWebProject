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
		
		//응답데이터의 content type을 설정하고, 한글 인코딩
//		response.setContentType("text/html;charset=utf-8");
		
		//출력 스트림 생성
//		PrintWriter out = response.getWriter();
//		Date myDate = new Date();
//		out.println("<h2>현재날짜는 " + myDate + " 입니다.</h2>");
//		out.close();
		
		//command 문자열 추출하기
		String cmd = request.getParameter("cmd");
		if(cmd.equals("user_list")) {
			getUsers(request, response);	
		}else if(cmd.equals("user_form")) {
			insertUserForm(request, response);
		}
		
		
	}//doGet

	private void insertUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<String> cityList = Arrays.asList("서울", "경기", "부산", "대구", "제주");
		
		//Session 저장
		//Session 객체생성
		HttpSession session = request.getSession();
		session.setAttribute("cityList", cityList);
		
		RequestDispatcher rd = request.getRequestDispatcher("userForm.jsp");
		rd.forward(request, response);
	}

	private void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 목록 조회 처리
		System.out.println("doGet : " + request.getMethod());
		
		//1. UserDAO의 메서드 호출
		List<UserVO> users = userDAO.getUsers();
		//2. 리턴 받은 List 객체를 JSP가 사용할 수 있도록 request scope에 저장해야 합니다.
		request.setAttribute("userList", users);
		//3. List 객체를 출력해줄 JSP로 포워딩 한다.
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
