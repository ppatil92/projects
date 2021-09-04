package com.pratham.fileio.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@Entity
@Table(name = "log")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long logid;

    @Column(name = "id")
    private String id;

    @Column(name = "duration")
    private long duration;

    @Column(name = "type")
    private String type;

    @Column(name = "host")
    private String host;

    @Column(name = "alert")
    private boolean alert;

}
