package com.wzw.platform.controller.admin;

import com.wzw.platform.model.entity.UserEntity;
import com.wzw.platform.model.request.UserInfoRequest;
import com.wzw.platform.model.response.UserInfoResponse;
import com.wzw.platform.picture.PictureService;
import com.wzw.platform.service.UserService;
import com.wzw.platform.utils.PageResult;
import com.wzw.platform.utils.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private PictureService pictureService;

    @GetMapping("/public/user")
    public ResponseWrapper<UserEntity> userGet(){
        //int userid = SecurityAuthenUtil.getIdWithoutException();
        int userid = 1;

        UserEntity userEntity = userService.getEntityById(userid);
        log.debug("The method is ending");
        return new ResponseWrapper<>(userEntity);
    }

    @GetMapping("/users")
    public ResponseWrapper<PageResult> usersList(@RequestParam(value="name",required = false) String name,@RequestParam("pageSize") int pageSize,@RequestParam("page") int page){
        PageResult<UserEntity> pageResult=new PageResult<>();
        pageResult.setData(userService.usersList(name, pageSize, page));
        pageResult.setTotalCount(userService.userSize(name, pageSize, page));
        return  new ResponseWrapper<>(pageResult);
    }

    @PostMapping("users/user")
    public ResponseWrapper<UserEntity> insertUser(@RequestBody UserEntity userEntity){
        userService.insertUser(userEntity);
        return new ResponseWrapper<>(userEntity);
    }
    //注册
    @PostMapping("/register")
    public ResponseWrapper<UserEntity> register(@RequestBody UserEntity userEntity) {
        userService.insertUser(userEntity);
        log.debug("The method is ending");
        return new ResponseWrapper<>(userEntity);
    }

    @PutMapping("user")
    public  ResponseWrapper<UserEntity> updateUser(@RequestBody UserEntity userEntity){
        userService.updateUser(userEntity);
        return  new ResponseWrapper<>(userEntity);
    }

    @DeleteMapping("/users")
    public ResponseWrapper<List<String>> deleteUsers(@RequestBody List<String> groupId) {
        userService.deleteUsers(groupId);
        return new ResponseWrapper<>(groupId);
    }

    @GetMapping("public/users/user/info")
    //@ApiOperation("通过用户id来获取用户详情")
    public ResponseWrapper<UserInfoResponse> getUserInfoById(@RequestParam("userId") int userId){
        UserInfoResponse userInfoResponse=userService.getUserInfoById(userId);
        return  new ResponseWrapper<>(userInfoResponse);
    }

    @PutMapping("/general/users/user/info")
    public ResponseWrapper<UserInfoResponse> updateUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        //int userId = SecurityAuthenUtil.getId(); 需要解决获取登录信息
        int userId =1;

        userService.updateUserInfoByUserId(userId, userInfoRequest);
        return new ResponseWrapper<>(userInfoRequest);
    }

    @PatchMapping("/general/users/user/headImg")
    public ResponseWrapper<String> updateUserHeadImg(@RequestParam("headImg") String headImg) {
        //int userId = SecurityAuthenUtil.getId(); 需要解决获取登录信息
        int userId = 1;
        userService.updateUserHeadImg(userId, headImg);
        return new ResponseWrapper<>(headImg);
    }
    @PostMapping("/general/users/user/head-img/upload")
    public ResponseWrapper<String> uploadUserHeadImg(@RequestParam("picture") MultipartFile picture) {
        String pictureUrl = pictureService.saveImage(picture, "/head");
        return new ResponseWrapper<>(pictureUrl);
    }
}
