// Package declaration
package gr.aueb.cf.schoolapp.repository;

// Import statements for required classes and annotations
import gr.aueb.cf.schoolapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Marks this interface as a Spring Data repository
@Repository
public interface TeacherRepository
        // Extends JpaRepository for CRUD operations and JpaSpecificationExecutor for dynamic queries
        extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher> {

    // Finds all teachers by region ID
    List<Teacher> findByRegionId(Long id);

    // Finds a teacher by their UUID
    Optional<Teacher> findByUuid(String uuid);

    // Finds a teacher by their VAT number
    Optional<Teacher> findByVat(String vat);

    // Custom JPQL query to count teachers by UUID
    @Query("SELECT COUNT(*) FROM Teacher t WHERE t.UUID = ?1")
    long getCount(String uuid);
}