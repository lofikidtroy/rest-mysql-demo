package com.troy.rest_mysql_demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerDTO {

    private Long id;

    @NotNull
    private Integer ban;

    @NotNull
    @Size(max = 255)
    private String customerName;

    @NotNull
    private CustomerStatus customerStanding;

    @NotNull
    private Integer activeLines;

    @NotNull
    private Double remainingBalance;

}
