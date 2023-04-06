package com.jh.board.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.jh.board.dto.ResponseDto;
import com.jh.board.dto.SignInDto;
import com.jh.board.dto.SignInResponseDto;
import com.jh.board.dto.SignUpDto;
import com.jh.board.service.AuthService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired AuthService authService;
	
	@PostMapping("/signUp")
	public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody){
		ResponseDto<?> result = authService.signUp(requestBody);
		return result;
	}
	
	@PostMapping("/signIn")
	public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody){
		ResponseDto<SignInResponseDto> result = authService.SignIn(requestBody);
		return result;
		
	}
}
