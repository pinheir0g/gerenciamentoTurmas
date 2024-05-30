package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.AddressDTO;
import br.com.company.joker.jokerUniversity.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);


    AddressDTO toDTO(Address address);
    Address toEntity(AddressDTO addressDTO);
}