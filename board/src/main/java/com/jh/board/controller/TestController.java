package com.jh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jh.board.dto.ResponseDto;
import com.jh.board.dto.TestDto;
import com.jh.board.service.TestService;


@RestController
@RequestMapping("/api/auth")
public class TestController {
    
    @Autowired TestService testService;

    @PostMapping("/testOne")
    public float testOne (@RequestBody TestDto requestBody){
        float result = testService.testOne(requestBody);
        return result;
    }

}
