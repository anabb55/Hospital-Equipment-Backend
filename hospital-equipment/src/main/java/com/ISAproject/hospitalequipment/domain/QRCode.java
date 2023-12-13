package com.ISAproject.hospitalequipment.domain;

import com.ISAproject.hospitalequipment.domain.enums.QRCodeStatus;
import com.ISAproject.hospitalequipment.domain.enums.ReservationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="QRCode")
@Getter
@Setter
public class QRCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Enumerated(EnumType.STRING)
    private QRCodeStatus qrCodeStatus;

    @OneToOne(mappedBy = "qrCode", cascade = CascadeType.ALL)
    private Reservation reservation;

}
