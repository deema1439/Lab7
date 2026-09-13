package com.example.lab7.Controller;

import com.example.lab7.Api.ApiResponse;
import com.example.lab7.Model.Course;
import com.example.lab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

   private final CourseService courseService;

   @GetMapping("/get")
   public ResponseEntity<?>getCourses(){
       ArrayList<Course>getCourses=courseService.getCourses();
       return ResponseEntity.status(200).body(getCourses);
   }


   @PostMapping("/add")
   public ResponseEntity<?>addCourse(@Valid @RequestBody Course course, Errors errors){
       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       courseService.addCourse(course);
       return ResponseEntity.status(200).body(new ApiResponse("Course has been added"));
   }

   @PutMapping("/update/{id}")
   public ResponseEntity<?>updateCourse(@PathVariable String id,@RequestBody @Valid Course course,Errors errors){
       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       boolean updateCourse=courseService.updateCourse(id,course);
       if(!updateCourse){
           return ResponseEntity.status(400).body(new ApiResponse("Id not Found"));
       }
       return ResponseEntity.status(200).body(new ApiResponse("Course has been Updated"));
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?>deleteCourse(@PathVariable String id){
       boolean deleteCourse=courseService.deleteCourse(id);
       if(!deleteCourse){
           return ResponseEntity.status(400).body(new ApiResponse("id Not Found"));
       }
       return ResponseEntity.status(200).body(new ApiResponse("Course has been deleted"));
   }

   @GetMapping("/coursebycatogry/{category}")
   public ResponseEntity<?> getCategory(@PathVariable String category){
       ArrayList<Course> getCategory=courseService.getCategory(category);
       if(getCategory.isEmpty()){
           return ResponseEntity.status(400).body(new ApiResponse("there is no Category"));
       }
       return ResponseEntity.status(200).body(getCategory);
   }

   @PutMapping("/setpublish/{id}")
   public ResponseEntity<?>updatePublished(@PathVariable String id){
       int updatePublished=courseService.updatePublished(id);
       if(updatePublished==1){
           return ResponseEntity.status(400).body(new ApiResponse("Course already published"));
       }
       if(updatePublished==3){
           return ResponseEntity.status(400).body(new ApiResponse("Id course Not found"));
       }
       return ResponseEntity.status(200).body(new ApiResponse("Course set publish"));
   }

   @GetMapping("/getlevel/{level}")
   public ResponseEntity<?>getLevel(@PathVariable String level){
       ArrayList<Course>getLevel=courseService.getLevel(level);
       if(getLevel.isEmpty()){
           return ResponseEntity.status(400).body(new ApiResponse("Level not found"));
       }
       return ResponseEntity.status(200).body(getLevel);
   }

   @GetMapping("/gettaxprice/{category}")
   public ResponseEntity<?>getPriceWithTax(@PathVariable String category){
       ArrayList<Double> getPriceWithTax=courseService.getPriceWithTax(category);
       if(getPriceWithTax.isEmpty()){
           return ResponseEntity.status(400).body(new ApiResponse("no prices"));
       }
       return ResponseEntity.status(200).body(getPriceWithTax);
   }











































}
