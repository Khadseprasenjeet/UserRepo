package com.bitlogic.main.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bitlogic.main.model.User;

public interface UserService {

public 	void saveUser(String userJ, MultipartFile profImg, MultipartFile aadharCard, MultipartFile panCard);

public List<User> getAllUser();

}
