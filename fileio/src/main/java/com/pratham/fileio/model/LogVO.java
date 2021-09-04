package com.pratham.fileio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class LogVO {

    private String id;
    private String state;
    private long timestamp;
    private String type;
    private String host;
}
