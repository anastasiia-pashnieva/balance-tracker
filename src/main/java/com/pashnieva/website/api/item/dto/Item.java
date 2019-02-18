package com.pashnieva.website.api.item.dto;

import com.pashnieva.website.api.check.dto.CommerceItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    private Long id;
    private String description;
    private BigDecimal price;
    private List<CommerceItem> commerceItems;
}
