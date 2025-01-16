package com.example.demo.Controller;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    @Autowired
    UserController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UsersDTO usersDTO) {
        if(userService.addUser(usersDTO) == null) {
            return ResponseEntity.status(400).body("User Not Registered");
        } else {
            return ResponseEntity.ok(userService.addUser(usersDTO));
        }
    }

    // 사용자 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        if(userService.getUserById(id) == null) {
            return ResponseEntity.status(400).body("User Not Found");
        } else {
            return ResponseEntity.ok(userService.getUserById(id));
        }
    }

    // 사용자 수정
    @PatchMapping("/")
    public ResponseEntity<?> updateUser(@RequestBody UsersDTO usersDTO) {
        if(userService.updateUser(usersDTO)) {
            return ResponseEntity.ok("Update Successful");
        } else {
            return ResponseEntity.status(400).body("User Not Found");
        }
    }


    // 사용자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        if(userService.deleteUser(id)) {
            return ResponseEntity.ok("Delete Successful");
        } else {
            return ResponseEntity.status(400).body("User Not Found");
        }
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        if(userService.login(loginDTO) == null) {
            return ResponseEntity.status(400).body("User Not Found");
        } else {
            return ResponseEntity.ok(userService.login(loginDTO));
        }
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        userService.logout();
        return ResponseEntity.ok("Logged out successfully");
    }

    // 현재 로그인 상태 확인
    @GetMapping("/session")
    public ResponseEntity<String> getSessionStatus() {
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
        if (isLoggedIn != null && isLoggedIn) {
            String userName = (String) session.getAttribute("userName");
            return ResponseEntity.ok("Logged in as: " + userName);
        }
        return ResponseEntity.ok("Not logged in");
    }

}
