package com.ISAproject.hospitalequipment.mapper;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.RegisterUserDTO;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class registredUserDTOMapper
{
    private static ModelMapper modelMapper;

    @Autowired
    public registredUserDTOMapper(@Qualifier("modelMapper") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public static RegisteredUser fromDTOtoRegistedUser(RegisterUserDTO dto) {
        return modelMapper.map(dto, RegisteredUser.class);
    }

    public static RegisterUserDTO fromregisteredUsertoDTO(RegisteredUser dto) {
        return modelMapper.map(dto, RegisterUserDTO.class);
    }
}
