package com.dags.displayinguserfeeback.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Feedback {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "date_created")
    @Type(type = "date")
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private Date dateCreated;

    @Column
    private String username;

    @Column
    private String response;

    @PrePersist
    protected void onCreate(){
        this.dateCreated = new Date();
    }

}
