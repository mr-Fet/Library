package com.Library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
    @RequestMapping("/Library")
    public String mainMenu(){
        return "menu/mainMenu";
    }
}
