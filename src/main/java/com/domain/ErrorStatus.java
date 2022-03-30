package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorStatus extends TypeStatus{

    private String exceptionType;

    private String httpStatusCode;

    private String httpStatus;

    private String relativeUri;

    private String message;
}
