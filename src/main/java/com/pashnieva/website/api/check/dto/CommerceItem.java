package com.pashnieva.website.api.check.dto;

import com.pashnieva.website.api.item.dto.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommerceItem {

    private Long id;
    private Item item;
    private Integer count;
    private BigDecimal price;
    private Check check;
}
