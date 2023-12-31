package com.suman.blogapp.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
//		file name
		String name = file.getOriginalFilename();
		
//		file path
		String filePath = path + File.separator + name;
		
//		create folder
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
//		file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return name;
	}

	@Override
	public InputStream getResoure(String path, String fileName) throws FileNotFoundException {
		String fullPath = path+ File.separator +fileName;
		InputStream is = new FileInputStream(fullPath);
		return is;
	}

}
