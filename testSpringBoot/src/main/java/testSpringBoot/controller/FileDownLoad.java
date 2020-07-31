package testSpringBoot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Component
@Service
public class FileDownLoad {
	public void fileDownLoad(String path, String fileName, HttpServletRequest request, HttpServletResponse response) {
		String RealPath = request.getServletContext().getRealPath(path);
		String originalFileName = fileName.split("`")[1];
		String storeFileName = fileName.split("`")[0];
		
		response.setContentType("application/octet-stream; charset=utf-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        File file = new File(RealPath + "/" + storeFileName);
        ServletOutputStream out1 = null; 
        FileInputStream fis = null;
		try {
			out1 = response.getOutputStream();
			fis = new FileInputStream(file);
	        FileCopyUtils.copy(fis, out1);
	        response.flushBuffer();
	        out1.flush();
	        out1.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			 if(fis != null){                 
	                try{ fis.close();}catch(Exception e){}
	            }
		}
	}
}
