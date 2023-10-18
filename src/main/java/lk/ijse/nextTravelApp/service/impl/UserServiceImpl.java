package lk.ijse.nextTravelApp.service.impl;

import lk.ijse.nextTravelApp.dto.UserDTO;
import lk.ijse.nextTravelApp.entity.User;
import lk.ijse.nextTravelApp.repository.UserRepository;
import lk.ijse.nextTravelApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO, MultipartFile file) throws IOException {
        if (!userRepository.existsByEmail(userDTO.getEmail())) {
            if (!userRepository.existsByNic(userDTO.getNic())) {
                User user = new User();
                user.setUserId(userDTO.getUserId());
                user.setUserName(userDTO.getUserName());
                user.setPassword(userDTO.getPassword());
                user.setAge(userDTO.getAge());
                user.setContact(userDTO.getContact());
                user.setEmail(userDTO.getEmail());
                user.setAddress(userDTO.getAddress());
                user.setGender(userDTO.getGender());
                user.setNic(userDTO.getNic());
                user.setProfilePic(file.getBytes());
                return mapper.map(userRepository.save(user), UserDTO.class);
            } else {
                throw new RuntimeException("This NIC Already exist!");
            }


        } else {
            throw new RuntimeException("This Email Already exist!");
        }

    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getUserId())) {
            userRepository.save(mapper.map(userDTO, User.class));
        } else {
            throw new RuntimeException("No Such User To Update..! Please Check the ID..!");
        }
    }

    @Override
    public void deleteUser(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new RuntimeException("Please check the User ID.. No Such Customer..!");
        }
    }

    @Override
    public UserDTO searchUser(int userId) {
        if (userRepository.existsById(userId)) {
            Optional<User> byId = userRepository.findById(userId);

            return mapper.map(userRepository.findById(userId), UserDTO.class);
        } else {
            throw new RuntimeException("Search Failed, No Item Available For " + userId);
        }
       /* Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent()){
            User user = byId.get();
            byte[] profilePic = user.getProfilePic();
        }*/
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapper.map(userRepository.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    @Override
    public void loginUserFind(String email, String password) {
        if (userRepository.existsByEmail(email)) {
            User loginUser = userRepository.getByEmail(email);
            if (!loginUser.getPassword().equals(password))
                throw new RuntimeException("Wrong Password!");
        } else {
            throw new RuntimeException("Wrong Email Address!");
        }
    }


}
