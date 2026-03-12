package com.quantdev.lab1.controller;

import com.quantdev.lab1.entity.ResponseUser;
import com.quantdev.lab1.entity.User;
import com.quantdev.lab1.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {this.userService = userService;}
    @PostMapping("/register")
    public ResponseEntity<ResponseUser> register(@RequestBody User user) {//前端理论上拿不到id，所以前端随便返一个id回来
        if(userService.checkIfUserExists(user.getUserName())>0){
            return ResponseEntity.badRequest().body(new ResponseUser(user.getUserName(),user.getId(),"failed"));
        }
        userService.registerUser(user);
        return ResponseEntity.ok(new ResponseUser(user.getUserName(),user.getId(),"success"));
    }
    @PostMapping("/login")
    public ResponseEntity<ResponseUser> login(@RequestBody User _user, HttpSession session) {//这里同理，随便给一个id，无所谓
        if(userService.checkIfUserExists(_user.getUserName())==0){
            return ResponseEntity.badRequest().body(new ResponseUser(_user.getUserName(),_user.getId(),"no such user, please register first"));
        }
        User user=userService.getUserByuserName(_user.getUserName());
        if(user.getPassWord().equals(_user.getPassWord())){
            session.setAttribute("userID",user.getId());
            return ResponseEntity.ok(new ResponseUser(user.getUserName(),user.getId(),"success"));
        }else{
            return ResponseEntity.badRequest().body(new ResponseUser(user.getUserName(),user.getId(),"incorrect password"));
        }
    }
}
