package com.liu.service.impl;

import com.google.common.cache.Cache;
import com.liu.service.ILoginService;
import com.liu.service.weixin.IWeixinApiService;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;


public class ILoginServiceImpl implements ILoginService {
    @Value("${weixin.config.app-id}")
    private String appid;
    @Value("${weixin.config.app-secret")
    private String appsecret;
    @Value("${weixin.config.template_id}")
    private String template_Id;

    @Resource
    private Cache<String,String> weixinAccessToken;
    @Resource
    private IWeixinApiService weixinApiService;
    @Resource
    private Cache<String,String> openidToken;
    @Override
    public String createQrCodeTicket() throws Exception {
        String accessToken = weixinAccessToken.getIfPresent(appid);

        return "";
    }
}