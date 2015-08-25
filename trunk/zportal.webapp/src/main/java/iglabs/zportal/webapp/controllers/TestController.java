package iglabs.zportal.webapp.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {

    @RequestMapping("/hello/say")
    public void say(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().write("Hello World!");
    }
    
}
