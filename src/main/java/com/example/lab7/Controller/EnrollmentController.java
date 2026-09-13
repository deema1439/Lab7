package com.example.lab7.Controller;

import com.example.lab7.Api.ApiResponse;
import com.example.lab7.Model.Enrollment;
import com.example.lab7.Service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

private final EnrollmentService enrollmentService;

@GetMapping("/get")
public ResponseEntity<?>getEnrollments(){
    ArrayList<Enrollment> getEnrollments=enrollmentService.getEnrollments();
    return ResponseEntity.status(200).body(getEnrollments);
}

@PostMapping("/add")
public ResponseEntity<?>addEnrollment(@Valid @RequestBody Enrollment enrollment, Errors errors){
    if(errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    enrollmentService.addEnrollments(enrollment);
    return ResponseEntity.status(200).body(new ApiResponse("Enrollment has been added"));
}

@PutMapping("/update/{id}")
public ResponseEntity<?>updateEnrollment(@PathVariable String id,@Valid @RequestBody Enrollment enrollment,Errors errors){
    if(errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    boolean updateEnrollments=enrollmentService.updateEnrollments(id,enrollment);
    if(!updateEnrollments){
        return ResponseEntity.status(400).body(new ApiResponse("id not Found"));
    }
    return ResponseEntity.status(200).body(new ApiResponse("Enrollment has been updated"));
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?>deleteEnrollment(@PathVariable String id){
    boolean delete=enrollmentService.delete(id);
    if(!delete){
        return ResponseEntity.status(400).body(new ApiResponse("id not found"));
    }
    return ResponseEntity.status(200).body(new ApiResponse("Enrollment has been deleted"));
}

@PutMapping("/updateisenrollment/{studentId}/{courseId}")
public ResponseEntity<?>updateIsEnrollment(@PathVariable String studentId,@PathVariable String courseId){
    int updateEnrollmentsStudent=enrollmentService.updateEnrollmentsStudent(studentId,courseId);
    if(updateEnrollmentsStudent==0){
       return ResponseEntity.status(400).body(new ApiResponse("Student is already enrolled in this course "));
    }
    if(updateEnrollmentsStudent==2){
        return ResponseEntity.status(400).body(new ApiResponse("Id not Found"));
    }

    return ResponseEntity.status(200).body(new ApiResponse("Student enrolled successfully"));
}

@GetMapping("/getbyenrollments/{courseId}")
public ResponseEntity<?>getEnrollmentsByCourseId(@PathVariable String courseId){
    ArrayList<Enrollment>getEnrollmentsByCourseId=enrollmentService.getEnrollmentsByCourseId(courseId);
    if(getEnrollmentsByCourseId.isEmpty()){
        return ResponseEntity.status(400).body(new ApiResponse("no Enrollments"));
    }
    return ResponseEntity.status(200).body(getEnrollmentsByCourseId);
}







































}
