package com.hkoo.toy.blog.controller;

import com.hkoo.toy.blog.annotation.Socialuser;
import com.hkoo.toy.blog.domain.User;
import com.hkoo.toy.blog.repository.UserRepository;
import com.hkoo.toy.blog.service.BoardService;
import com.hkoo.toy.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"", "/"})
    public String board(@AuthenticationPrincipal User FormUser,@RequestParam(value = "idx", defaultValue = "0") Long idx,
                        Model model) {
        model.addAttribute("user",FormUser);
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "/board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, @AuthenticationPrincipal User FormUser, @Socialuser User socialUser, Model model){
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        User user = FormUser != null ? FormUser : socialUser;
        model.addAttribute("user",user);
        return "/board/list";
    }
}
