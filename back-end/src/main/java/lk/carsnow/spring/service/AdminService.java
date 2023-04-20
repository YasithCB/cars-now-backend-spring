package lk.carsnow.spring.service;

import lk.carsnow.spring.dto.AdminDTO;

import java.util.ArrayList;

public interface AdminService {

    void addAdmin(AdminDTO dto);

    void deleteAdmin(String id);

    void updateAdmin(AdminDTO dto);

    ArrayList<AdminDTO> getAllAdmins();

    AdminDTO findByPasswordAndUsername(String password, String name);

}
