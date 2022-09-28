package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void myFunc(){

    }
}
