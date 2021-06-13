package in.soumyadeb.shortify.service;

import in.soumyadeb.shortify.dto.CreateUserRequest;
import in.soumyadeb.shortify.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * Service to create a new User.
     *
     * @param request dto
     * @return Id of the created User
     */
    Integer createUser(CreateUserRequest request);

    /**
     * Service to get a list of user.
     *
     * @return List of UserDto
     */
    List<UserDto> getUsers();
}
