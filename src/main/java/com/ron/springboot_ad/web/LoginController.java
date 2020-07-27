package com.ron.springboot_ad.web;

import com.ron.springboot_ad.domain.User;
import com.ron.springboot_ad.domain.UserRepository;
import com.ron.springboot_ad.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm",new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/register")
//    public String register(@RequestParam String username,
//                           @RequestParam String password,
//                           @RequestParam String email,
//                           @RequestParam Integer phone) {
    public String register(@Valid UserForm userForm, BindingResult result, Model model) {
        if (!userForm.confirmPassword()) {
            result.rejectValue("confirmPassword","confirmError","兩次密碼不一致");
        }
        if (result.hasErrors()) {
            return "register";
        }
//        boolean boo = true;
//        if (!userForm.confirmPassword()) {
//            result.rejectValue("confirmPassword","confirmError","兩次密碼不一致");
//            boo = false;
//        }
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors =result.getFieldErrors();
//            for (FieldError error : fieldErrors) {
//                System.out.println(error.getField() + ":" + error.getDefaultMessage() + ":" + error.getCode());
//            }
//            boo = false;
//        }
//        if (!boo) {
//            return "register";
//        }
        User user = userForm.convertToUser();
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/exception")
    public String testException() {
        throw new RuntimeException("測試異常處理");
    }
}
