package com.prince.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prince.entity.FileInfo;

@Service
public class FileManager 
{
	FileInfo FI = new FileInfo();
	
	public String fileUpload(MultipartFile file)
	{
		if(file.isEmpty())
			return "Please select a file to upload";
		
		String filename = file.getOriginalFilename();
		String path = "./src/main/webapp/upload/";
		long filesize = file.getSize();
		FI.filename = filename;
		FI.path = path;
		FI.uploadedbytes = 0;
		FI.filesize = filesize;
		
		try
		{
			OutputStream out = new FileOutputStream(new File(path + filename));
			InputStream in = file.getInputStream();
			
			int read = 0;
			byte[] buffer = new byte[1024];
			while( (read = in.read(buffer)) != -1 )
			{
				out.write(buffer, 0, read);
				FI.uploadedbytes += read;
				Thread.sleep(50);
			}
			out.close();
			in.close();
			return "File uploaded successfully";
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	public String updateStatus()
	{
		return toJSONString(FI);
	}
	
	public List<String> getFiles()
	{
		List<String> list = new ArrayList<String>();
		File curDir = new File("./src/main/webapp/upload");
		for(File f : curDir.listFiles())
		{
			if(f.isFile())
			{
				FileInfo FI = new FileInfo();
				FI.filename = f.getName();
				FI.path = "upload/";
				FI.filesize = f.length();
				FI.uploadedbytes = 0;	
				list.add(toJSONString(FI));
			}
		}		
		return list;
	}
	
	public String toJSONString(Object obj)
	{
		GsonBuilder gb = new GsonBuilder();
		Gson gson = gb.create();
		return gson.toJson(obj);
	}
}
