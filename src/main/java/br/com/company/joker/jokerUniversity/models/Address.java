package br.com.company.joker.jokerUniversity.models;

import br.com.company.joker.jokerUniversity.dtos.AddressDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode

@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private Integer enderecoID;
    @Column(name = "cep")
    private String cep;
    @Column(name = "rua")
    private String rua;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "numero")
    private String numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "uf")
    private String uf;
    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private User user;

    public Address(AddressDTO addressDTO) {
        this.enderecoID = addressDTO.getAdressID();
        this.cep = addressDTO.getCep();
        this.rua = addressDTO.getRua();
        this.bairro = addressDTO.getBairro();
        this.cidade = addressDTO.getCidade();
        this.numero = addressDTO.getNumero();
        this.complemento = addressDTO.getComplemento();
        this.uf = addressDTO.getUf();
    }

}