package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentEnum {
    ASSIGNMENT1(1, "Object Oriented Programming"),
    ASSIGNMENT2(2, "Python"),
    ASSIGNMENT3(3, "Java"),
    ASSIGNMENT4(4, "Haskell");

    private int assignmentNum;
    private String assignmentTitle;

    AssignmentEnum(int assignmentNum, String assignmentTitle) {
        this.assignmentNum = assignmentNum;
        this.assignmentTitle = assignmentTitle;
    }

    public int getAssignmentNum() {
        return assignmentNum;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }
}
