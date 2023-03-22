package com.pokemon.pokedex.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pokemon.pokedex.responses.FileResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v2/pokedex/file")
@Tag(name = "Files Services", description = "A list of the services related with the management of files in the server")
public class FileController {

	@Operation(description = "Uploads a file to the server")
	@PostMapping("/")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
		
		Map<String, Object> response = new HashMap<>();
		
		if (file == null || file.isEmpty()) {
			response.put("message", "The media type cannot be empty or in a non supported format");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			String fileName = file.getOriginalFilename();
			Path path = Paths.get("./src/main/resources/media").resolve(fileName).toAbsolutePath();
			
			Files.copy(file.getInputStream(), path);
			
		} catch (IOException e) {
			response.put("message", "There was an error uploading the file. Try changing the name");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "The file " + file.getOriginalFilename() + " has been successfully uploaded");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}

	@Operation(description = "Returns a list of the files in the server")
	@GetMapping("/")
	public ResponseEntity<?> listFiles(){
		
		FileResponse fileResponse = new FileResponse();
		List<String> filesList = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			String directoryPath ="./src/main/resources/media";
			File directory = new File(directoryPath);
			
			File[] files = directory.listFiles();
			
			for(File file : files) {
				if (file.isFile()) {
					filesList.add(file.getName());
				}
			}
			
			fileResponse.setNames(filesList);
			
		} catch (Exception e) {
			response.put("message", "The service is not available");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(fileResponse, HttpStatus.OK);
		
	}
}
