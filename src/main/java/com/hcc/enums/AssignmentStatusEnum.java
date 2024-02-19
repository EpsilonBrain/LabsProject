
package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentStatusEnum {
    PENDING(1, "Pending"),
    PROGRESS(2, "In Progress"),
    REVIEW(3, "In Review"),
    COMPLETED(4, "Completed");
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
