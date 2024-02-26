package nl.novi.behuiswerkles11.mappers;

import nl.novi.behuiswerkles11.dtos.TelevisionDto;
import nl.novi.behuiswerkles11.dtos.TelevisionRequestDto;
import nl.novi.behuiswerkles11.models.Television;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TelevisionModelMapper {

    //    Mapper functie om de tv om te zetten naar een dto tv, die we willen teruggeven aan de gebruiker
    public TelevisionDto translateToDto(Television television) {
        TelevisionDto dto = new TelevisionDto();

        dto.setName(television.getName());
        dto.setBrand(television.getBrand());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());

        return dto;
    }

    public List<TelevisionDto> translateToDtos(List<Television> televisions) {
        List<TelevisionDto> result = new ArrayList<>();
        for (Television television: televisions) {
            result.add(translateToDto(television));
        }
        return result;
    }

    //    Mapper functie om de input/request om te zetten naar een tv
    public Television createTelevision(TelevisionRequestDto dto) {
        Television television = new Television();

        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());

        return television;
    }







}
