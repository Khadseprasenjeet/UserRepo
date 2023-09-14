package com.bitlogic.main.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

public 	void saveUser(String userJ, MultipartFile profImg, MultipartFile aadharCard, MultipartFile panCard);

}
