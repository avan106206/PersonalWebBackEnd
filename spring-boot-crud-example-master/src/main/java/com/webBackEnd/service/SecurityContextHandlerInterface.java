package com.webBackEnd.service;

import org.springframework.security.core.Authentication;

public interface SecurityContextHandlerInterface {

    Authentication getAuthentication();

}