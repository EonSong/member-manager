package com.example.testdb.service;

import com.example.testdb.model.dao.MemberDao;
import com.example.testdb.model.dto.MemberInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@MapperScan("com.example.testdb.model.dao")
public class MemberService {

    @Autowired
    private MemberDao memberdao;

    public MemberService(MemberDao memberdao){
        this.memberdao = memberdao;
    }

    public List<MemberInfo> getAll(){
         return memberdao.selectMemberList();
    }

    public List<MemberInfo> searchName(String name){
        return memberdao.searchMemberName(name);
    }

    public List<MemberInfo> searchPosition(String position) {
        return memberdao.searchMemberPosition(position);
    }

    public List<MemberInfo> searchTeam(String team) {
        return memberdao.searchMemberTeam(team);
    }

    public int inertMember(String name, String team, String position, String email, String phone) {
        return memberdao.insertMember(name,team,position,email,phone);
    }

    public int deleteMember(int num) {
        return memberdao.deleteMember(num);
    }
}
