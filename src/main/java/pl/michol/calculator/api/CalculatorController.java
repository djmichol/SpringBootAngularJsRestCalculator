package pl.michol.calculator.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(value="/")
public class CalculatorController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

    @RequestMapping(value="/home")
    public String home() {
        return "index";
    }

    @RequestMapping(value="/calculator")
    public String calculator() {
        return "index";
    }

}
