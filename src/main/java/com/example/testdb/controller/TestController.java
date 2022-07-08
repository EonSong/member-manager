package com.example.testdb.controller;

import com.example.testdb.model.dto.MemberInfo;
import com.example.testdb.service.MemberService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
public class TestController {

    @Autowired
    private MemberService ms;

    @RequestMapping("/")
    public String home(Model model){
        List<MemberInfo> member = ms.getAll();
        model.addAttribute("member", member);
        log.info("home!");
        return "/home";
    }

    @RequestMapping("insert")
    public String insert(){
        return "/insert";
    }

    @PostMapping("/insertMember")
    public String insertMember(@RequestParam String name, @RequestParam String team,
                               @RequestParam String position, @RequestParam String email,
                               @RequestParam String phone, Model model){
        log.info("####Insert Start####");
        log.info("이름 : {} 부서 : {} 직책 : {} 이메일 : {} 핸드폰 : {}", name, team, position, email, phone);
        int success = ms.inertMember(name, team, position, email, phone);

        if (success > 0){
            log.info("Insert Success!");
        }else {
            log.info("Insert Failed!");
        }
        List<MemberInfo> member = ms.getAll();
        model.addAttribute("member", member);

        return "/home";

    }

    @GetMapping("/delete")
    public String deleteMember(@RequestParam int num,Model model){
        log.info("####Delete Start####");
        log.info("num = " + num);
        int success = ms.deleteMember(num);
        if (success > 0){
            log.info("Delete Success!");
        }else {
            log.info("Delete Failed!");
            return "/error";
        }
        List<MemberInfo> member = ms.getAll();
        model.addAttribute("member", member);
        return "/home";

    }

    @PostMapping("/searching")
    public String search(@RequestParam int searchType, @RequestParam String word, Model model){
        List<MemberInfo> member = new ArrayList<>();
        switch (searchType){
            case 1:
                log.info("이름검색 : " + word);
                member = ms.searchName(word);
                break;
            case 2:
                log.info("직책검색 : " + word);
                member = ms.searchPosition(word);
                break;
            case 3:
                log.info("부서검색 : " + word);
                member = ms.searchTeam(word);
                break;
        }
        model.addAttribute("member", member);
        return "/home";
    }
}
