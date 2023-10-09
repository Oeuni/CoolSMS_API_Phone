package com.example.phone.controller;


import com.example.phone.service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequiredArgsConstructor
public class PhoneInsertController {

    private final CertificationService certificationService;

    @GetMapping("/check/sendSMS")
    @ResponseBody
    public String sendSMS(String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<6; i++) {    //6자리 인증번호
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        certificationService.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }


}
