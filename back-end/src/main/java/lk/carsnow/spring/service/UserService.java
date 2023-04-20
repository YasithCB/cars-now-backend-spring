package lk.carsnow.spring.service;

import lk.carsnow.spring.dto.UsersDTO;

import java.util.List;

public interface UserService {
    void saveUser(UsersDTO usersDTO);

    void updateUser(UsersDTO usersDTO);

    void deleteUser(String id);

    UsersDTO searchUser(String id);

    List<UsersDTO> getAllUsers();

    String generateUserIds();

    UsersDTO findByPasswordAndUsername(String password, String username);

    UsersDTO findByUsername(String username);
}
