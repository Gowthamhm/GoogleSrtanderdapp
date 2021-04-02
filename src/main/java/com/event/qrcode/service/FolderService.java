package com.event.qrcode.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderService {
	 public void writeFile(String directoryName) throws IOException{
		 try{
			    System.out.println(directoryName);
			        Path pathurl = Paths.get(directoryName);
			            Files.createDirectories(pathurl);
			             System.out.println("Directory is created!");
			 } catch (IOException e) {
			            System.err.println("Failed to create directory!" + e.getMessage());
			        }
	 }
}
