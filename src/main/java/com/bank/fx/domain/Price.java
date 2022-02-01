package com.bank.fx.domain;

import lombok.Data;

/**
 * @author Oleh Kepsha
 */
@Data
public class Price {
    private Integer id;
    private String instrumentName;
    private Float bid;
    private Float ask;
    private String timestamp;
}
