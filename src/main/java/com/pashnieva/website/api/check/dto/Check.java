package com.pashnieva.website.api.check.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Check {

    private Long id;
    private List<CommerceItem> commerceItems;
    private LocalDate date;
    private BigDecimal fullPrice;
    private BigDecimal discount;
    private BigDecimal totalPrice;

}
