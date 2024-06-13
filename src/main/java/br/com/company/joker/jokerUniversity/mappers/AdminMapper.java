package br.com.company.joker.jokerUniversity.mappers;

import br.com.company.joker.jokerUniversity.dtos.AdminDTO;
import br.com.company.joker.jokerUniversity.models.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

   AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    AdminDTO toDTO(Admin admin);
    Admin toEntity(AdminDTO adminDTO);
}
