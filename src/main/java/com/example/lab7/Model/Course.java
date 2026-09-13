package com.example.lab7.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
@NotEmpty(message = "id Should not be Empty")
@Size(min = 2,message = "id length should be 2 and more")
private String id;


@NotEmpty(message = "title should not be Empty")
@Size(min = 6,max = 20,message = "title should be between 6 and 20")
@Pattern(regexp = "^[a-zA-Z0-9\\u0600-\\u06FF\\s]+$",message = "title only letters and numbers please ")
private String title;


@NotEmpty(message = "description should not be Empty")
@Size(min=20,max=100,message = "description length should be between 20 and 100 ")
@Pattern(regexp = "^[a-zA-Z0-9\\u0600-\\u06FF\\s]+$",message = "description only letters and numbers please ")
private String description;


@NotEmpty(message ="Category Should not be Empty")
@Pattern(regexp = "^(Programming|Business|Languages|Science)$",flags =Pattern.Flag.CASE_INSENSITIVE,message = "it should be only Programming or Business or Languages or Science")
private String Category;

@NotEmpty(message ="Level Should not be Empty")
@Pattern(regexp = "^(Beginner|Intermediate|Advanced)$",message = "it should be Beginner or Intermediate or Advanced")
private String level;

@NotNull(message = "price Should not be Empty")
private Double price;

//set false is default
private boolean isPublished;//في حال انتشر الكورس وجاهز للتسجيل





























}
