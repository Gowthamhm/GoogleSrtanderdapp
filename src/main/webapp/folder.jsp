<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.event.qrcode.bean.QrCodeBean"%>
<%@page import="com.event.qrcode.service.DbService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.event.qrcode.bean.FolderBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0" />
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="assets/editor/css/froala_editor.css">
            <link rel="stylesheet" href="assets/editor/css/froala_style.css">
            <!--<link rel="stylesheet" href="assets/editor/css/plugins/code_view.css">-->
            <link rel="stylesheet" href="assets/editor/css/plugins/colors.css">
            <link rel="stylesheet" href="assets/editor/css/plugins/emoticons.css">
            <!--<link rel="stylesheet" href="assets/editor/css/plugins/image_manager.css">-->
            <!--<link rel="stylesheet" href="assets/editor/css/plugins/image.css">-->
            <link rel="stylesheet" href="assets/editor/css/plugins/line_breaker.css">
            <!--<link rel="stylesheet" href="assets/editor/css/plugins/table.css">-->
            <link rel="stylesheet" href="assets/editor/css/plugins/char_counter.css">
            <!--<link rel="stylesheet" href="assets/editor/css/plugins/video.css">-->
            <!--<link rel="stylesheet" href="assets/editor/css/plugins/fullscreen.css">-->
            <!--<link rel="stylesheet" href="assets/editor/css/plugins/file.css">-->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
            
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="assets/css/my-login.css">
<link rel="stylesheet" type="text/css" href="assets/css/home.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<% HttpSession session2 = request.getSession();
 //       System.out.println(session2.getAttribute("foldername"));
            ArrayList<FolderBean> fol = (ArrayList<FolderBean>) session2.getAttribute("folderdetail");
            ArrayList<QrCodeBean> qrcode = (ArrayList<QrCodeBean>) session2.getAttribute("QrCodeDetail");
 //            System.out.println(session2.getAttribute("foldername"));
 //            DbService ds =new DbService();
 //             ArrayList<FolderBean> folD = ds.getfolderDetail(fol.get(0).getFolder_name());
 //        System.out.println(session2.getAttribute("foldername"));
 //System.out.println("qrcode : "+session2.getAttribute("QrCodeDetail"));
            System.out.println(session2.getAttribute("folderdetail"));

            String folderName = fol.get(0).getFolder_name();
            String creator = fol.get(0).getCreator();
            String date = fol.get(0).getDate();
            String time = fol.get(0).getTime();
        %>
        <title> <%=folderName%></title><%
        %>  
</head>
<body>

</body>
</html>