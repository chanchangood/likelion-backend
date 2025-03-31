package com.inspire12.likelionbackend.module.mvc.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderRequest {
    private Long storeId;
    private Long productId;
}
