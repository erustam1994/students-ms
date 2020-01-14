package com.students.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student")
@EntityListeners(AuditListener.class)
@SQLDelete(sql ="UPDATE student SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class StudentEntity implements Auditable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence-generator"
    )
    @SequenceGenerator(
            name = "sequence-generator",
            sequenceName = "student_sequence",
            initialValue = 16
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "deleted")
    private Boolean deleted;

    @Embedded
    private Audit audit;

    @ManyToMany
    private List<UniversityEntity> universities = new ArrayList<>();

    @PrePersist
    public void prePersist(){
        deleted=false;
    }
}
