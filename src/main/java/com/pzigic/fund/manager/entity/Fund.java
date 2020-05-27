package com.pzigic.fund.manager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
public class Fund {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fund_id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name="investor_id", nullable=false)
    private Investor investor;

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
