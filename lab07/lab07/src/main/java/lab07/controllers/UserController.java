package lab07.controllers;

import lab07.dao.UserDao;
import lab07.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/viewusers")
    public String viewUsers(Model m){
        List<User> list=userDao.getAllUsers();
        m.addAttribute("list",list);
        return "viewusers";
    }

    @RequestMapping("index")
    public String back(){
        return "../../index";
    }

    @RequestMapping(value="/show/{id}")
    public String edit(@PathVariable int id, Model m){
        User user=userDao.getUserById(id);
        m.addAttribute("command",user);
        return "editUser";
    }

    @RequestMapping(value = "show/editsave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("command") User user){
        int id = userDao.update(user);
        if (id!=-1) return  "redirect:../viewusers";
        else return "redirect:/error";
    }

    @RequestMapping(value="/saveuser",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("command") User user){
        int id = userDao.insert(user);
        if (id!=-1) return "redirect:/viewusers";
        else return "redirect:/error";
    }

    @RequestMapping("/addUser")
    public String addUser(Model m){
        m.addAttribute("command", new User());
        return "addUser";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        int i = userDao.delete(id);
        if (i!=-1) return "redirect:/viewusers";
        else return "redirect:/error";
    }

    @RequestMapping("/error")
    public String viewUsers(){
        return "error";
    }
}
