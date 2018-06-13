package com.ratpack.downloadhound.data.controller.admin;

import com.ratpack.downloadhound.data.entity.User;
import com.ratpack.downloadhound.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class UserTableController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/tables/users")
    @GetMapping
    public String displayUsers(Model model){

        List<User> userList = userService.getAllUsers();

        model.addAttribute("users", userList);
        model.addAttribute("user", new User());
        return "/admin/tables/users";
    }

    @RequestMapping(value = "/admin/tables/users/active")
    @PostMapping
    public ModelAndView modifyUser(Model model, String id){

        if(!id.isEmpty()){
            try {
                userService.changeUserStatus(Long.parseLong(id));
            } catch (Exception ex){
                return new ModelAndView("redirect:/admin/tables/users");
            }
        }

        return new ModelAndView("redirect:/admin/tables/users");
    }

    @RequestMapping(value = "/admin/tables/users/add")
    @PostMapping
    public ModelAndView addUser(Model model, @ModelAttribute("user") User user){

        user.setActive(true);
        user.setCreateDate(new java.sql.Date(new Date().getTime()));
        userService.upsertUser(user);

        return new ModelAndView("redirect:/admin/tables/users");
    }

    @RequestMapping(value = "/admin/tables/users/edit")
    @PostMapping
    public ModelAndView editUser(Model model, @ModelAttribute("user") User user){

        User old = userService.getUserById(user.getUser_id());
        user.setCreateDate(old.getCreateDate());
        user.setActive(old.isActive());
        user.setUserPassword(old.getUserPassword());

        userService.upsertUser(user);
        return new ModelAndView("redirect:/admin/tables/users");
    }
}
