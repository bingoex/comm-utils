package com.bingo.comm.util;

import java.io.UnsupportedEncodingException;

public class ByteUtil {

    public static final String CHARACTER_NAME = "iso-8859-1";

    public static byte[] int2Bytes(int num) {
        byte[] byteNum = new byte[4];
        for (int ix = 0; ix < 4; ++ix) {
            int offset = 32 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }

    public static int bytes2Int(byte[] byteNum) {
        int num = 0;
        for (int ix = 0; ix < 4; ++ix) {
            num <<= 8;
            num |= (byteNum[ix] & 0xff);
        }
        return num;
    }

    public static byte[] long2Bytes(long num) {
        byte[] byteNum = new byte[8];
        for (int ix = 0; ix < 8; ++ix) {
            int offset = 64 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }

    public static long bytes2Long(byte[] byteNum) {
        long num = 0;
        for (int ix = 0; ix < 8; ++ix) {
            num <<= 8;
            num |= (byteNum[ix] & 0xff);
        }
        return num;
    }

    public static String bytes2String(byte[] bytes) throws RuntimeException {
        try {
            return new String(bytes, CHARACTER_NAME);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的编码", e);
        }
    }

    public static byte[] string2Bytes(String s) throws RuntimeException {
        try {
            return s.getBytes(CHARACTER_NAME);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("不支持的编码", e);
        }
    }

}
