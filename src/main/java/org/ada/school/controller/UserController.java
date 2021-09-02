package org.ada.school.controller;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> all() {
        try {
            return ResponseEntity.ok(userService.all());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok(userService.create(new User(userDto)));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id) {
        try{
        return ResponseEntity.ok(userService.update(userDto, id));
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.deleteById(id));
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
