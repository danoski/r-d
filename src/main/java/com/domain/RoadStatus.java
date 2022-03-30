package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoadStatus extends TypeStatus{

    private String id;

    private String displayName;

    private String group;

    private String statusSeverity;

    private String statusSeverityDescription;

    private String bounds;

    private String envelope;

    private String statusAggregationStartDate;

    private String statusAggregationEndDate;

    private String url;

    private String timestampUtc;
}

