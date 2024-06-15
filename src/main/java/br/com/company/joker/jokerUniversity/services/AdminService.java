package br.com.company.joker.jokerUniversity.services;

import br.com.company.joker.jokerUniversity.dtos.AdminDTO;
import br.com.company.joker.jokerUniversity.exceptions.EntidadeNotFoundException;
import br.com.company.joker.jokerUniversity.mappers.AdminMapper;
import br.com.company.joker.jokerUniversity.models.Admin;
import br.com.company.joker.jokerUniversity.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public AdminDTO save(AdminDTO adminDTO) {
        Admin adminSave = new Admin(adminDTO);
        adminRepository.save(adminSave);
        AdminDTO adminDTOSave = AdminMapper.INSTANCE.toDTO(adminSave);
        return adminDTOSave;
    }

    public AdminDTO update(AdminDTO adminDTO) {
        Integer adminID = adminDTO.getAdminID();
        Admin admin = adminRepository.findById(adminID).orElseThrow(
                () -> new EntidadeNotFoundException("No admin found by id :" + adminID));
        adminRepository.save(AdminMapper.INSTANCE.toEntity(adminDTO));
        AdminDTO AdminDTOSave = AdminMapper.INSTANCE.toDTO(admin);
        return AdminDTOSave;
    }

    public AdminDTO findById(Integer id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No admin found by id :" + id));
        AdminDTO AdminDTO = AdminMapper.INSTANCE.toDTO(admin);
        return AdminDTO;
    }

    public List<AdminDTO> findAll() {
        List<Admin>  admins = adminRepository.findAll();
        if (admins.isEmpty())
            throw new NoSuchElementException("No admin found!");
        List<AdminDTO> adminsDto = new ArrayList<>();
        for (Admin  admin : admins) {
            adminsDto.add(AdminMapper.INSTANCE.toDTO(admin));
        }
        return adminsDto;
    }

    public AdminDTO deleteById(Integer id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new EntidadeNotFoundException("No admin found by id : " + id));
        adminRepository.deleteById(id);
        AdminDTO AdminDTO = AdminMapper.INSTANCE.toDTO(admin);
        return AdminDTO;
    }
}
