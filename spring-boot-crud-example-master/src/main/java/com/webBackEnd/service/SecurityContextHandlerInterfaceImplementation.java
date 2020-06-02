package com.webBackEnd.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service //This service is created to access the information of Security context, autowire to controller and use its method
public class SecurityContextHandlerInterfaceImplementation implements SecurityContextHandlerInterface {

    public SecurityContextHandlerInterfaceImplementation() {
        super();
    }

    @Override
    public final Authentication getAuthentication() { // return the Authentication object
        return SecurityContextHolder.getContext().getAuthentication(); //There are many method and context in SecurityContextHolder, we just need getAuthentication here.
    }

}