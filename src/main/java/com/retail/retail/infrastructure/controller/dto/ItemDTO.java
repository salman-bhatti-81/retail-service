package com.retail.retail.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemDTO {
    private String upcCode;
    private int price;
}
