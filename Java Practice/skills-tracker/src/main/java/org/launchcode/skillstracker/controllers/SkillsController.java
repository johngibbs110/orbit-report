package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SkillsController {

    @GetMapping
    @ResponseBody
    public String skillsTrackerList() {
        return  "<html>" +
                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<body>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    @ResponseBody
    public String formPrompt() {
        return  "<html>" +
                "<body>" +
                "<form action='submit' method='post'>" +
                "<label>Name:</label>" + "<br>" +
                "<input type='text' name='name'>" + "<br>" +
                "<label>My favorite language:</label>" + "<br>" +
                "<select name='first'>" +
                "<option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select>" + "<br>" +
                "<label>My second favorite language:</label>" + "<br>" +
                "<select name='second'>" +
                "<option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select>" + "<br>" +
                "<label>My third favorite language:</label>" + "<br>" +
                "<select name='third'>" +
                "<option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='Python'>Python</option>" +
                "</select>" + "<br>" +
                "<input type='submit' value='Submit'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("submit")
    @ResponseBody
    public String formSubmitted(@RequestParam String name, @RequestParam String first, @RequestParam String second, @RequestParam String third) {
        return "<html>" +
                "<body>" +
                "<h1>" + name + "</h1>" +
                "<table style='width 100%'>" +
                "<tr>" +
                "<th>Preference</th>" +
                "<th>Coding Language</th>" +
                "</tr>" +
                "<tr>" +
                "<td style='text-align:center'>1.</td>" +
                "<td>" + first + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='text-align:center'>2.</td>" +
                "<td>" + second + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td style='text-align:center'>3.</td>" +
                "<td>" + third + "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "<html>";
//        return "<html>" +
//                "<h1>" + name + "</h1>" +
//                "<ol>" +
//                "<li>" + first + "</li>" +
//                "<li>" + second + "</li>" +
//                "<li>" + third + "</li>" +
//                "</ol>" +
//                "</html>";
    }
}