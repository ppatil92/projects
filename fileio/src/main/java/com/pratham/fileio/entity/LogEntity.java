package com.pratham.fileio.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class LogEntity {

    private String id;
    private String state;
    private long timestamp;
    private String type;
    private String host;
}
