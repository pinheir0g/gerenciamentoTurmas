package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.GradeRecordDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.GradeRecordMapper;
import br.com.company.joker.jokerUniversity.models.GradeRecord;
import br.com.company.joker.jokerUniversity.repositories.GradeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GradeRecordService {
    @Autowired
    GradeRecordRepository gradeRecordRepository;

    public GradeRecordDTO save(GradeRecordDTO gradeRecordDTO) {
        GradeRecord gradeRecordSave = gradeRecordRepository.save(new GradeRecord(gradeRecordDTO));
        GradeRecordDTO gradeRecordDTOSave = GradeRecordMapper.INSTANCE.toDTO(gradeRecordSave);
        return gradeRecordDTOSave;
    }

    public GradeRecordDTO update(GradeRecordDTO gradeRecordDTO) {
        Integer gradeRecordID = gradeRecordDTO.getGradeRecordID();
        GradeRecord gradeRecord = gradeRecordRepository.findById(gradeRecordID).orElseThrow(
                () -> new EntidadeNotFoundException("Não foi encontrado nenhum Historico Escolar com id " + gradeRecordID));
        ;
        gradeRecordRepository.save(gradeRecord);
        GradeRecordDTO gradeRecordDTOSave = GradeRecordMapper.INSTANCE.toDTO(gradeRecord);
        return gradeRecordDTOSave;
    }
    public GradeRecordDTO findById(Integer id) {
        GradeRecord gradeRecord = gradeRecordRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Historico Escolar  com Id " + id));
        GradeRecordDTO gradeRecordDTO = GradeRecordMapper.INSTANCE.toDTO(gradeRecord);
        return gradeRecordDTO;
    }

    public List<GradeRecordDTO> findAll() {
        List<GradeRecord>  gradeRecords = gradeRecordRepository.findAll();
        if (gradeRecords.isEmpty())
            throw new NoSuchElementException("No Grade Record Found!");
        List<GradeRecordDTO> gradeRecordsDto = new ArrayList<>();
        for (GradeRecord  gradeRecord : gradeRecords) {
            gradeRecordsDto.add(GradeRecordMapper.INSTANCE.toDTO(gradeRecord));
        }
        return gradeRecordsDto;
    }

    public GradeRecordDTO deleteById(Integer id) {
        GradeRecord gradeRecord = gradeRecordRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("Não foi encontrado nenhum Historico Escolar  com Id " + id));
        gradeRecordRepository.deleteById(id);
        GradeRecordDTO gradeRecordDto = GradeRecordMapper.INSTANCE.toDTO(gradeRecord);
        return gradeRecordDto;
    }
}
