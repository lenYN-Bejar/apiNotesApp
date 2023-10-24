package com.APINotes.apiNotesApp.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String title;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_creacion;

//    Constructor
    public Notes() {
        this.fecha_creacion = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFechaCreacion() {
        return fecha_creacion;
    }

    public void setFechaCreacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
