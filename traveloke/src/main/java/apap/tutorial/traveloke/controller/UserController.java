package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.service.UserService;
import apap.tutorial.traveloke.model.UserModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel user, Model model){
        if(!userService.checkPassword(user.getPassword())) {
            model.addAttribute("pesan", "Password tidak valid. Password harus memiliki minimal 1 angka, 1 huruf, dan minimal 8 karakter");
            return "add-user";
        }
        userService.addUser(user);
        model.addAttribute("pesan", "User berhasil ditambahkan");
        return "add-user";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String changePasswordSubmit(String username, String oldPassword,
                                       String newPassword, String newPasswordConfirm, Model model){
        if(!userService.matchPassword(oldPassword, userService.getUserByUsername(username).getPassword())){
            model.addAttribute("pesan", "Password lama anda salah. Password tidak dapat diganti");
            return "change-password-submit";
        }
        if(!newPassword.equals(newPasswordConfirm)){
            model.addAttribute("pesan", "Konfirmasi password baru anda tidak benar");
            return "change-password-submit";
        }
        if(!userService.checkPassword(newPassword)) {
            model.addAttribute("pesan", "Password tidak valid. Password harus memiliki minimal 1 angka, 1 huruf, dan minimal 8 karakter");
            return "change-password-submit";
        }
        UserModel user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.setPassword(newPassword);
        userService.addUser(user);
        model.addAttribute("pesan", "Password berhasil diubah");
        return "change-password-submit";
    }
}
