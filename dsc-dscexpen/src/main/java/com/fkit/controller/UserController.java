package com.fkit.controller;

import com.fkit.model.DataGridResult;
import com.fkit.model.User;
import com.fkit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/getAllUser",produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public DataGridResult getAllUser(User user) {
        List<User> allUser = userService.getAllUser();
        DataGridResult  resu = new DataGridResult(allUser.size(),allUser);
        return resu;
    }



  /*  @RequestMapping(value = "/selectAllUser",produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public DataGridResult selectAllUser(User user) {

        JDBCUtil jdbcUtil = new JDBCUtil();
        jdbcUtil.getConnection();
        List<User> users = new ArrayList<>();
        DataGridResult resu = null;
        try {
            List<Map<String, Object>> result = jdbcUtil.findResult("select * from users", null);
            for (int i = 0; i < result.size(); i++) {
                Map<String, Object> map = result.get(i);
              //  User user = new User();
                String firstname = (String) map.get("firstname");
                String lastname = (String) map.get("lastname");
                String phone = (String) map.get("phone");
                String email = (String) map.get("email");
                user.setEmail(email);
                user.setFirstname(firstname);
                user.setLastname(lastname);
                user.setPhone(phone);
                users.add(user);
            }
              resu = new DataGridResult(users.size(), users);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resu;
    }*/
}
