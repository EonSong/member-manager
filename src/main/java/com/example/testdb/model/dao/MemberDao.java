package com.example.testdb.model.dao;

import com.example.testdb.model.dto.MemberInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDao {
    List<MemberInfo> selectMemberList();
    List<MemberInfo> searchMemberName(String name);
    List<MemberInfo> searchMemberPosition(String position);
    List<MemberInfo> searchMemberTeam(String team);
    int insertMember(String name, String team, String position, String email, String phone);
    int deleteMember(int num);
}
