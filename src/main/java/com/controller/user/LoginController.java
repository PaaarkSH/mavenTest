package com.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.biz.user.UserDAO;
import com.biz.user.UserVO;

@Controller
public class LoginController {
    @GetMapping("/login.do")
    public String loginView(@ModelAttribute("user")UserVO vo) throws Exception {
        vo.setId("test");
        vo.setPassword("test");
        return  "login";
    }

    @PostMapping("/login.do")
    public String login(UserVO vo, UserDAO dao, HttpSession session) throws Exception {
        UserVO user = dao.getUser(vo);
        if(user != null){
            session.setAttribute("user", user);
            return  "forward:getBoardList.do";
        } else {
            return "login";
        }

    }
}
