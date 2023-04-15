package com.jh.board.service;

import org.springframework.stereotype.Service;

import com.jh.board.dto.TestDto;

@Service
public class TestService {
    
    public float testOne(TestDto dto){
        int numBer = dto.getNumBer();
        int numBer1 = dto.getNumBer1();
        float result = 0;

        if(numBer<100 ){
            float a = (float) numBer / numBer1;
            result = a;
        }

        return result;
    }

}
