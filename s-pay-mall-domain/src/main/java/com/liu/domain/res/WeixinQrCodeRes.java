package com.liu.domain.res;


import lombok.Getter;

@Getter
public class WeixinQrCodeRes     {
    private String ticket;
    private long expire_seconds;
    private String url;
}
