package com.liu.domain.req;

import lombok.*;

/**
 * @author Ekko
 * @description
 * @create 2026/1/30 12:29
 */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopCartReq {

    private String userId;

    private String productId;

}
