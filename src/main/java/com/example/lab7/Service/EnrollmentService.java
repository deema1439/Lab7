package com.example.lab7.Service;

import com.example.lab7.Model.Enrollment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EnrollmentService {

ArrayList<Enrollment>enrollments=new ArrayList<>();

public ArrayList<Enrollment>getEnrollments(){
    return enrollments;
}

public void addEnrollments(Enrollment enrollment){
    enrollment.setEnrolled(false);
    enrollments.add(enrollment);
}

public boolean updateEnrollments(String id,Enrollment enrollment){
    for(int i=0;i<enrollments.size();i++){
        if(enrollments.get(i).getId().equals(id)){
            enrollments.set(i,enrollment);
            return true;
        }
    }
    return false;
}

public boolean delete(String id){
        for(int i=0;i<enrollments.size();i++){
            if(enrollments.get(i).getId().equals(id)){
                enrollments.remove(i);
                return true;
            }
        }
        return false;
    }

    public int updateEnrollmentsStudent(String studentId,String courseId){
    for(Enrollment e:enrollments) {
        if (e.getStudentId().equals(studentId) && e.getCourseId().equals(courseId)) {
            if (e.isEnrolled()) {
                return 0;
            }
            e.setEnrolled(true);
            return 1;
        }
    }
        return 2;

    }

    public ArrayList<Enrollment>getEnrollmentsByCourseId(String courseId){
    ArrayList<Enrollment>result=new ArrayList<>();
    for(Enrollment e:enrollments){
        if(e.getCourseId().equals(courseId)){
            result.add(e);
        }
    }
    return result;
    }


































}
