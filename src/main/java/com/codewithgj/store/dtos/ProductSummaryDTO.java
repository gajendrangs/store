package com.codewithgj.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ProductSummaryDTO {
    Long id;
    String name;
}
