package com.amisa.sprintevolution.digitalgoldwallet.controllers.thymeleaf;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/web")
public class WebController {
	@GetMapping("/home")
    public String home() {
        return "homepage";
    }
}