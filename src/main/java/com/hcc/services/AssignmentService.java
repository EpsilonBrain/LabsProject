package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.enums.AssignmentStatusEnum;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;

public class AssignmentService {
    //saveByUser
    @Autowired
    private AssignmentRepository assignmentRepository;
    public Assignment save(User user) {
        Assignment assignment = new Assignment();
        assignment.setUser(user);
        assignment.setStatus(AssignmentStatusEnum.PENDING.getAssignmentTitle());
        assignment.setNumber(findNextAssignmentToSubmit(user));
        return assignmentRepository.save(assignment);
    }
    private Integer findNextAssignmentToSubmit(User user) {
        Set<Assignment> assignmentsByUser = assignmentRepository.findByUser(user);
        if (assignmentsByUser == null)
            return 1;
        Optional<Integer> sortedAssignment = assignmentsByUser.stream()
                .sorted((a1, a2) -> {
                    if (a1.getNumber() == null) return 1;
                    if (a2.getNumber() == null) return 1;
                    return a2.getNumber().compareTo(a1.getNumber());
                }).map(assignment -> {
                    if (assignment.getNumber() == null) return 1;
                    return assignment.getNumber() + 1;
                }).findFirst();
        return sortedAssignment.orElse(1);
    }

    public Optional<Assignment> findById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Set<Assignment> findByUser(User user) {
        return assignmentRepository.findByUser(user);
    }

    public void saveAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }
}
