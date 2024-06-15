package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.DisciplineDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.DisciplineMapper;
import br.com.company.joker.jokerUniversity.models.Discipline;
import br.com.company.joker.jokerUniversity.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DisciplineService {
    @Autowired
    DisciplineRepository disciplineRepository;

    public DisciplineDTO save(DisciplineDTO disciplineDTO) {

        Discipline disciplineSave = new Discipline(disciplineDTO);
        disciplineRepository.save(disciplineSave);

        DisciplineDTO disciplineDTOSave = DisciplineMapper.INSTANCE.toDTO(disciplineSave);
        return disciplineDTOSave;
    }

    public DisciplineDTO update(DisciplineDTO disciplineDTO) {
        Integer DisciplineID = disciplineDTO.getDisciplineID();
        Discipline Discipline = disciplineRepository.findById(DisciplineID).orElseThrow(
                () -> new EntidadeNotFoundException("No Discipline find by id :" + DisciplineID));
        disciplineRepository.save(DisciplineMapper.INSTANCE.toEntity(disciplineDTO));
        DisciplineDTO disciplineDTOSave = DisciplineMapper.INSTANCE.toDTO(Discipline);
        return disciplineDTOSave;
    }

    public DisciplineDTO findById(Integer id) {
        Discipline Disciplinee = disciplineRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Discipline find by id :" + id));
        DisciplineDTO disciplineDTO = DisciplineMapper.INSTANCE.toDTO(Disciplinee);
        return disciplineDTO;
    }

    public List<DisciplineDTO> findAll() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        if (disciplines.isEmpty())
            throw new NoSuchElementException("No Discipline find!");
        List<DisciplineDTO> disciplineDto = new ArrayList<>();
        for (Discipline discipline : disciplines) {
            disciplineDto.add(DisciplineMapper.INSTANCE.toDTO(discipline));
        }
        return disciplineDto;
    }

    public DisciplineDTO deleteById(Integer id) {
        Discipline Discipline = disciplineRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No Discipline find by id : " + id));
        disciplineRepository.deleteById(id);
        DisciplineDTO disciplineDTO = DisciplineMapper.INSTANCE.toDTO(Discipline);
        return disciplineDTO;
    }
}
