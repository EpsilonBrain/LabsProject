package com.hcc.dto;

import com.hcc.entities.Assignment;
import com.hcc.enums.AssignmentEnum;
import com.hcc.enums.AssignmentStatusEnum;

public class AssignmentResponseDTO {
    private Assignment assignment;
    private AssignmentEnum[] assignments = AssignmentEnum.values();
    private AssignmentStatusEnum[] statusEnums = AssignmentStatusEnum.values();

    public AssignmentResponseDTO(Assignment assignment) {
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public AssignmentEnum[] getAssignments() {
        return assignments;
    }

    public AssignmentStatusEnum[] getStatusEnums() {
        return statusEnums;
    }
}
