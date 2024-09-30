package me.jiniworld.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/v")
@Controller
class ViewController {

    @GetMapping(value = "/home")
    public String home(@RequestParam(value = "message", required = false) String message, Model model){
        model.addAttribute("message", message);
        return "home";
    }

    @GetMapping(value = "/page1")
    public String page1(@RequestParam(value = "message", required = false) String message, Model model){
        model.addAttribute("message", message);
        return "page1";
    }
}
