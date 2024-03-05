package kr.kh.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploadUtils {
	
	public static String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String [] items = contentDisposition.split(";");
		for(String item : items) {
			
			if(item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=") +2, item.length()-1);
			}
		}
		
		return null;
	}
	
	public static String upload(String uploadPath, Part part) {
		String fileName = getFileName(part);
		UUID uid = UUID.randomUUID();
		String filePath = calculatePath(uploadPath) + File.separator + uid + "_" + fileName; 
		
		try(InputStream is = part.getInputStream();
				OutputStream os = new FileOutputStream(uploadPath+filePath)){
			byte [] buffer = new byte[1024*4];
			int readCount;
			while((readCount= is.read(buffer))!= -1) {
				os.write(buffer,0,readCount);
			}
			return filePath.replace(File.separatorChar, '/');
		}catch(Exception e) {
			return null;
		}
	}

	public static String calculatePath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator 
				+ new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator 
				+ new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath,yearPath,monthPath,datePath);
		return datePath;
	}

	private static void makeDir(String uploadPath, String ...paths) {
		int lastIndex = paths.length-1;
		
		if(new File(uploadPath+paths[lastIndex]).exists()) {
			return;
		}
		
		for(String path : paths) {
			File dir = new File(uploadPath+path);
			if(!dir.exists()) {
				dir.mkdir();
			}
		}
		
	}
}
