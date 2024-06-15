package br.com.company.joker.jokerUniversity.dtos;

import lombok.Data;

@Data
public class AddressDTO {
    private Integer addressID;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String numero;
    private String complemento;
    private String uf;
}
