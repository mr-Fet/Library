package com.Library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Exception")
@Controller
public class ExceptionController {
    @RequestMapping(value = "/403")
    public String exept(){
        return "exception/403";
    }
}
