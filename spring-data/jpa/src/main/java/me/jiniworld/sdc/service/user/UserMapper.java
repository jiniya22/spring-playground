package me.jiniworld.sdc.service.user;

import me.jiniworld.sdc.domain.UserDetail;
import me.jiniworld.sdc.domain.UserSimple;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserSimple toUserSimple(User user);

    @Mapping(source = "address.street", target = "address")
    UserDetail toUserDetail(User user);
}
