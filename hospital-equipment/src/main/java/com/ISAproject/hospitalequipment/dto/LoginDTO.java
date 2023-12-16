package com.ISAproject.hospitalequipment.dto;

import lombok.Getter;
import lombok.Setter;

public class LoginDTO {
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginDTO() {
    }
}
