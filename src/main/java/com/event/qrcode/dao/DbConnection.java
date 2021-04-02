package com.event.qrcode.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.event.qrcode.bean.FolderBean;
import com.event.qrcode.bean.UserBean;

public class DbConnection {

	Connection conn;
	UserBean ub = new UserBean();
    FolderBean fb = new FolderBean();
	ResultSet rs = null;
	Statement stmt = null;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public DbConnection() throws IOException {
		String rootPath = null;
		try {
			Class.forName("org.h2.Driver");
			String path = getPath();
			rootPath = path + "MyDB";
//				System.out.println(getRelativePath());
			System.out.println(rootPath);
			this.conn = DriverManager.getConnection("jdbc:h2:" + rootPath + ";create=true", "root", "qrcode");
			System.out.println(conn);
//				CreateTable();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	public String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		System.out.println("Full Path : " + fullPath);
		String rootPath = fullPath.replace(".metadata/.plugins/org.eclipse.wst.server.core/tmp0/", "");
		System.out.println("RootPath : " + rootPath);
		if (rootPath.equals(fullPath)) {

			rootPath = rootPath.replaceAll("\\d", "");
			System.out.println(rootPath);
			rootPath = rootPath.replace("/target/QrCode-0.1.0", "");
			System.out.println(rootPath);
			rootPath = rootPath.replace("WEB-INF/classes/", "src/main/webapp/WEB-INF/");
			rootPath = rootPath.replace("WEB-INF/classes/", "WebContent/WEB-INF/");
			System.out.println(rootPath);
			rootPath = rootPath.replace("/base/data/home/apps/s~micro-edge-/t./", "");
			System.out.println(rootPath);
			rootPath = rootPath.replace("src/main/webapp", "");
			rootPath = "./" + rootPath;
		} else {
			rootPath = rootPath.replace(".metadata/.plugins/org.eclipse.wst.server.core/tmp0/", "");
			System.out.println(rootPath);
			rootPath = rootPath.replace("WEB-INF/classes/", "src/main/webapp/WEB-INF/");
			rootPath = rootPath.replace("/", "\\").substring(1);
			System.out.println(rootPath);
		}
		return rootPath;
	}

	public void login() throws SQLException {
		String username = UserBean.getUsername();
		String password = UserBean.getPassword();
		Statement stmt = null;
		String searchQuery = "select * from users where username='" + username + "' AND password='" + password + "'";
		stmt = conn.createStatement();
		System.out.println(searchQuery);
		rs = stmt.executeQuery(searchQuery);
//			while(rs.next()) {
//				System.out.println(rs.getString("sl_no"));
//				System.out.println(rs.getString("username"));
//				System.out.println(rs.getString("password"));
//				System.out.println(rs.getString("phone"));
//				System.out.println(rs.getString("email_id"));
//				System.out.println(rs.next());
//			}
		boolean more = rs.next();
		if (!more) {
			System.out.println("Sorry, you are not a registered user! Please sign up first");
			UserBean.setValid(false);
		} else if (more) {
			System.out.println(rs.getString("sl_no"));
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
			System.out.println(rs.getString("phone"));
			System.out.println(rs.getString("email_id"));
//			System.out.println(rs.next());
			UserBean.setValid(true);
		}
		rs.close();
	}

	public ArrayList<FolderBean> getAllFolderDetails() {
		 PreparedStatement ps = null;
	        ArrayList<FolderBean> folders = new ArrayList<FolderBean>();

	        String query1 = "Select * from Folders ";
	        try {
	            ps = conn.prepareStatement(query1);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                FolderBean fb = new FolderBean();
	                // System.out.println(rs.getString("foldername"));
	                fb.setFolder_name(rs.getString("folder_name"));
	                // String folder_name = rs.getString("foldername");
	                // System.out.println(rs.getString("creator"));
	                fb.setCreator(rs.getString("creator"));
//	                System.out.println(fb);
	                folders.add(fb);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return folders;
	}

	public ArrayList<FolderBean> getFolderDetails(String foldername) {
		 ResultSet rs = null;
	        PreparedStatement ps = null;

	        ArrayList<FolderBean> folders = new ArrayList<FolderBean>();

	        String query1 = "Select * from Folders where folder_name='" + foldername + "'";
	        try {
	            ps = conn.prepareStatement(query1);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                FolderBean fb = new FolderBean();
	                // System.out.println(rs.getString("foldername"));
	                fb.setFolder_name(rs.getString("folder_name"));
	                // String folder_name = rs.getString("foldername");
	                // System.out.println(rs.getString("creator"));
	                fb.setCreator(rs.getString("creator"));
	                fb.setDate(rs.getString("date"));
	                fb.setTime(rs.getString("time"));
	                System.out.println(fb);
	                folders.add(fb);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return folders;
	}

	public void createFolder() throws SQLException {
		 String folder_name = FolderBean.getFoldername();
	        String username = UserBean.getUsername();
	        System.out.println(username);
	        System.out.println(folder_name);
	        stmt = conn.createStatement();
	        ArrayList<FolderBean> folder = getAllFolderDetails();
	        System.out.println(folder.size());
	        if (folder.size() > 0) {
	            for (FolderBean folderDetail : folder) {
	                if (folderDetail.getFolder_name().equals(folder_name)) {
	                    System.out.println("already present");
	                    fb.setCreated(false);
	                    break;
	                } else {
	                    fb.setCreated(true);
	                }
	            }
	        } else {
	            fb.setCreated(true);
	        }

	        System.out.println(fb.isCreated());
	        if (fb.isCreated()) {
	            DateFormat df = new SimpleDateFormat("dd/MM/yy");
	            DateFormat tf = new SimpleDateFormat("HH:mm:ss");
	            Date dateobj = new Date();
	            System.out.println(df.format(dateobj));
	            System.out.println(tf.format(dateobj));
	            String query = "insert into FOLDERS(" + "folder_name, creator,date,time) VALUES " + "('" + folder_name + "'," + "'"
	                    + username + "','" + df.format(dateobj) + "','" + tf.format(dateobj) + "')";
	            System.out.println(query);
	            stmt.execute(query);
	            fb.setCreated(true);
	            System.out.println("Values inserted");
	            UserBean.setCreated(true);
	        } else {
	            UserBean.setCreated(false);
	        }	
	}
}
