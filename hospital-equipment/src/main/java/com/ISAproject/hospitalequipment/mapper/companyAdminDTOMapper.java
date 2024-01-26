package com.ISAproject.hospitalequipment.mapper;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.CompanyAdministratorDTO;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class companyAdminDTOMapper {
    private static ModelMapper modelMapper;

    @Autowired
    public companyAdminDTOMapper(@Qualifier("modelMapper") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public static CompanyAdministrator fromDTOtoCompanyAdministrator(CompanyAdministratorDTO dto) {
        return modelMapper.map(dto, CompanyAdministrator.class);
    }

    public static CompanyAdministratorDTO fromCompanyAdministratorDTO(CompanyAdministrator dto) {
        return modelMapper.map(dto, CompanyAdministratorDTO.class);
    }
}
