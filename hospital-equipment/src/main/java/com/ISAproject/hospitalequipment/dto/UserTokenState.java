package com.ISAproject.hospitalequipment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter  //ovaj dto cuva JWT i koliko on traje
public class UserTokenState {

    private String token;
    private long expiresIn;

    public UserTokenState(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
}
