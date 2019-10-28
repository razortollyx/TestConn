package com.kk.admin.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator; 
import java.util.List;
import java.util.Random;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//Check that we have a file upload request 检查是否有文件上传请求
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			// Create a factory for disk-based file items 创建DiskFileItemFactory对象，设置缓冲区大小和临时文件目录
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//System.out.println(System.getProperty("java.io.tmpdir"));//默认临时文件夹
			// Set factory constraints
			/*factory.setSizeThreshold(yourMaxMemorySize);
			factory.setRepository(yourTempDirectory);*/
			
			//Create a new file upload handler创建ServletFileUpload对象，并设置上传文件的大小限制
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setSizeMax(50 * 1024 * 1024);// 以byte为单位 不能超过10M 1024byte
			
			// Set overall request size constraint
//			upload.setSizeMax(yourMaxRequestSize);
			
			// Parse the request 调用ServletFileUpload.parseRequest方法解析request对象，得到一个保存了所有上传内容的List对象
			try {
				List<FileItem> items = upload.parseRequest(request);
				// Process the uploaded items
				Iterator<FileItem> iter=items.iterator();
				while(iter.hasNext()){
					FileItem item=iter.next();
					//遍历list，每迭代一个FileItem对象，调用其isFormField方法判断是否是上传文件
					if(item.isFormField()==true){// 普通表单元素
						String name=item.getFieldName();// name属性值
						String value=item.getString();// name对应的value值
						System.out.println("form field："+name+"--"+value);
					}else{
						String fieldName = item.getFieldName();
					    String fileName = item.getName();// 文件名称
					    String contentType = item.getContentType();
					    boolean isInMemory = item.isInMemory();
					    long sizeInBytes = item.getSize();
					    System.out.println("file upload："+fieldName+"--"+fileName+"--"+contentType+"--"+isInMemory+"--"+sizeInBytes);
					}
					
					// Process a file upload
					if(!item.isFormField()){
						//1.获取真实地址,这里保存在Tomcat运行的项目upload目录中,这要在src/main/webapp下新建upload文件夹
						ServletContext sctx = getServletContext(); 
						String path=sctx.getRealPath("/upload");
						System.out.println(path);
						Date date = new Date();
						SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
						System.out.println(dateFormat.format(date));
						Random x = new Random();
						int suiji = x.nextInt(1000);
						System.out.println(path);
						String fileName = (String)dateFormat.format(date)+suiji+item.getName();
						
						File uploadedFile=new File(path+"\\"+fileName);
						
						//jdbc:mysql://106.12.44.134:3306/lixiang88","lixiang88","abc123abc123"
						item.write(uploadedFile);
						String ip = "127.0.0.1";
				        String port = "3306";
				        String username = "root";
				        String password = "123456";
				        String database = "test111";
				        String filePath = path+"\\"+fileName;
				        if(!(filePath.endsWith(".xls") || filePath.endsWith(".xlsx"))){
				        	System.out.println("filePath:"+filePath);
				        	request.setAttribute("tishi", "仅允许以.xls结尾的excel文件导入，其他excel格式请另存为.xls文件！");
				        	request.getRequestDispatcher("admin/admin.jsp?function=stu_add").forward(request, response);
					    
				        }else {
					        com.kk.subject.model.ImportExcel.importFromExcelToMySQL(ip, port, database, username, password, filePath);
					        request.setAttribute("tishi", "上传成功");
					        request.getRequestDispatcher("admin/admin.jsp?function=stu_add").forward(request, response);
				        }
				        //2.保存到指定盘符
						/*String fileName=item.getName();
						File uploadedFile=new File("d:/tmp/"+fileName);
						item.write(uploadedFile);*/
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}


		}
	}

}
