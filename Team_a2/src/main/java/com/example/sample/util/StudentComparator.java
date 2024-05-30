package com.example.sample.util;

import java.util.Comparator;

import com.example.sample.model.Student;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        // 学年で比較
        int gradeComparison = Integer.compare(s1.getGrade().toInteger(), s2.getGrade().toInteger());
        if (gradeComparison != 0) {
            return gradeComparison;
        }

        // クラス名で比較
        int classNameComparison = s1.getSchoolClass().getName().compareTo(s2.getSchoolClass().getName());
        if (classNameComparison != 0) {
            return classNameComparison;
        }

        // 性別で比較
        int genderComparison = s1.getGender().compareTo(s2.getGender());
        if (genderComparison != 0) {
            return genderComparison;
        }

        // 名前で比較（姓、名の順）
        int lastNameComparison = s1.getLastName().compareTo(s2.getLastName());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        
        return s1.getFirstName().compareTo(s2.getFirstName());
    }
}
