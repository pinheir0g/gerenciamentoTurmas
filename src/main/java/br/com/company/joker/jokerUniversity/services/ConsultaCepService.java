package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.ConsultaCepDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultaCepService {

    public static ConsultaCepDTO consultaCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://viacep.com.br/ws/{cep}/json/";
        Map<String, String> dadosCep = new HashMap<String, String>();
        dadosCep.put("cep", cep);
        ConsultaCepDTO cepConsultadoDTO = restTemplate.getForObject(url, ConsultaCepDTO.class, dadosCep);
        if (cepConsultadoDTO.getLogradouro() == null) {
            throw new NullPointerException("This CEP is invalid!");
        }
        return cepConsultadoDTO;
    }
}
