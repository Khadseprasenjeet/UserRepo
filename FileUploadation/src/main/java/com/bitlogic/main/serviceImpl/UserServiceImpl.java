package com.bitlogic.main.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitlogic.main.model.User;
import com.bitlogic.main.repository.UserRepository;
import com.bitlogic.main.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository ur;

	@Override
	public void saveUser(String userJ, MultipartFile profImg, MultipartFile aadharCard, MultipartFile panCard)
{

		ObjectMapper mapper=new ObjectMapper();
	try
	{
		User user=	mapper.readValue(userJ, User.class);
		
		
		
		user.setProfileImg(profImg.getBytes());
		user.setAadharCard(aadharCard.getBytes());
		user.setPanCard(panCard.getBytes());
		
		 ur.save(user); 
		
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public List<User> getAllUser() {
List<User> all = ur.findAll();
		
		return all;
	}
	
	
	
	
}
