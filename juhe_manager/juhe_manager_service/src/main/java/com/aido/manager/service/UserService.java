package com.aido.manager.service;


import com.aido.manager.repo.domain.User;

/**
 * ClassName: UserService  
 * 用户服务
 * @author DOUBLE
 * @version
 */

public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    User create(User user);

    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
    
    User findByEmail(String email);
    
    int setOutDateAndValidataCode( String outDate, String validataCode, String email);
    
    int setNewPassword( String passWord, String email);
    
    int setIntroduction(String introduction,String email);
    
    int setUserName(String userName, String email);
    
    int setProfilePicture(String profilePicture, Long id);


}