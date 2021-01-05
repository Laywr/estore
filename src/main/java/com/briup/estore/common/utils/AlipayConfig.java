package com.briup.estore.common.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class AlipayConfig {
	//支付宝网关，固定（沙箱测试网关）。    
		public static String serverUrl = 
				"https://openapi.alipaydev.com/gateway.do";    
		//沙箱应用APPID,将来替换成实际应用appid    
		public static String APP_ID = "2016102700769674";     
		//生成的私钥    
		public static String APP_PRIVATE_KEY = 
			"MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDRxUBoF/eCWGJLG+TtfsA1qgd7kAU10qACJaLFOiUbYT6OGv5beNYGyj4TR4q9/CSLMiTabr5XJWRDE56oBg1RYg3mX6fgXWd/Y9j90b0PZd/wtXDl6bIZYlKKdJu3mhADVVLPcrfjy8YrJfepVgj8Q11MBJE29pN+hHqM/NsyV+tYOOArdgmuggMRY2nutlX3/sr8tcAyoRPgKZOesZ3cAYUxpKHZ7mVzPAJKQPX3AVAETq2BScyVN7ZgyrL3Ov/BTpfp2IBP7zmakQofwV9DykyzHax5qJGFHX9DTkAVASXbqdgiwS/g4lxqVaQR1qCVBcrfeOerX/Ci7r5v73clAgMBAAECggEBALkLW+l3WusstGi1TpkCeuPb/YXOYgo8ptG+CXwZ8qnYeqo4vbBLQ+Hxfhjbv1QgnMv9i+z0TAvr/Cn/oLFvxUfJS6GxOBH/01DY743X+wMeRxG7vL/UCzvBNDbW7pZj3URTfB1rgTP9ie5+K57BOmPtuNtaHA90LGAq1UCRvXsF4rdCLQJNRwgCrhv9t5B7R0L4JEb+J6uTwBxcOn8mDCHYEwbFFZwKQPnQlTaSC4s/jj85R3mO2YMj7UQ0ACRj5Z9kCOKZESNvIN7wPjvqnla6glJzs2VBCpI3LENH0JGhOWJCt8S1M/C1FyTLM/fidAr6sEYnKfBZq1ifyV/NAfECgYEA7AXoEzyANV1r78jGHUxHu9C94syOEbsXZrG2p8gBZ6N9U4FwnKCIS6CBwKlmL/Q2J+c/asBg/gqEXEa/7GxVOlgDY7yVxaUvOpdwpGDXJEbGfUBG3cCitI5iFeCFYuoMNzkIt95cZQrk3ChwdZMjDH2o3lnhV+pCCSMzASF1WKsCgYEA44aCuypkwePT0iSEWCNQXi+v994Ze2BNK/MuXGMcffUMWM2EXO6U24ufUd/hFmcRijYSZtJPgiyNRKIs5/txcZSuqKSihR6f4cJz9dG40e3U2YFNIxntMLZSRshHA33O7OJOQfD7GTSkSIsAnXNazaacO2RrOf3/KBYrkWGUD28CgYEA1mlHOrJrhg8oTtyFnXf+cpBe7/oD1feweopW9HStUgkjgQjF1IPBTXKybON3AXlI+VcKNWAuvJmxRGLBV3XStv3dlm1rYfF9xixtF+chisMA7ifGOQ0Wwg/W6yjcA8+66S/Wy7IlHWWYIqhaAXV5EY/WKKheHg+hjct8Ojq676ECgYA0qK0ZJHataU1dFZaLz6CKK/9OHtlG9MLnqSDRwR6XCGATLX21BILvTSFSkb5GsRQeKOWZZpOATU9k0yQRjOB0qTTDU1dJ+AyI87hi7GcaLzFUJdj0hsueupPQTgohhLyflsEGAgAblVNwdrtttYUOk8EU/ejTQzYK0RbETxE1gQKBgQCOAS8h2qbU89kgoVGHS03pFQAkyWDYyfjA5GQfMiuKpxcjrEzYtNOppwMW9uJuem8bIp916cIjJaMtbyod7gE9gfn/suLqGjOk8TiajGF6isoLk+qNhebBP/hw7juDcmRjVHPGlaWWJOIyfuhwqUDnctccUqjSBj2zUP37QnkWAw==";//生成的 私钥
		//请求和签名使用的字符编码格式    
		public static String CHARSET = "UTF-8";    
		//生成的公钥
		public static String ALIPAY_PUBLIC_KEY = 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiO4KT6AMGFAy35IV/R3z03EEyWC/NvXfmTHmgATPmZXqX5l5MngCdudajZDf8aY7p0PYgvWUZ6VNmy0zZyy709lME9+8+ak+DSXspGniF1D/cUSBwvORAuPbrDDpMC6xHxpqx5GmDSAy6QtDp4Ub1DmCBcEPp0F36nB4eAiUQnBg2ibhVG8ELLy+PXWS43mlQFuBaj9HmOj+S4C6zS1LU4juJivIEJ1CPyOHjMwZQQGF4+cfBQ53vpe6a7WteWloj/RuEQIbCgStLo78L24RAhQq61UwjPnrFguXFeRKY0Bec6nH58y+mm4fHqT/Hqayr7641+H5LjxB49SN7EYXzwIDAQAB"; 
		 //商户生成签名字符串所使用的签名算法类型  
		public static String SIGN_TYPE = "RSA2";        
		public static AlipayClient alipayClient;    
		synchronized public static AlipayClient getAlipayClient() {
			if(alipayClient==null) {            
				alipayClient = new DefaultAlipayClient(
						serverUrl, APP_ID, APP_PRIVATE_KEY, 
						"json", CHARSET, ALIPAY_PUBLIC_KEY, 
						SIGN_TYPE);
			}        
			return alipayClient;    
		} 
}
