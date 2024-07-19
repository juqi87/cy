package com.mzb.cy.common;

import java.util.HashMap;

public class CyConstant {

    //商户号  测试商户号：S9990188  //生产： S8889296
//    public static final String partnerId = "S8889296";
//    //key
//    public static final String key = "123456";
//    public static final String AuthToken = "123456";
//    public static final String recharge_url = "https://test-m-stg3.ppppoints.com/partner-gateway/points/recharge/mu/placeOrder";
//    public static final String query_url = "https://test-m-stg3.ppppoints.com/partner-gateway/points/recharge/mu/orderQuery";
//    public static final String url = "https://m.changyoyo.com/partner-gateway/points/output/mu/placeOrder";

    //生产
    public static final String partnerId = "S8889296";
    //key
    public static final String key = "qRicGbEvuQGKovcPnPO8kvbDoN6vstuo";
    public static final String AuthToken = "1DA7D2BFE5CCCD7ED45B57CF42C68F88";
    public static final String recharge_url = "https://m.changyoyo.com/partner-gateway/points/recharge/mu/placeOrder";
    public static final String query_url = "https://m.changyoyo.com/partner-gateway/points/recharge/mu/orderQuery";


    public static final String notifyUrl = "http://106.15.59.211/cyRechargeNotify";//"https://open.jf.10086.cn/open/bind/bindForm";//"http://106.15.59.211/cyRechargeNotify";

    public static final String ip_add = "106.15.59.211";

//    public static final String user = "mzb";
//    public static final String pwd = "mzb20240708";

    public static final HashMap<String, String> users = new HashMap<String, String>() {{
        put("mzb", "mzb20240708");
        put("17702108984", "Aa11223@");
    }};

    public static final String[] whiteIPs = new String[]{"127.0.0.1", "0:0:0:0:0:0:0:1",
                                                            "106.15.59.211", "112.64.63.231",
            "106.115.45.71", "27.128.80.186", "106.119.53.138"
    };

}

