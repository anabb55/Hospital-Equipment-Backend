package com.ISAproject.hospitalequipment.mapper;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class userDTOMapper {

    private static ModelMapper modelMapper;

    @Autowired
    public userDTOMapper(@Qualifier("modelMapper") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public static User fromDTOtoUser(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public static UserDTO fromUsertoDTO(User dto) {
        return modelMapper.map(dto, UserDTO.class);
    }
}
