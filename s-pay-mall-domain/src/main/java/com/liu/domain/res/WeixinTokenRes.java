package com.liu.domain.res;


import lombok.Getter;

@Getter
public class WeixinTokenRes {
    private String access_token;
    private int expires_in;
    private String errcode;
    private String errmsg;
}
