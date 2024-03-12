package in.co.mohammadasif.controller;

import java.util.List;

import in.co.mohammadasif.dto.CountryResponse;
import in.co.mohammadasif.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @SuppressWarnings("unchecked")
    @GetMapping("/getCountryResponse")
    public Object getCountryResponse() throws JsonProcessingException {
        return service.getCompleteResponse();
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/getCountryNames")
    public List<String> getCountryNames() throws JsonProcessingException {
        String expression = "$.Countries[*].Country";
        return (List<String>) service.getFormatedResponse(expression, List.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/getCountries")
    public List<Object> getCountries() throws JsonProcessingException {
         String expression1 = "$.Countries[*]";
//        String expression2 = "$.Countries[*].Data";
        return (List<Object>) service.getFormatedResponse(expression1, List.class);
    }

}
