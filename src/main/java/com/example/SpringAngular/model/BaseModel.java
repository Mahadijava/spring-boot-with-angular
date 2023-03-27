package com.example.SpringAngular.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public abstract class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String createdBy;

    private Boolean active; // for soft delete, dont delete from database

    @Column (updatable = false) // this column cant be updated
    @CreationTimestamp
    private LocalDateTime timeOfCreation;

    @UpdateTimestamp
    private LocalDateTime timeOfUpdate;
    private String updatedBy;

    @PrePersist
    public void prePersist(){
        this.active = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseModel baseModel = (BaseModel) o;
        return Objects.equals(id, baseModel.id) && Objects.equals(createdBy, baseModel.createdBy) && Objects.equals(active, baseModel.active) && Objects.equals(timeOfCreation, baseModel.timeOfCreation) && Objects.equals(timeOfUpdate, baseModel.timeOfUpdate) && Objects.equals(updatedBy, baseModel.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdBy, active, timeOfCreation, timeOfUpdate, updatedBy);
    }
}
