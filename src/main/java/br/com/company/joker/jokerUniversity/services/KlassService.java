package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.KlassDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.KlassMapper;
import br.com.company.joker.jokerUniversity.models.Klass;
import br.com.company.joker.jokerUniversity.repositories.KlassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class KlassService {

    @Autowired
    KlassRepository klassRepository;

    public KlassDTO save(KlassDTO klassDTO) {

        Klass klassSave = new Klass(klassDTO);
        klassRepository.save(klassSave);

        KlassDTO klassDTOSave = KlassMapper.INSTANCE.toDTO(klassSave);
        return klassDTOSave;
    }

    public KlassDTO update(KlassDTO klassDTO) {
        Integer KlassID = klassDTO.getKlassID();
        Klass Klass = klassRepository.findById(KlassID).orElseThrow(
                () -> new EntidadeNotFoundException("No Klass find by id :" + KlassID));
        klassRepository.save(KlassMapper.INSTANCE.toEntity(klassDTO));
        KlassDTO klassDTOSave = KlassMapper.INSTANCE.toDTO(Klass);
        return klassDTOSave;
    }
    public KlassDTO findById(Integer id) {
        Klass Klasss = klassRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Klass find by id :" + id));
        KlassDTO klassDTO = KlassMapper.INSTANCE.toDTO(Klass);
        return klassDTO;
    }

    public List<KlassDTO> findAll() {
        List<Klass> klasses = klassRepository.findAll();
        if (klasses.isEmpty())
            throw new NoSuchElementException("No Klass find!");
        List<KlassDTO> klassDto = new ArrayList<>();
        for (Klass klass : klasses) {
            klassDto.add(KlassMapper.INSTANCE.toDTO(klass));
        }
        return klassDto;
    }

    public KlassDTO deleteById(Integer id) {
        Klass Klass = klassRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Klass find by id : " + id));
        klassRepository.deleteById(id);
        KlassDTO klassDto = KlassMapper.INSTANCE.toDTO(Klass);
        return klassDto;
    }
}
