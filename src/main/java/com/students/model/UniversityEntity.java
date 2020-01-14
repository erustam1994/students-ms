package com.students.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "university")
@EntityListeners(AuditListener.class)
@SQLDelete(sql = "UPDATE university SET deleted=true WHERE id=?")
@Where(clause = "deleted=false")
public class UniversityEntity implements Auditable {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "university_sequence")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "deleted")
    private Boolean deleted;
    @Embedded
    private Audit audit;
    @ManyToMany(mappedBy = "universities")
    private List<StudentEntity> students = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        deleted = false;
    }
}
