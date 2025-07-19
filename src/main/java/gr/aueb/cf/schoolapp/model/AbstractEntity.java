// Package declaration
package gr.aueb.cf.schoolapp.model;

// Import JPA and Lombok annotations, and Java time classes
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// Indicates this class is a JPA base class for other entities
@MappedSuperclass
// Lombok: generates getter methods for all fields
@Getter
// Lombok: generates setter methods for all fields
@Setter
// Lombok: generates a no-argument constructor
@NoArgsConstructor
// Lombok: generates a constructor with all arguments
@AllArgsConstructor
// Registers the auditing listener for automatic timestamp management
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {

    // Automatically sets creation timestamp when the entity is persisted
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Automatically updates timestamp when the entity is modified
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}