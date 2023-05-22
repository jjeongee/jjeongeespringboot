package likelion.springbootjjeongee.controller;

import likelion.springbootjjeongee.domain.Member;
import likelion.springbootjjeongee.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final MemberService memberService;

    @GetMapping("members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new Member());
        return "members/createMemberForm";
    }
}
