package com.haiykut.ardecorifycore.controllers;

import com.haiykut.ardecorifycore.services.BaseJwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/core")
public class SampleController {
    private final BaseJwtService baseJwtService;

    public SampleController(BaseJwtService baseJwtService){
        this.baseJwtService = baseJwtService;
    }
    @GetMapping("/secretKey")
    public String getSecretKey(){
        System.out.println(baseJwtService.getSECRET_KEY());
        return baseJwtService.getSECRET_KEY();
    }
}
