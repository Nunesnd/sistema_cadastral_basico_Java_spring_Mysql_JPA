package com.loja.cafeteria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
	
    @GetMapping("/administrativo")
    public String acessarPrincipal() {
            return "administrativo/home";
    }

}
