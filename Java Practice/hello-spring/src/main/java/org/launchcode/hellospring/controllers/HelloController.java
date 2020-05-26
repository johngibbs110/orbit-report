package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // Lives at /hello/goodbye
    // Handles request at path /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring";
    }

    // Lives at /hello/hello
    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles language request of form /hello/language
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "language")
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        if (language.equals("french")) {
            return "Bonjour, " + name + "!";
        }
        if (language.equals("spanish")) {
            return "Hola, " + name + "!";
        }
        if (language.equals("german")) {
            return "Hallo, " + name + "!";
        }
        if (language.equals("italian")) {
            return "Ciao, " + name + "!";
        }
        return "Hello, " + name + "!";
    }

    // Lives at hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

}