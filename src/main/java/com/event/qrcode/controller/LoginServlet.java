package com.event.qrcode.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.event.qrcode.bean.FolderBean;
import com.event.qrcode.bean.UserBean;
import com.event.qrcode.dao.DbConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
//			 UserBean ub = new UserBean();//            username
            String user = request.getParameter("username");
//          password
      String password = request.getParameter("password");
            UserBean.setUsername(user);
            UserBean.setPassword(password);
			DbConnection db = new DbConnection();
			try {
				db.login();
				 Boolean valid = UserBean.isValid();
				 System.out.println(valid);
				 if (valid == true) {

						ArrayList<FolderBean> folderDetail = db.getAllFolderDetails();
						System.out.println(folderDetail.size());
						for (int i = 0; i < folderDetail.size(); i++) {
							System.out.println(folderDetail.get(i));
							System.out.println(folderDetail.get(i).getCreator());
							System.out.println(folderDetail.get(i).getFolder_name());
						}
//						request.setAttribute("folderDetail", folderDetail);
						session.setAttribute("folderDetail", folderDetail);
//						request.getRequestDispatcher("home.jsp").forward(request, response);
					 session.setAttribute("username", user);
			                out.println("<script type=\"text/javascript\">");
			                out.println("location='home.jsp';");
			                out.println("</script>");
			            } else {
			                // request.setAttribute("error", "Login failed");
//						request.getRequestDispatcher("login.html").forward(request, response);

			                out.println("<script type=\"text/javascript\">");
			                out.println("location='login.jsp';");
			                out.println("</script>");

			            }
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
