package br.com.company.joker.jokerUniversity.dtos;

import lombok.Data;

import java.io.Serializable;


@Data
public class CourseDTO implements Serializable {
    Integer courseID;
    String courseName;
    String description;
    Integer duration;
}