package com.streams.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private String surname;
    private int age;
    private List<String> skills;
}
