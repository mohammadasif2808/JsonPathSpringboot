package in.co.mohammadasif.service;

import in.co.mohammadasif.dto.CountryResponse;
import in.co.mohammadasif.invoker.CountryInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@Service
public class CountryService {
    @Autowired
    private CountryInvoker invoker;

    ObjectMapper mapper = new ObjectMapper();

    public Object getCompleteResponse() throws JsonProcessingException {
        CountryResponse response = invoker.getCountryInfo();
        String jsonResponse = mapper.writeValueAsString(response);
        return jsonResponse;
    }

    public Object getFormatedResponse(String jsonExpression, Class<?> classType) throws JsonProcessingException {
        CountryResponse response = invoker.getCountryInfo();
        String jsonResponse = mapper.writeValueAsString(response);
        Object countryResponse = JsonPath.parse(jsonResponse).read(jsonExpression, classType);
        return countryResponse;
    }

}
