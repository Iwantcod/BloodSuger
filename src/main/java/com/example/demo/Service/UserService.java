package com.example.demo.Service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserResponseDTO;
import com.example.demo.DTO.UserSessionDTO;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.UsersRepository;
import com.example.demo.Util.PasswordUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final HttpSession session;

    @Autowired
    UserService(UsersRepository usersRepository, HttpSession session) {
        this.usersRepository = usersRepository;
        this.session = session;
    }


    private UserResponseDTO toResponseDTO(Users user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUserName(user.getUserName());
        responseDTO.setUserAddress(user.getUserAddress());
        responseDTO.setUserAge(user.getUserAge());
        responseDTO.setUserGender(user.isUserGender());
        responseDTO.setUserBloodSugerLevel(user.getUserBloodSugerLevel());
        responseDTO.setId(user.getId());
        return responseDTO;
    }

    @Transactional
    public UserResponseDTO addUser(UsersDTO usersDTO) {
        if(usersRepository.findByUserName(usersDTO.getUserName()).isPresent()){
            return null;
        }

        String hashedPassword = PasswordUtil.encodePassword(usersDTO.getPassword());
        Users user = new Users();
        user.setUserName(usersDTO.getUserName());
        user.setPassword(hashedPassword);
        user.setUserAge(usersDTO.getUserAge());
        user.setUserGender(usersDTO.isUserGender());
        user.setUserBloodSugerLevel(usersDTO.getUserBloodSugerLevel());
        user.setUserAddress(usersDTO.getUserAddress());

        Users savedUser = usersRepository.save(user);
        return toResponseDTO(savedUser);
    }

    public UserResponseDTO getUserById(int id) {
        Optional<Users> user = usersRepository.findById(id);
        return user.map(this::toResponseDTO).orElse(null);

    }

    public boolean updateUser(UsersDTO usersDTO) {
        Optional<Users> user = usersRepository.findById(usersDTO.getId());
        if(user.isEmpty()){
            return false;
        }
        user.get().setUserName(usersDTO.getUserName());
        user.get().setUserAddress(usersDTO.getUserAddress());
        user.get().setUserAge(usersDTO.getUserAge());
        user.get().setUserGender(usersDTO.isUserGender());
        user.get().setUserBloodSugerLevel(usersDTO.getUserBloodSugerLevel());
        // 비밀번호 해싱
        user.get().setPassword(PasswordUtil.encodePassword(usersDTO.getPassword()));

        usersRepository.save(user.get());
        return true;
    }

    public boolean deleteUser(int id) {
        if (!usersRepository.existsById(id)) {
            return false;
        } else {
            usersRepository.deleteById(id);
            return true;
        }
    }

    @Transactional(readOnly = true)
    public UserResponseDTO login(LoginDTO loginDTO) {
        Optional<Users> user = usersRepository.findByUserName(loginDTO.getUserName());
        if(user.isEmpty()){
            return null;
        }
        if(!PasswordUtil.matches(loginDTO.getPassword(), user.get().getPassword())){
            return null;
        }

        session.setAttribute("userId", user.get().getId());
        session.setAttribute("userName", user.get().getUserName());
        session.setAttribute("isLoggedIn", true);

        return toResponseDTO(user.get());
    }

    // 로그아웃 메서드 추가
    public void logout() {
        session.invalidate(); // 세션 무효화
    }



}
