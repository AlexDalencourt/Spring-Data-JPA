package fr.formation.sdj.controller;

import fr.formation.sdj.beans.LoginForm;
import fr.formation.sdj.entities.User;
import fr.formation.sdj.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean doLogin(@RequestBody final LoginForm form, final ModelMap model, final HttpSession session) {
        final User user = userRepository.findByLoginAndPassword(form.getLogin(), form.getPassword());
        if (user != null) {
            session.setAttribute("userLogged", user);
        }
        return user != null;
    }

    @GetMapping("/logout")
    public String doLogout(final HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    public void setUserRepository(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
