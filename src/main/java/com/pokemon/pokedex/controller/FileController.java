package com.pokemon.pokedex.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.pokemon.pokedex.utils.FileUtils;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v2/pokedex/file")
@Tag(name = "Files Services", description = "A list of the services related with the management of files in the server")
public class FileController {
	
	@PostMapping("/")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
		
		Map<String, Object> response = new HashMap<>();
		
		if (file == null || file.isEmpty()) {
			response.put("message", "The media type cannot be empty or in a non supported format");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			byte[] bytesFromFile = new byte[0];
			bytesFromFile = file.getBytes();
			
			Files.write(Paths.get(FileUtils.folderPath + file.getOriginalFilename()), bytesFromFile);
			
		} catch (Exception e) {
			response.put("message", "There was an error uploading the file");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "The file " + file.getName() + " has been successfully uploaded");
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
}
