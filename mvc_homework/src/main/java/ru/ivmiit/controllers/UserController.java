package ru.ivmiit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.ivmiit.dao.interfaces.UserDao;
import ru.ivmiit.dto.AuthDto;
import ru.ivmiit.models.User;
import ru.ivmiit.services.interfaces.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("hi");
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody AuthDto authDto) {
        if (userDao.userExistenceByLogin(authDto.getLogin())) {

        }
        User user = userService.login(authDto);
        return "redirect:/users/user/" + user.getId();
    }

    @PostMapping(value = "/registration")
    public String registration(@RequestBody User user) {
        userService.registration(user);
        return "ok";
    }
}
