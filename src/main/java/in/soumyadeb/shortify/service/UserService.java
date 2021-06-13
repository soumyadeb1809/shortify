package in.soumyadeb.shortify.service;

import in.soumyadeb.shortify.dto.CreateUserRequest;

public interface UserService {

    /**
     * Service to create a new User.
     *
     * @param request dto
     * @return Id of the created User
     */
    Integer createUser(CreateUserRequest request);
}
