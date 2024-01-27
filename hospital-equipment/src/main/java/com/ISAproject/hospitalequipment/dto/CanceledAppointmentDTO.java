package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.CanceledAppointment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CanceledAppointmentDTO {

    public Long id;

    public UserDTO userDTO;

    public AppointmentDTO appointmentDTO;

    public CanceledAppointmentDTO(CanceledAppointment canceledAppointment){
        if(canceledAppointment!=null){
            this.id = canceledAppointment.getId();
            this.userDTO = new UserDTO(canceledAppointment.getUser());
            this.appointmentDTO = new AppointmentDTO((canceledAppointment.getAppointment()));
        }
    }

    public CanceledAppointmentDTO(){}
}
