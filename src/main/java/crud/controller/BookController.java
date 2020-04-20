package crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @RequestMapping("/")
    public String check(){
        return "home";
    }

    @RequestMapping("/redirect")
    public String check3(){
        return "redirect:page2";
    }
    @RequestMapping("/page2")
    public String check4(){
        return "page2html";
    }
    @RequestMapping("/book/add")
    public String add(){
        return "add";
    }

    @RequestMapping("/book/chinhsua/id={id}")
    public String book(){
        return "edit";
    }
}
