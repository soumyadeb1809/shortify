package in.soumyadeb.shortify.service.impl;

import in.soumyadeb.shortify.dto.CreateUserRequest;
import in.soumyadeb.shortify.dto.UserDto;
import in.soumyadeb.shortify.entity.User;
import in.soumyadeb.shortify.repository.UserRepository;
import in.soumyadeb.shortify.service.UserService;
import in.soumyadeb.shortify.util.DtoFactory;
import in.soumyadeb.shortify.util.EntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    @Override
    public Integer createUser(CreateUserRequest request) {
        User user = new User();

        try {
            EntityBuilder.build(user, request);
            userRepo.save(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> getUsers() {
        List<UserDto> users = new ArrayList<>();

        try {
            List<User> userRecords = userRepo.findAll();
            userRecords.forEach(user -> users.add(DtoFactory.createUserDto(user)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
