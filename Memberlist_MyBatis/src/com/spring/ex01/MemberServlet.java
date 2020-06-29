package com.spring.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/mem3.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAO dao=new MemberDAO();
		String nextPage="";
		String action=request.getParameter("action");
		if(action==null||action.equals("listMembers")) {
			request.setAttribute("membersList", dao.selectAllMemberList());
			nextPage="test02/listMembers.jsp";
		} else if (action.equals("selectMemberById")) {
			request.setAttribute("member", dao.selectMemberById(request.getParameter("value")));
			nextPage="test02/memberInfo.jsp";
		} else if (action.equals("selectMemberByPw")) {
			request.setAttribute("membersList", dao.selectMemberByPw(Integer.parseInt(request.getParameter("value"))));
			nextPage="test02/listMembers.jsp";
		} else if(action.equals("insertMember")) {
			MemberVO memberVO=new MemberVO();
			memberVO.setId(request.getParameter("id"));
			memberVO.setPw(request.getParameter("pw"));
			memberVO.setName(request.getParameter("name"));
			memberVO.setEmail(request.getParameter("email"));
			dao.insertMember(memberVO);
			nextPage="/mem3.do?action=listMembers";
		} else if(action.equals("memberForm")) {
			nextPage="test02/memberForm.jsp";
		} else if(action.equals("updateMember")) {
			MemberVO memberVO=new MemberVO();
			memberVO.setId(request.getParameter("id"));
			memberVO.setPw(request.getParameter("pw"));
			memberVO.setName(request.getParameter("name"));
			memberVO.setEmail(request.getParameter("email"));
			dao.updateMember(memberVO);
			nextPage="/mem3.do?action=listMembers";
		} else if(action.equals("deleteMember")) {
			dao.deleteMember(request.getParameter("id"));
			nextPage="/mem3.do?action=listMembers";
		}
		RequestDispatcher dis=request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

}
