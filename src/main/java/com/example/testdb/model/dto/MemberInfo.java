package com.example.testdb.model.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MemberInfo implements Serializable {
    private int num;
    private String team;
    private String position;
    private String name;
    private String email;
    private String phone;


}
