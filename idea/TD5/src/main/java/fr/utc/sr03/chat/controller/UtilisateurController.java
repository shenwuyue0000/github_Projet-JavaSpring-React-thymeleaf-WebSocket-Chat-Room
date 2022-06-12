package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.dao.ChatRepository;
import fr.utc.sr03.chat.model.User;
import fr.utc.sr03.chat.model.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("utilisateur")   //到 /admin 的请求 处理函数
public class UtilisateurController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("")
    public String utilisateur(@RequestParam String id, @ModelAttribute User user, Model model) {
        model.addAttribute("id", id);
        int id_i=Integer.parseInt(id);
        List<User> user_bd= userRepository.findById(id_i);
        model.addAttribute("user_bd", user_bd);

        List<ChatRoom> chats= chatRepository.findAll();
        //List<ChatRoom> chats= chatRepository.findById(1);
        model.addAttribute("chats", chats);


        return "utilisateur";

    }

}