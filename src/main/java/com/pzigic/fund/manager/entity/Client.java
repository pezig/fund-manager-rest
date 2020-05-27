package com.pzigic.fund.manager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@ToString
public class Client {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    @Setter
    @Getter
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy="client")
    private Set<Investor> investors;

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
