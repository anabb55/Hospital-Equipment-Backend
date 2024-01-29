package com.ISAproject.hospitalequipment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {

    public double latitude;

    public double longitude;

    public LocationDTO(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationDTO() {
    }
}
