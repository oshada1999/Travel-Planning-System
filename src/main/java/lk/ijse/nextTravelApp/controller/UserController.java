package lk.ijse.nextTravelApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.nextTravelApp.dto.UserDTO;
import lk.ijse.nextTravelApp.service.UserService;
import lk.ijse.nextTravelApp.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping()
    public ResponseUtil saveUser(@RequestParam("file") MultipartFile file,
                                 @RequestParam("user") String user) throws IOException {

        UserDTO userDTO = new ObjectMapper().readValue(user, UserDTO.class);

        return new ResponseUtil(200, "save", userService.saveUser(userDTO, file));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseUtil(200, "update", null);
    }

    @DeleteMapping(params = {"userId"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam int userId) {
        userService.deleteUser(userId);
        return new ResponseUtil(200, "deleted", null);
    }

   /* @GetMapping(path = "/{userId}")
    public ResponseUtil searchUser(@PathVariable int userId) {
        return new ResponseUtil(200,"Ok",userService.searchUser(userId));
    }*/

    @GetMapping(path = "{email}/{password}")
    public ResponseUtil loginUserFind(@PathVariable("email")String email,@PathVariable("password")String password) throws JsonProcessingException {

        userService.loginUserFind(email,password);

        return new ResponseUtil(200,"isPresent",null);
    }


   /* @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUsers() {
        return new ResponseUtil(200, "AllUsersGet", userService.getAllUsers());
    }*/
}
