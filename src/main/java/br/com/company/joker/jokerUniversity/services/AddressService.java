package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.ConsultaCepDTO;
import br.com.company.joker.jokerUniversity.dtos.AddressDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.AddressMapper;
import br.com.company.joker.jokerUniversity.models.Address;
import br.com.company.joker.jokerUniversity.models.Student;
import br.com.company.joker.jokerUniversity.models.User;
import br.com.company.joker.jokerUniversity.repositories.AdressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressService {

    @Autowired
    AdressRepository adressRepository;

    @Autowired
    ModelMapper modelMapper;

    public AddressDTO save(AddressDTO addressDTO) {
        if(addressDTO.getCep() == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The CEP cant be null");
        }else if(addressDTO.getCep().equals("")){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The CEP cant be empty");
        }

        ConsultaCepDTO adressDTOconsulted = ConsultaCepService.consultaCep(addressDTO.getCep());
        addressDTO.setRua(adressDTOconsulted.getLogradouro());
        addressDTO.setBairro(adressDTOconsulted.getBairro());
        addressDTO.setCidade(adressDTOconsulted.getLocalidade());
        addressDTO.setUf(adressDTOconsulted.getUf());
        Address address = adressRepository.save(new Address(addressDTO));
        AddressDTO newAddressDTO = AddressMapper.INSTANCE.toDTO(address);
        return newAddressDTO;
    }

    public AddressDTO update(AddressDTO addressDTO) {
        Integer adressId = addressDTO.getAdressID();
        Address address = adressRepository.findById(adressId).orElseThrow(
                () -> new EntidadeNotFoundException("No address find by id: " + adressId));

        if(addressDTO.getCep() == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The CEP cant be null");
        }else if(addressDTO.getCep().equals("")){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The CEP cant be empty");
        }
        ConsultaCepDTO adressDTOconsulted = ConsultaCepService.consultaCep(addressDTO.getCep());
        addressDTO.setRua(adressDTOconsulted.getLogradouro());
        addressDTO.setBairro(adressDTOconsulted.getBairro());
        addressDTO.setCidade(adressDTOconsulted.getLocalidade());
        addressDTO.setUf(adressDTOconsulted.getUf());
        adressRepository.save(AddressMapper.INSTANCE.toEntity(addressDTO));
        AddressDTO newAddressDTO;
        newAddressDTO = AddressMapper.INSTANCE.toDTO(address);
        return newAddressDTO;
    }

    public AddressDTO findById(Integer id) {
        Address address = adressRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No adress find by id: " + id));
        AddressDTO newAddressDTO = AddressMapper.INSTANCE.toDTO(address);
        return newAddressDTO;
    }

    public List<AddressDTO> findAll() {

        List<Address> addressList = adressRepository.findAll();
        if (addressList.isEmpty()) {
            throw new NoSuchElementException("No adress found!");
        }
        List<AddressDTO> adressListDTO = new ArrayList<>();
        for (Address address : addressList) {
            adressListDTO.add(AddressMapper.INSTANCE.toDTO(address));
        }
        return adressListDTO;
    }

    public AddressDTO deleteById(Integer id) {
        Address address = adressRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No adress find by id:  " + id));
        User user = address.getUser();
        if (user != null) {
            throw new DataIntegrityViolationException(
                    "The address is associated with a user and cannot be deleted.");
        }

        AddressDTO newAddressDTO = AddressMapper.INSTANCE.toDTO(address);

        adressRepository.delete(address);
        return newAddressDTO;
    }
}

