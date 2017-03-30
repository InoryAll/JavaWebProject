package com.dldx.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.List;

import javax.jms.Session;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dldx.dao.PerssonDao;
import com.dldx.dao.UnitDao;
import com.dldx.entity.Persson;

/**
 * Servlet implementation class uploadFileServlet
 */
@WebServlet(name = "/servlet/EmployServlet", urlPatterns = "/servlet/EmployServlet")
public class EmployServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	Persson persson = new Persson();
	PerssonDao perssonDao = new PerssonDao();
	UnitDao unitDao = new UnitDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (request.getParameter("action") == null) {
			action = "insert";
		}
		switch (action) {
		case "insert":
			String savePath = this.getServletContext().getRealPath("/photo");
			File file = new File(savePath);
			if (!file.exists() && !file.isDirectory()) {
				if (file.mkdir()) {
					System.out.println("文件目录创建成功");
				}
			}
			// 消息提示
			String message = "";
			// 使用Apache文件上传文件上传步骤
			// 1.创建DiskFileItemFactoty工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2.创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决文件上传乱码
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> list;
			try {
				list = upload.parseRequest(request);
				for (FileItem item : list) {
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = item.getString("UTF-8");
						switch (name) {
						case "name":
							persson.setName(value);
							break;
						case "sex":
							persson.setSex(value);
							break;
						case "idcard":
							persson.setIdcard(value);
							break;
						case "political":
							persson.setPolitical(value);
							break;
						case "work":
							persson.setWork(value);
							break;
						case "telephone":
							persson.setTelephone(value);
							break;
						case "punit":
							persson.setPunit(value);
							break;
						case "ppost":
							persson.setPpost(value);
							break;
						case "education":
							persson.setEducation(value);
							break;
						case "degree":
							persson.setDegree(value);
							break;
						case "birthday":
							persson.setBirthday(value);
							break;
						case "degschool":
							persson.setDegschool(value);
							break;
						case "degmajor":
							persson.setDegmajor(value);
							break;
						case "pother":
							persson.setPother(value);
							break;
						case "other":
							persson.setOther(value);
							break;
						default:
							break;
						}
						// System.out.println(name + "=" + value);
					}
				}
				for (FileItem item : list) {
					if (!item.isFormField()) {
						{
							String filename = item.getName();
							System.out.println(filename);
							if (filename == null || filename.trim().equals("")) {
								continue;
							}
							filename = filename.substring(filename.lastIndexOf("\\") + 1);
							String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
							System.out.println("上传的文件的扩展名是：" + fileExtName);
							String saveFileName = persson.getIdcard() + "." + fileExtName;
							System.out.println(saveFileName);
							persson.setPhoto("/photo/" + saveFileName);
							InputStream inputStream = item.getInputStream();
							FileOutputStream outputStream = new FileOutputStream(savePath + "\\" + saveFileName);
							// 创建一个缓冲区
							byte buffer[] = new byte[1024];
							// 判断输入流中的数据是否已经读完的标识
							int len;
							while ((len = inputStream.read(buffer)) > 0) {
								outputStream.write(buffer, 0, len);
							}
							inputStream.close();
							outputStream.close();
							item.delete();
							message = "照片上传成功";
							out.write(message);
						}
					}
				}
				System.out.println(persson.toString());
				perssonDao.addPersson(persson);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "qunit":
			try {
				String units = unitDao.queryUnit();
				System.out.print(units);
				out.write(units);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "qpost":
			try {
				String posts = unitDao.queryPost(request.getParameter("querypost"));
				out.write(posts);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "qedo":
			try {
				String result = unitDao.queryEduDegOth(request.getParameter("queryunit"),
						request.getParameter("querypost"));
				out.write(result);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "qidcard":
			try {
				int idcard = perssonDao.CheckIdCard(request.getParameter("idcard"));
				System.out.println(idcard);
				out.write(idcard+"");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}

	}

}
