package com.example.demo.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.JsonResponse;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserDao userDao;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	//adUserdSignUp
	@PostMapping(value = "/create-user")
	public JsonResponse<Object> adUserdSignUp(@RequestBody UserModel details) {
		logger.info("Method : adUserdSignUp starts");

		logger.info("Method : adUserdSignUp ends");
		return userDao.adUserdSignUp(details);
	}
	//usersignin
	@RequestMapping(value = "/login", method = { RequestMethod.GET })
	public JsonResponse<List<UserModel>> userSignIn(@RequestParam String loginid,
			@RequestParam String password) {
		logger.info("Method : userSignIn starts");
		logger.info("Method : userSignIn ends");
		return userDao.userSignIn(loginid, password);
	}
}