package com.example.springapp.mapper;

import com.example.springapp.entity.RegistrationForm;
import com.example.springapp.entity.User;
import com.example.springapp.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = UserService.class)
public interface UserMapper {
    User registrationFormToUser(RegistrationForm form);
}
