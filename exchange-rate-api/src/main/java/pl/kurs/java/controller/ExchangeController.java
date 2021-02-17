package pl.kurs.java.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import pl.kurs.java.model.CurrentInfo;
import pl.kurs.java.model.ExchangeRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class ExchangeController {

    public static final String BASE_URL = "https://api.exchangeratesapi.io/latest?base=PLN";
    public static final String HTTPS_API_EXCHANGERATESAPI_IO_LATEST_BASE = "https://api.exchangeratesapi.io/latest?base=";

    //STWORZYC LISTY ROZWIJALNE DO strony z wymiana walut
@GetMapping("")
    public String enterMainPage(@ModelAttribute ExchangeRequest request, ModelMap model){
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<CurrentInfo> response = restTemplate.getForEntity(
            BASE_URL, CurrentInfo.class);
    CurrentInfo currentInfo = response.getBody();
    List<String> all = new ArrayList<String>(currentInfo.getRates().keySet());
    model.addAttribute("currents", all);

    return "exchangeView";
    }
    @GetMapping("/ex")
    public String ex(@ModelAttribute ExchangeRequest request, ModelMap model){
    model.addAttribute("request",request);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrentInfo> response = restTemplate.getForEntity(
                HTTPS_API_EXCHANGERATESAPI_IO_LATEST_BASE +request.getCurrentTo(), CurrentInfo.class);
        CurrentInfo currentInfo = response.getBody();
        Double price = currentInfo.getRates().get(request.getCurrentFrom());
        model.addAttribute("price", price);
        model.addAttribute("currentInfo", currentInfo);
        Double value = price * request.getAmount();
        model.addAttribute("value", value);
        return "exchangeResultView";
    }
}
