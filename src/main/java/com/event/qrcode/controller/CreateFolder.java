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
import com.event.qrcode.service.FolderService;

/**
 * Servlet implementation class CreateFolder
 */
@WebServlet("/CreateFolder")
public class CreateFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFolder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String folder_name = request.getParameter("folder");
        String username = request.getParameter("username");
        UserBean ub = new UserBean();
        DbConnection db = new DbConnection();
        FolderBean fb = new FolderBean();

//	System.out.println(folder_name);
//	System.out.println(username);
//	fb.setFolder_name(folder_name);
        fb.setFolder_name(folder_name);
        FolderBean.setFoldername(folder_name);
        UserBean.setUsername(username);

        try {
			db.createFolder();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String pa = db.getPath();

        FolderService fs = new FolderService();
        System.out.println(UserBean.isCreated());
        if (UserBean.isCreated()) {
            String path = pa.replace("WEB-INF\\", "resource\\" + folder_name + "\\");
//    out.println("<h6>path  : " + path + "</h6>");
            if (path.equals(pa)) {
                path = pa.replace("\\", "/").substring(1);
                path = path.replace("WEB-INF/", "resource/" + folder_name + "/");
                path = "/" + path;
                fs.writeFile(path);
            } else {

                fs.writeFile(path);
            }
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Entered Folder Already Exits');");
            ArrayList<FolderBean> foldername = new ArrayList<>();
            foldername = db.getFolderDetails(FolderBean.getFoldername());
            request.setAttribute("folderdetail", foldername);
            session.setAttribute("folderdetail", foldername);
            out.println("location='folder.jsp';");
            out.println("</script>");
        }
        out.println("<script type=\"text/javascript\">");
        out.println("location='home.jsp';");
        out.println("</script>");
	}

}
