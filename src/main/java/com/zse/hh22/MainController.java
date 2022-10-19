package com.zse.hh22;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("/")
public class MainController {
    @RequestMapping(value = {"/", "/{x:^(?!api$).*$}/*/{y:[\\w\\-]+}"})
    public String getIndex(HttpServletRequest request) {
        return "index.html";
    }
}
