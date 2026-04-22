package com.example.demo.Controller;

import com.example.demo.Entity.Member;
import com.example.demo.Service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@Validated
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public Member addMember(@Valid  @RequestBody Member m){
        return memberService.addMember(m);
    }

    @GetMapping("/all")
    public List<Member> getAllMember(){
        return memberService.getAllMember();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@Positive @PathVariable int id){
        return memberService.getMemberById(id);
    }

    @PutMapping("/update/{id}")
    public Member updateMember(@Valid @RequestBody Member m){
        return memberService.updateMember(m);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMemberById(@Positive @PathVariable int id){
        return memberService.deleteMemberById(id);
    }

    @GetMapping("/bill/{id}")
    public String calculateBill(@Positive @PathVariable int id){
        return memberService.calculateBill(id);
    }

}
