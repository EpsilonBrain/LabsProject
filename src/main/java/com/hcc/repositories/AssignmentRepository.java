package com.hcc.repositories;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Set<Assignment> findByUser(User user);

    @Query("select a from Assignment a " +
            "where (a.status = 'Submitted' and (a.codeReviewer is null or a.codeReviewer = :user)) " +
            "or a.codeReviewer = :user"
    )
    Set<Assignment> findByCodeReviewer(User user);
}