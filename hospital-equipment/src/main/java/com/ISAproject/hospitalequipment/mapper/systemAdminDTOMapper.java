package com.ISAproject.hospitalequipment.mapper;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.SystemAdmin;
import com.ISAproject.hospitalequipment.dto.RegisterUserDTO;
import com.ISAproject.hospitalequipment.dto.SystemAdminDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class systemAdminDTOMapper {
    private static ModelMapper modelMapper;

    @Autowired
    public systemAdminDTOMapper(@Qualifier("modelMapper") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public static SystemAdmin fromDTOtoSystemAdmin(SystemAdminDto dto) {
        return modelMapper.map(dto, SystemAdmin.class);
    }

    public static SystemAdminDto fromSystemAdminToDTO(SystemAdmin dto) {
        return modelMapper.map(dto, SystemAdminDto.class);
    }
}
