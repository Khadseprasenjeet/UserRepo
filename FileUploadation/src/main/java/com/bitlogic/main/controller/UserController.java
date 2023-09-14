package com.bitlogic.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bitlogic.main.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService us;

	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(
			
		@RequestPart("userJson") String userJ,
		@RequestPart("prof") MultipartFile profImg,
		@RequestPart("adhar") MultipartFile aadharCard,
		@RequestPart("pan") MultipartFile panCard
			)
	
	
	{
		System.out.println(userJ);
		System.out.println("Profile Image"+profImg.getOriginalFilename());
		System.out.println("Adhar Card"+aadharCard.getOriginalFilename());
		System.out.println("Pancard"+panCard.getOriginalFilename());
		
	
		
		
		us.saveUser(userJ,profImg,aadharCard,panCard);
		
		
		return new ResponseEntity<String>("Data Saved...!", HttpStatus.OK);
	}
	
}
