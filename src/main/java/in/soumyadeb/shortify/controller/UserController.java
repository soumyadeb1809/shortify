package in.soumyadeb.shortify.controller;

import in.soumyadeb.shortify.dto.CreateResourceResponse;
import in.soumyadeb.shortify.dto.CreateUserRequest;
import in.soumyadeb.shortify.dto.ResourceListResponse;
import in.soumyadeb.shortify.dto.UserDto;
import in.soumyadeb.shortify.model.ResponseMessage;
import in.soumyadeb.shortify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public CreateResourceResponse createUser(
            @RequestBody CreateUserRequest request
            ) {
        CreateResourceResponse response = new CreateResourceResponse();

        Integer id = userService.createUser(request);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.FAILED);
        }

        return response;
    }

    @GetMapping
    public ResourceListResponse<UserDto> getUsers() {
        ResourceListResponse<UserDto> response = new ResourceListResponse<>();

        List<UserDto> users = userService.getUsers();
        response.setData(users);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }
}
