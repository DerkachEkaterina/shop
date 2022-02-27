package com.derkachekaterina.shop.users;



import com.derkachekaterina.shop.exception.UserExistException;
import com.derkachekaterina.shop.rest.dto.user.User;

import java.util.List;

public interface UserService {

    void addUser(User user) throws UserExistException;

    List<User> getUsers();

    Long getUserId(String number);
}
