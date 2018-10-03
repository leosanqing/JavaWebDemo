package cn.swu.stormleo.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.swu.stormleo.Utils.DownloadUtils;


@WebServlet("/Demo01")
public class Demo01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 先获得要下载的文件的文件名
		String fileName=request.getParameter("filename");
		
		//改变编码
		fileName=new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		
		
		System.out.println(fileName);
		// 获取文件的绝对路径
		String path = getServletContext().getRealPath("download/"+fileName);
		
		// 判断是那种浏览器
		String browserType =request.getHeader("User-Agent");
		if(browserType.contains("FireFox"))
		{
			fileName=DownloadUtils.base64EncodeFileName(fileName);
			
		}
		
		else 
		{
			fileName=URLEncoder.encode(fileName, "UTF-8");
		}
		// 设置保存路径
		response.setHeader("Content-Disposition","attachment;filename="+fileName);
		// 转成流的形式
		InputStream is = new FileInputStream(path);
		OutputStream os=response.getOutputStream();
		
		int len = 0;
		byte [] buffer = new byte[1024];
		while((len = is.read(buffer))!=-1)
		{
			os.write(buffer, 0, len);
		}
		
		os.close();
		is.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
