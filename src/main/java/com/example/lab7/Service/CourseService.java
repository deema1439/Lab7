package com.example.lab7.Service;

import com.example.lab7.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    ArrayList<Course> courses=new ArrayList<>();


    public ArrayList<Course>getCourses(){
        return courses;
    }


    public void addCourse(Course course){
        course.setPublished(false);
        courses.add(course);
    }


    public boolean updateCourse(String id,Course course){
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getId().equals(id)){
                courses.set(i,course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String id){
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getId().equals(id)){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Course> getCategory(String category){
        ArrayList<Course>result=new ArrayList<>();
        for(Course c:courses){
            if(c.getCategory().equalsIgnoreCase(category)){
                result.add(c);
            }
        }
        return result;
    }

    public int updatePublished(String id){
        for(Course c:courses){
            if(c.getId().equals(id)){
                if(c.isPublished()){
                    return 1;
                }
                   c.setPublished(true);
                    return 2;
            }
        }
        return 3;
    }

    public ArrayList<Course>getLevel(String level){
        ArrayList<Course>results=new ArrayList<>();
        for(Course c:courses){
            if(c.getLevel().equalsIgnoreCase(level)){
                results.add(c);
            }
        }
        return results;
    }

// كل كورسات البرمجه مثلا مع الضريبه
    public ArrayList<Double> getPriceWithTax(String category){
        ArrayList<Double>result=new ArrayList<>();
        for(Course c:courses){
            if(c.getCategory().equalsIgnoreCase(category)){
               result.add(c.getPrice()*1.15);
            }
        }
        return result;
    }

































}
