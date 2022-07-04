//package com.inventorycontrol.http.controller;
//
//import com.inventorycontrol.http.dto.request.UserRequest;
//import com.inventorycontrol.http.dto.response.UserResponse;
//import com.inventorycontrol.http.mapper.UserMapper;
//import com.inventorycontrol.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.UUID;
//
//@AllArgsConstructor
//@RestController
//@RequestMapping("/user")
//@Validated
//public class UserController {
//
//    private final UserService userService;
//
//    @GetMapping("/all")
//    public ResponseEntity<List<UserResponse>> findAll(){
//        return ResponseEntity.ok().body(UserMapper.toResponseList(userService.findAll()));
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<UserResponse> findById(@PathVariable String userId){
//        return ResponseEntity.ok().body(UserMapper.toResponse(userService.findById(UUID.fromString(userId))));
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
//        return ResponseEntity.ok().body(UserMapper.toResponse(userService.save(UserMapper.toModel(userRequest))));
//    }
//
//    @PutMapping("/{userId}")
//    public ResponseEntity<UserResponse> update(@RequestBody @Valid UserRequest userRequest, @PathVariable String userId){
//        return ResponseEntity.ok().body(UserMapper.toResponse(userService.update(UserMapper.toModel(userRequest), UUID.fromString(userId))));
//    }
//
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<UUID> delete(@PathVariable String userId){
//        return ResponseEntity.ok().body(userService.delete(UUID.fromString(userId)));
//    }
//}
