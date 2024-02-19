package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.UserRepository;
import com.hcc.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping
    public ResponseEntity<?> getAssignmentsByUser(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(assignmentService.findByUser(user));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAssignmentById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(assignmentService.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> putAssignmentsById(@PathVariable Long id, @RequestBody Assignment assignment, @AuthenticationPrincipal User user) {
        Optional<Assignment> oldAssignment = assignmentService.findById(id);
        if (oldAssignment.isEmpty())
            return ResponseEntity.ok("Assignment not found");
        Assignment toUpdate = oldAssignment.get();
        if (assignment.getStatus() != null) {
            toUpdate.setStatus(assignment.getStatus());
        }
        if (assignment.getNumber() != null) {
            toUpdate.setNumber(assignment.getNumber());
        }
        if (assignment.getBranch() != null) {
            toUpdate.setBranch(assignment.getBranch());
        }
        if (assignment.getReviewVideoUrl() != null) {
            toUpdate.setReviewVideoUrl(assignment.getReviewVideoUrl());
        }
        if (assignment.getUser() != null) {
            toUpdate.setUser(assignment.getUser());
        }
        if (assignment.getCodeReviewer() != null) {
            toUpdate.setCodeReviewer(assignment.getCodeReviewer());
        }
        assignmentService.saveAssignment(toUpdate);
        return ResponseEntity.ok("Assignment successfully updated");
    }

    @PostMapping
    public ResponseEntity<?> postAssignmentById(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(assignmentService.save(user));
    }
}
