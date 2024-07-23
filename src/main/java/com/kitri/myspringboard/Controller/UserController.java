package com.kitri.myspringboard.Controller;

import com.kitri.myspringboard.domain.User;

import com.kitri.myspringboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")  // 경로를 명확히 지정
public class UserController {

    @Autowired
    private UserService userService;  // 올바른 변수명 사용

    // 회원가입
    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signUp", new User());  // 속성 이름 소문자로 시작
        return "user/sign";
    }

    @PostMapping("/signup")  // 경로 지정 수정
    public String processSignupForm(@ModelAttribute("signUp") User user) {
        userService.signup(user);  // 서비스 클래스의 메소드 정확하게 호출
        return "redirect:/login";
    }
}
