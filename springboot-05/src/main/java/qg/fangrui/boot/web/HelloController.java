package qg.fangrui.boot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import qg.fangrui.boot.aop.RequestLimit;
 
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    @RequestLimit(count = 10)
    public String hello(HttpServletRequest request) {
        return "Hello World";
    }

}