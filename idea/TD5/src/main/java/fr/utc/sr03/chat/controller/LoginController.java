package fr.utc.sr03.chat.controller;

import fr.utc.sr03.chat.dao.ChatRepository;
import fr.utc.sr03.chat.dao.UserRepository;
import fr.utc.sr03.chat.model.User;
import fr.utc.sr03.chat.model.ChatRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("login")   //到 /login 的请求 处理函数
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping  //用于处理请求方法的GET类型
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";    //返回html页面    登录框
    }

    @PostMapping  //用于处理请求方法的POST类型
    public String postLogin(@ModelAttribute User user, Model model) {
        //TODO verif login
        System.out.println("===> mail = " + user.getMail());
        System.out.println("===> password = " + user.getPassword());

        //List<User> users = userRepository.findAll();
        List<User> user_bd = userRepository.findByMailAndPassword(user.getMail(),user.getPassword());
        List<User> users = userRepository.findByMailAndPassword(user.getMail(),user.getPassword());

        /*
        for(User u : users ){
            List<ChatRoom> chats = chatRepository.findById(u.getId());
            for(ChatRoom c : chats){

            }
        }
        */

        List<ChatRoom> chats= chatRepository.findAll();
        //List<ChatRoom> chats= chatRepository.findById(1);
        model.addAttribute("chats", chats);

        model.addAttribute("user_bd", user_bd);

        int id= (int) user_bd.get(0).getId();
        model.addAttribute("id", id);

        if(user_bd.get(0).isAdmin()==0){   //不是admin，是user，直接看到chats页面

            //return "utilisateur";
            return "redirect:http://localhost:8080/utilisateur?id="+id;
        }



        //System.out.println(user.isAdmin());
        //System.out.println(user);


        if(users==null||users.size() ==0){   //没找到对应的用户 重新输入
            return "login";
        }

        model.addAttribute("users", users);

        if(user_bd.get(0).isAdmin()==1){   //是admin，进入admin.html 选择进一步查看users或者chats页面
            //return "admin";
            return "redirect:http://localhost:8080/admin?id="+id;
        }

        //return "redirect:http://localhost:3000/";    没用了
        return "user_list";  //显示页面 user_list.html      老师的例子  理论上不执行这里
    }

}
