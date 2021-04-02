package com.event.qrcode.service;

import java.io.IOException;
import java.util.ArrayList;

import com.event.qrcode.bean.FolderBean;
import com.event.qrcode.dao.DbConnection;

public class DbService {
    DbConnection db;

public DbService() throws IOException {
   this.db = new DbConnection();
}
public ArrayList<FolderBean> getAllFolderDetailsService() throws IOException{
    ArrayList<FolderBean> folderDetail;
    folderDetail = db.getAllFolderDetails();
   return   folderDetail;
}
public ArrayList<FolderBean>  getfolderDetail(String foldername){
        ArrayList<FolderBean> folde = db.getFolderDetails(foldername);
   return folde;
}
}
