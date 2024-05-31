package br.com.company.joker.jokerUniversity.mappers;

import org.mapstruct.factory.Mappers;

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
