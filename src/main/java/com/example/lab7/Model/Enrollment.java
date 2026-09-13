package com.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Enrollment {

    @NotEmpty(message = "id Should not be Empty")
    @Size(min = 2,message = "id length should be 2 and more")
    private String id;

    @NotEmpty(message = "student id should not be Empty")
    @Size(min = 2,message = "Student id length should be 2 and more")
    private String StudentId;

    @Email(message = "invalid EmailStudent")
    private String studentEmail;

    @NotEmpty(message = " course id Should not be empty")
    @Size(min = 2,message = " Course Id length should be 2 and more")
    private String CourseId;

    @NotNull(message = "date should not be Empty")
    @JsonFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime enrolledAt;

     //مسجل ولا لا
    private boolean  isEnrolled;

































}
