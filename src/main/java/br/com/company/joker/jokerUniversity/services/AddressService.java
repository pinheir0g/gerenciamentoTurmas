package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.ConsultaCepDTO;
import br.com.company.joker.jokerUniversity.dtos.AddressDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.AddressMapper;
import br.com.company.joker.jokerUniversity.models.Address;
import br.com.company.joker.jokerUniversity.repositories.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;

    public AddressDTO save(AddressDTO addressDTO) {
        if(addressDTO.getCep() == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The CEP cant be null");
        }else if(addressDTO.getCep().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The CEP cant be empty");
        }

        ConsultaCepDTO addressDTOconsulted = CepSearchService.cepSearch(addressDTO.getCep());
        addressDTO.setRua(addressDTOconsulted.getLogradouro());
        addressDTO.setBairro(addressDTOconsulted.getBairro());
        addressDTO.setCidade(addressDTOconsulted.getLocalidade());
        addressDTO.setUf(addressDTOconsulted.getUf());
        Address address = addressRepository.save(new Address(addressDTO));
        AddressDTO newAddressDTO = AddressMapper.INSTANCE.toDTO(address);
        return newAddressDTO;
    }

    public AddressDTO update(AddressDTO addressDTO) {
        Integer addressId = addressDTO.getAddressID();
        Address address = addressRepository.findById(addressId).orElseThrow(
                () -> new EntidadeNotFoundException("No address find by id: " + addressId));
        if(addressDTO.getCep() == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The CEP cant be null");
        }else if(addressDTO.getCep().isEmpty()){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The CEP cant be empty");
        }
        ConsultaCepDTO adressDTOconsulted = CepSearchService.cepSearch(addressDTO.getCep());
        addressDTO.setRua(adressDTOconsulted.getLogradouro());
        addressDTO.setBairro(adressDTOconsulted.getBairro());
        addressDTO.setCidade(adressDTOconsulted.getLocalidade());
        addressDTO.setUf(adressDTOconsulted.getUf());
        addressRepository.save(AddressMapper.INSTANCE.toEntity(addressDTO));
        AddressDTO newAddressDTO;
        newAddressDTO = AddressMapper.INSTANCE.toDTO(address);
        return newAddressDTO;
    }

    public AddressDTO findById(Integer id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No address find by id: " + id));
        AddressDTO newAddressDTO = AddressMapper.INSTANCE.toDTO(address);
        return newAddressDTO;
    }

    public List<AddressDTO> findAll() {

        List<Address> addressList = addressRepository.findAll();
        if (addressList.isEmpty()) {
            throw new NoSuchElementException("No address found!");
        }
        List<AddressDTO> adressListDTO = new ArrayList<>();
        for (Address address : addressList) {
            adressListDTO.add(AddressMapper.INSTANCE.toDTO(address));
        }
        return adressListDTO;
    }
/*
    public AddressDTO deleteById(Integer id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No address find by id:  " + id));
        Admin admin = address.getAdminID();
        if (user != null) {
            throw new DataIntegrityViolationException(
                    "The address is associated with a user and cannot be deleted.");
        }

        AddressDTO newAddressDTO = AddressMapper.INSTANCE.toDTO(address);

        addressRepository.delete(address);
        return newAddressDTO;
    }
 */

}

