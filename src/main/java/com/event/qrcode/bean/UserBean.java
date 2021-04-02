package com.event.qrcode.bean;

public class UserBean {
        private static final long serialVersionUID = 1L;
    private static String username;
    private static String password;
    private static String email;
    

    private static boolean valid;
    private static boolean confvalid;
    private static boolean created;
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		UserBean.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		UserBean.password = password;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		UserBean.email = email;
	}
	public static boolean isValid() {
		return valid;
	}
	public static void setValid(boolean valid) {
		UserBean.valid = valid;
	}
	public static boolean isConfvalid() {
		return confvalid;
	}
	public static void setConfvalid(boolean confvalid) {
		UserBean.confvalid = confvalid;
	}
	public static boolean isCreated() {
		return created;
	}
	public static void setCreated(boolean created) {
		UserBean.created = created;
	}
    
    
}
