package nl.novi.behuiswerkles11.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RemoteControllerRequestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}
