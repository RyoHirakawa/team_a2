package com.example.sample.util;

import java.util.Comparator;

import com.example.sample.model.SchoolClass;

public class SchoolClassComparator implements Comparator<SchoolClass> {

    @Override
    public int compare(SchoolClass sc1, SchoolClass sc2) {
        // 学年で比較
        int gradeComparison = Integer.compare(sc1.getGrade().toInteger(), sc2.getGrade().toInteger());
        if (gradeComparison != 0) {
            return gradeComparison;
        }
        
        // 学年が同じ場合はクラス名で比較
        return sc1.getName().compareTo(sc2.getName());
    }
}
