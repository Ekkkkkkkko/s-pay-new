package com.liu.domain.res;

import com.liu.common.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ekko
 * @description
 * @create 2026/1/30 12:30
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayOrderRes {
    private String userId;
    private String orderId;
    private String payUrl;
    private Constants.OrderStatusEnum orderStatusEnum;
}
