package cn.jshop.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 郭旭辉 on 2016/3/16.
 */
public class MD5Utils {
    public static final String SALT = "eatammy";

    //全局数组
    private final static String[] strDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public MD5Utils() {
    }

    /**
     * 返回的加密字符串（字符串与数字组合）
     *
     * @param bByte 待转化的加密字节
     * @return 返回，的加密字符串
     */
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    /**
     * 返回加密的字符串（数字）
     *
     * @param bytes 待转化的加密字节
     * @return 返回，的加密字符串
     */
    private String byte2Num(byte bytes) {
        return String.valueOf(bytes < 0 ? (bytes + 256) : bytes);
    }

    /**
     * 转化字节数组为16进制字符串
     *
     * @param bByte 待转化的字节数组
     * @return 返回，的加密字符串
     */
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String getMD5(String str) {
        String result = null;
        try {
            result = new String(str);
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = byteToString(md.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return result.toUpperCase();
    }

    //获取token
    public static String getToken(String username, String password) {
        return getMD5(SALT+getMD5(username)+getMD5(password)+System.currentTimeMillis());
    }

    public static void main(String[] args){
        System.out.println(getMD5("123123simagle"));
//        System.out.println(getToken("simagle","123123"));
    }

}
