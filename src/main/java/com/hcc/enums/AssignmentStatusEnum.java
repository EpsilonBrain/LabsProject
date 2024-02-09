
package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentStatusEnum {
    ASSIGNMENT_STATUS_ENUM1(1, "Completed"),
    ASSIGNMENT_STATUS_ENUM2(2, "In Progress"),
    ASSIGNMENT_STATUS_ENUM3(3, "In Review");

    private int assignmentStatusNum;
    private String assignmentStatus;

    AssignmentStatusEnum(int assignmentStatusNum, String assignmentStatus) {
        this.assignmentStatusNum = assignmentStatusNum;
        this.assignmentStatus = assignmentStatus;
    }

    public int getAssignmentNum() {
        return assignmentStatusNum;
    }

    public String getAssignmentTitle() {
        return assignmentStatus;
    }
}
