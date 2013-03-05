package com.groupdocs.demo.annotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.groupdocs.sdk.api.StorageApi;
import com.groupdocs.sdk.common.ApiInvoker;
import com.groupdocs.sdk.common.GroupDocsRequestSigner;
import com.groupdocs.sdk.model.UploadResponse;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String guid = (String) session.getAttribute("fileGuid");
		String clientId = (String) session.getAttribute("clientId");
		String privateKey = (String) session.getAttribute("privateKey");
		
		log("session params: clientId=" + clientId + ", privateKey: " + privateKey + ", guid=" + guid);

		String fileName = null;
		File file = null;
		try {
			for (Part part : request.getParts()) {
				String name = part.getName();
				if (name != null) {
					if (name.equals("client_id")) {
						clientId = getValue(part);
					} else if (name.equals("private_key")) {
						privateKey = getValue(part);
					} else if (name.equals("file")) {
						try {
							// Upload File
							InputStream is = request.getPart(part.getName()).getInputStream();
							fileName = getFileName(part);
							if (fileName == null) {
								fileName = "uploaded";
							}
							file = File.createTempFile(fileName, String.valueOf(System.currentTimeMillis()));
							FileOutputStream out = new FileOutputStream(file);
							IOUtils.copy(is, out);
							out.close();
							log("Saved uploaded file at " + file.getAbsolutePath());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			if(file == null){
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to receive file. Try again.");
				return;
			}
			
			log("params received: clientId=" + clientId + ", privateKey: " + privateKey + ", file_name=" + fileName);
			
			ApiInvoker.getInstance().setRequestSigner(new GroupDocsRequestSigner(privateKey));
			UploadResponse gdResponse = new StorageApi().Upload(clientId, fileName, "", new FileInputStream(file));
			String fileGuid = gdResponse.getResult().getGuid();
			
			session.setAttribute("fileGuid", fileGuid);
			session.setAttribute("clientId", clientId);
			session.setAttribute("privateKey", privateKey);
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to upload file to GroupDocs. Try again.");
			return;
		}
		log("forwarding request to " + request.getContextPath() + "view.jsp");
		request.getRequestDispatcher(request.getContextPath() + "view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// Get the Value of the Form field other than type form field type file
	private String getValue(Part part) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				part.getInputStream(), "UTF-8"));
		StringBuilder value = new StringBuilder();
		char[] buffer = new char[1024];
		for (int length = 0; (length = reader.read(buffer)) > 0;) {
			value.append(buffer, 0, length);
		}
		return value.toString();
	}

	private String getFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
		log("Part Header = " + partHeader);
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
	
}
