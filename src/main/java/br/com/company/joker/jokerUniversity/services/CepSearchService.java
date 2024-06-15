package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.ConsultaCepDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CepSearchService {

    public static ConsultaCepDTO cepSearch(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/{cep}/json/";
        Map<String, String> cepData = new HashMap<String, String>();
        cepData.put("cep", cep);
        ConsultaCepDTO cepConsultadoDTO = restTemplate.getForObject(url, ConsultaCepDTO.class, cepData);
        if (cepConsultadoDTO.getLogradouro() == null) {
            throw new NullPointerException("This CEP is invalid!");
        }
        return cepConsultadoDTO;
    }
}
