package soulmateapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/result")
    public String resultPage(
            @RequestParam String name,
            @RequestParam int age,
            @RequestParam String location,
            Model model
    ) {

        String soulmateName =
                generateSoulmateName(name, location);

        model.addAttribute("soulmateName", soulmateName);

        return "result";
    }

    private String generateSoulmateName(
            String name,
            String location
    ) {

        String firstPart =
                name.substring(
                        0,
                        Math.min(3, name.length())
                );

        String secondPart =
                location.substring(
                        0,
                        Math.min(3, location.length())
                );

        return firstPart + secondPart + "ra";
    }
}
