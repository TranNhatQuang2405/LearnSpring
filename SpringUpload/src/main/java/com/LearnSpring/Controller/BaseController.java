package com.LearnSpring.Controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LearnSpring.Model.MyFile;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BaseController {

	@Autowired
	private ServletContext context;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("myFile", new MyFile());
		return "index";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(MyFile myFile, Model model) {
		model.addAttribute("message", "upload success");
		model.addAttribute("description", myFile.getDescription());

		try {
			MultipartFile multipartFile = myFile.getMultipartFile();
			String fileName = multipartFile.getOriginalFilename();
			File file = new File("D:/Upload", fileName);
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "upload failed");
		}
		return "result";
	}

	@RequestMapping(value = "/download1", method = RequestMethod.GET)
	public void download1(HttpServletResponse response) throws IOException {
		try {
			File file = new File(context.getRealPath("/file/down.txt"));
			byte[] data = FileUtils.readFileToByteArray(file);
			// Thiết lập thông tin trả về
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment; filename=" + file.getName());
			response.setContentLength(data.length);
			InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/download2", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> download2(HttpServletRequest request) throws IOException {
		HttpHeaders responseHeader = new HttpHeaders();
		try {
			File file = new File(context.getRealPath("/file/down.txt"));
			byte[] data = FileUtils.readFileToByteArray(file);
			// Set mimeType trả về
			responseHeader.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			// Thiết lập thông tin trả về
			responseHeader.set("Content-disposition", "attachment; filename=" + file.getName());
			responseHeader.setContentLength(data.length);
			InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
			InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
			return new ResponseEntity<InputStreamResource>(inputStreamResource, responseHeader, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<InputStreamResource>(null, responseHeader, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
