package com.database;

import javax.persistence.*;

@Table(name = "knowledgeArea")
@Entity(name="KnowledgeArea")

public class KnowledgeArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)                  // A unique identification number in the database.
    private int knowledgeAreaId;

    public KnowledgeArea() {
    }

    public int getKnowledgeAreaId() {
        return knowledgeAreaId;
    }

    public void setKnowledgeAreaId(int knowledgeAreaId) {
        this.knowledgeAreaId = knowledgeAreaId;
    }
}
