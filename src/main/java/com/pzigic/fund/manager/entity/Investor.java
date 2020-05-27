package com.pzigic.fund.manager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@ToString
public class Investor {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investor_id;

    @OneToMany(mappedBy="investor")
    private Set<Fund> funds;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    @Setter
    @Getter
    @Column(name = "description")
    private String description;

//    @Getter
//    @Column(name = "created_date")
//    private LocalDateTime createdDate;
//
//    @Getter
//    @Column(name = "update_date")
//    private LocalDateTime updatedDate;
//
//    @PrePersist
//    public void prePersist() {
//        createdDate = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        updatedDate = LocalDateTime.now();
//    }

}
