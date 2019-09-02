package com.admin.material;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class SimpleController {
    private static final Logger logger = Logger.getLogger(SimpleController.class);

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

//    pages/forms/basic-form-elements.html
    @RequestMapping(value = "/pages/{pathVariable}/{page}", method = RequestMethod.GET)
    public String pages(HttpServletRequest request,Locale locale, Model model,@PathVariable("pathVariable")String pathVariable, @PathVariable(value="page") String page) {
        logger.info("Page Called: "+page);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "/pages/"+pathVariable+"/"+page;
    }

}
