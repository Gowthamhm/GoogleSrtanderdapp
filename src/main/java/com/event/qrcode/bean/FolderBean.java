package com.event.qrcode.bean;

public class FolderBean {
    	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
	private String folder_name;
	private String creator;
	private String time;
	private String date;
	private boolean created;

	private static String foldername;

	public String getFolder_name() {
		return folder_name;
	}

	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isCreated() {
		return created;
	}

	public void setCreated(boolean created) {
		this.created = created;
	}

	public static String getFoldername() {
		return foldername;
	}

	public static void setFoldername(String foldername) {
		FolderBean.foldername = foldername;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
