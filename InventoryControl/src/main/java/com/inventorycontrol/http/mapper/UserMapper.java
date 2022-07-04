//package com.inventorycontrol.http.mapper;
//
//import com.inventorycontrol.http.dto.request.UserRequest;
//import com.inventorycontrol.http.dto.response.UserResponse;
//import com.inventorycontrol.model.UserModel;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static java.util.Objects.isNull;
//
//@Component
//public class UserMapper {
//
//    public static UserModel toModel(UserRequest userRequest) {
//        return UserModel.builder()
//                .login(userRequest.getLogin())
//                .password(userRequest.getPassword())
//                .build();
//    }
//
//    public static UserResponse toResponse(UserModel userModel) {
//        return UserResponse.builder()
//                .codUser(userModel.getCodUser())
//                .login(userModel.getLogin())
//                .password(userModel.getPassword())
//                .build();
//    }
//
//    public static List<UserResponse> toResponseList(List<UserModel> userModelList) {
//        if (isNull(userModelList) || userModelList.isEmpty()) {
//            return new ArrayList<>();
//        } else {
//            return userModelList.stream().map(UserMapper::toResponse).collect(Collectors.toList());
//        }
//    }
//}
