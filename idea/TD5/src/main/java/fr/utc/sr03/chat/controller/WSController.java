package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.ChatRepository;
import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WSController {
    /*
    @GetMapping("/user")
    public User getUser(@RequestParam(value = "fname") String firstName,
                        @RequestParam(value = "lname") String lastName) {
        return new User(firstName, lastName);
    }
    */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/user")
    public User getUser(@RequestParam(value = "userID") int userID) {
        System.out.println("axios");

        List<User> user_bd= userRepository.findById(userID);

        String firstName=user_bd.get(0).getFirstName();
        String lastName=user_bd.get(0).getLastName();
        String mail=user_bd.get(0).getMail();

        return new User(firstName,lastName,mail);

    }

}