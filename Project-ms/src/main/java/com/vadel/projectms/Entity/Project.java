package com.vadel.projectms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vadel.projectms.Model.Supervisor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Long supervisorId;

    @Transient
    @JsonIgnore
    private Supervisor supervisor;
}
