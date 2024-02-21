package nl.novi.behuiswerkles11.services;

import nl.novi.behuiswerkles11.dtos.RequestTelevisionDTO;
import nl.novi.behuiswerkles11.dtos.ResponseTelevisionDTO;
import nl.novi.behuiswerkles11.exceptions.RecordNotFoundException;
import nl.novi.behuiswerkles11.models.Television;
import nl.novi.behuiswerkles11.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

//    public List<Television> getTelevisions(){
//        return televisionRepository.findAll();
//    }

    public List<ResponseTelevisionDTO> getTelevisions() {
        List<Television> televisionsList = televisionRepository.findAll();
        List<ResponseTelevisionDTO> televisionDTOList= new ArrayList<>();

        for (Television television : televisionsList) {
            ResponseTelevisionDTO dto = new ResponseTelevisionDTO();
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
//            TODO aanvullen

            televisionDTOList.add(dto);
        }
        return televisionDTOList;
    }

    public Television getTelevision(Long id){
        Optional<Television> optionalTelevision = televisionRepository.findById(id);
        if (optionalTelevision.isEmpty()){
            throw new RecordNotFoundException();
        } else {
            return optionalTelevision.get();
        }
    }



    public void saveTelevision (RequestTelevisionDTO dto) {
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
//        TODO aanvullen

        televisionRepository.save(television);
    }







}
