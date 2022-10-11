package com.zse.hh22.civicproject.service;

import java.security.Principal;

public interface LikeCivicProjectService {
    void likeCivicProject(Principal loggedUser, String title);    
}
