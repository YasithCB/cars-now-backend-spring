/**
 * author  Yasith C Bandara
 * created 4/19/2023 - 3:13 PM
 * project back-end
 */

package lk.carsnow.spring.service.impl;

import lk.carsnow.spring.dto.UsersDTO;
import lk.carsnow.spring.entity.Users;
import lk.carsnow.spring.repo.UserRepo;
import lk.carsnow.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(UsersDTO usersDTO) {
        if (!userRepo.existsById(usersDTO.getUserId())) {
            userRepo.save(mapper.map(usersDTO, Users.class));

        } else {
            //throw new RuntimeException(usersDTO.getUserId() + " " + "User Already Exists..!");
        }
    }

    @Override
    public void updateUser(UsersDTO usersDTO) {
        if (userRepo.existsById(usersDTO.getUserId())) {
            userRepo.save(mapper.map(usersDTO, Users.class));
        } else {
            throw new RuntimeException(usersDTO.getUserId() + " " + "No Such User..! Please Check The Correct Id..!");
        }
    }

    @Override
    public void deleteUser(String id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException(id + " " + "No Such User..! Please Check The Correct Id..!");
        }
    }

    @Override
    public UsersDTO searchUser(String id) {
        if (userRepo.existsById(id)) {
            Users users = userRepo.findById(id).get();
            return mapper.map(users, UsersDTO.class);
        } else {
            throw new RuntimeException(id + " " + "No Such User..! Please Check The Id..!");
        }
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> all = userRepo.findAll();
        return mapper.map(all, new TypeToken<List<UsersDTO>>() {
        }.getType());
    }

    @Override
    public String generateUserIds() {
        return userRepo.generateUserId();
    }

    @Override
    public UsersDTO findByPasswordAndUsername(String password, String username) {
        Users data = userRepo.findByPasswordAndUsername(password, username);
        return mapper.map(data, UsersDTO.class);
    }

    @Override
    public UsersDTO findByUsername(String username) {
        Users users = userRepo.findByUsername(username);
        return mapper.map(users, UsersDTO.class);
    }
}
