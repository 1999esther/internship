//package com.esther.internship.controller;
//
//import com.esther.internship.model.Users;
//import com.esther.internship.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    UserService userservice;
//
//    //entry point, program begins here
//    @GetMapping("/")
//    public String welcome(){
//        return "welcome";
//    }
//
//    //routes to the login page
//
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//
//    /*routes to the signup page
//      Creates a new User object and adds it to the model,
//      making it accessible in the Thymeleaf template*/
//    @GetMapping("/signup")
//    public String signUp(Model model){
//        model.addAttribute("users", new Users());
//        return "signup";
//    }
//
//    //to be continued, return incomplete
//    @PostMapping("/register")
//    public String userRegistration(@ModelAttribute Users users){
//
//        userservice.registerUser(users);
//
//        return "redirect:/login";
//
//    }
//
//    @PostMapping("/loginvalidator")
//    public String loginValidator(@ModelAttribute Users users){
//        userservice.validateLogin(users);
//        return "internship";
//    } @PostMapping("/loginvalidator")
//    public String loginValidator(@ModelAttribute Users users){
//        userservice.validateLogin(users);
//        return "internship";
//    }
//
//
//}

package com.esther.internship.controller;

import com.esther.internship.model.Internship;
import com.esther.internship.model.Users;
import com.esther.internship.repository.UserRepository;
import com.esther.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userservice;

    @Autowired
    UserRepository userrepository;

    //entry point, program begins here
    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    //routes to the login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    /*routes to the signup page
      Creates a new User object and adds it to the model,
      making it accessible in the Thymeleaf template*/
    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("users", new Users());
        return "signup";
    }

    //to be continued, return incomplete
    @PostMapping("/register")
    public String userRegistration(@ModelAttribute Users users) {

        userservice.registerUser(users);

        return "redirect:/login";

    }


    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        userrepository.findByName(username);
        Users user = userrepository.findByName(username);
        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/internshipForm"; // Redirect to home page upon successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

//    @GetMapping("/internshipForm")
//    public String signUp() {
//        return "internshipForm";
//    }

//   @PostMapping("/internshipForm")
//   public String checkEmail(@RequestParam("fullname") String fullname,
//                             @RequestParam("email") String email,
//                             Model model){
//            internshiprepository.getName(fullname);
//            Internship application=internshiprepository.getName(fullname);
//    }
////
//
//
//
//    }






    @GetMapping("/internshipForm")
    public String showApplicationForm(Model model) {
        model.addAttribute("application", new Internship());
        return "internshipForm";
    }

    @PostMapping("/apply")
    public String submitApplication(@ModelAttribute Internship application, @RequestParam("email") String email) {
        boolean emailExists = userservice.validateEmail(email);
            if(emailExists){
                return "emailExistsError";
        }
        else{

            userservice.saveApplication(application);
            return "application-success";
        }
    }
}






