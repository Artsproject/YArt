package com.qfedu.common.util;


import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.Key;

/**
 * 基于shiro实现加解密
 */


public class ShiroEncryUtil {

    private static final String slat = "123456";

    //MD5摘要
    public static String md5(String pass) {
      SimpleHash simpleHash = new SimpleHash("MD5",pass,slat,128);

      return simpleHash.toString();
    }
    //Bas64编码
    public static String Tobase64(byte[] data) {
        return Base64.encodeToString(data);
    }
    //Base64解码
    public static String baseto64(String data) {
        return Base64.decodeToString(data.getBytes());
    }

    //aes秘钥
    public static Key createKey() {
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(256);
        return aesCipherService.generateNewKey();
    }

    //aes 加密
    public static String aesEncode(Key key, String data) {
        AesCipherService aesCipherService = new AesCipherService();
        return aesCipherService.encrypt(data.getBytes(), key.getEncoded()).toBase64();
    }

    //aes解密
    public static String aesDecode(Key key, String data) {
        AesCipherService aesCipherService = new AesCipherService();
        return new String(aesCipherService.decrypt(Base64.decode(data),key.getEncoded()).getBytes());
    }



}
