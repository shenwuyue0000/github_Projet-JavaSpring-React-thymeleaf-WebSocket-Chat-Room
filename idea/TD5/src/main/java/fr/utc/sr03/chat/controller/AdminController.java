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
@RequestMapping("admin")   //到 /admin 的请求 处理函数
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("")
    public String test(@RequestParam String id, @ModelAttribute User user, Model model) {
        model.addAttribute("id", id);
        int id_i=Integer.parseInt(id);
        List<User> user_bd= userRepository.findById(id_i);
        model.addAttribute("user_bd", user_bd);



        return "admin";

    }

    //@ResponseBody
    @GetMapping("chats")  //到 /admin/chats 的请求 处理函数   GET
    //public String getChatList(@ModelAttribute List<User> user_bd, @ModelAttribute List<ChatRoom> chats, Model model) {
    public String getChatList(@RequestParam int id, Model model){
    //public String getChatList(@RequestParam List<User> user_bd, @RequestParam List<ChatRoom> chats, Model model) {
        List<ChatRoom> chats = chatRepository.findAll();   //全都列出来
        List<User> user_bd= userRepository.findById(id);
        //List<User> user_bd= (List<User>) model.getAttribute("user_bd");
        model.addAttribute("user_bd", user_bd);

        model.addAttribute("chats", chats);

        model.addAttribute("id", id);

        return "utilisateur";
    }

    @GetMapping("chats/add")  //到 /admin/chats/add 的请求 处理函数   GET
    public String addChatForm(@RequestParam int id, Model model) {
        //model.addAttribute("user", new User());
        model.addAttribute("chat", new ChatRoom(id));

        return "chat_form";
    }

    @PostMapping("chats/add")   //到 /admin/users/add 的请求 处理函数   POST
    public String addChat(@RequestParam int id, @ModelAttribute ChatRoom chat, Model model) {

        List<ChatRoom> chats = chatRepository.findByTempsDebutAndTempsFin(chat.getTempsDebut(),chat.getTempsFin());
        if(chats.size() !=0){
            //修改BD
            chatRepository.update(chat.getTempsDebut(),chat.getTempsFin(),chat.getNbUsers());
        }else {
            chat.setProprietaire(id);
            chatRepository.save(chat);  //存到BD
        }

        model.addAttribute("chat",chat);
        return "chat_form";     //页面跳转 user_form.html
    }

    @GetMapping("users")  //到 /admin/users 的请求 处理函数   GET
    public String getUserList(@RequestParam int id, Model model) {
        List<User> users = userRepository.findAll();   //全都列出来
        List<User> users_f = userRepository.findByFirstNameAndLastName("fsfsf","dsfdsf");
        model.addAttribute("users", users);
        model.addAttribute("users_f", users_f);   //

        List<User> user_bd= userRepository.findById(id);
        model.addAttribute("user_bd", user_bd);
        model.addAttribute("id", id);


        //return "user_list";  老师例子
        return "users";
    }

    @GetMapping("users/add")  //到 /admin/users/add 的请求 处理函数   GET
    public String getUserForm(Model model) {   //往前台传数据 通过el表达式 ${}可以获取到 可以传对象
        model.addAttribute("user", new User());
        return "user_form";    //页面跳转 user_form.html
    }

    @PostMapping("users/add")   //到 /admin/users/add 的请求 处理函数   POST
    public String addUser(@ModelAttribute User user, Model model) {
        System.out.println("===> first name = " + user.getFirstName());
        System.out.println("===> last name = " + user.getLastName());
        //user.setMail("");
        //user.setPassword("");

        List<User> users = userRepository.findByFirstNameAndLastName(user.getFirstName(),user.getLastName());
        if(users.size() !=0){
            //修改BD
        userRepository.update(user.getFirstName(),user.getLastName(),user.getMail(),user.getPassword());
        }else {
            user.setAdmin(0);
            userRepository.save(user);  //存到BD
        }


        return "user_form";     //页面跳转 user_form.html
    }


}
