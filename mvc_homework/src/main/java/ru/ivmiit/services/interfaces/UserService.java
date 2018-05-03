package ru.ivmiit.services.interfaces;

import ru.ivmiit.dto.AuthDto;
import ru.ivmiit.models.User;

import java.util.List;

public interface UserService {

    User registration(User user);

    User login(AuthDto authDto);

    List<User> getUsers();
}
