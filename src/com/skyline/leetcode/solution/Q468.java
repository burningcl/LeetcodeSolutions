package com.skyline.leetcode.solution;

import java.util.LinkedList;

/**
 * Validate IP Address
 * https://leetcode.com/problems/validate-ip-address/
 * Created by chenliang on 2017/2/6.
 */
public class Q468 {

    public static final String NEITHER = "Neither";

    public String validIPV4(String IP) {
        if (IP.startsWith(".") || IP.endsWith(".")) {
            return NEITHER;
        }
        String[] ips = IP.split("\\.");
        if (ips == null || ips.length != 4) {
            return NEITHER;
        }
        for (String ip : ips) {
            try {
                int val = Integer.valueOf(ip);
                if ((val == 0 && ip.length() > 1) || (val > 0 && ip.startsWith("0")) || ip.startsWith("-")) {
                    return NEITHER;
                }
                if (val < 0 || val > 255) {
                    return NEITHER;
                }
            } catch (Exception e) {
                return NEITHER;
            }
        }
        return "IPv4";
    }

    public static final int FFFF = Integer.valueOf("FFFF", 16);

    public String validIPV6(String IP) {
        if (IP.startsWith(":") || IP.endsWith(":")) {
            return NEITHER;
        }
        String[] ips = IP.split(":");
        if (ips == null || ips.length != 8) {
            return NEITHER;
        }
        for (String ip : ips) {
            if (ip.length() <= 0 || ip.length() > 4 || ip.startsWith("-")) {
                return NEITHER;
            }
            try {
                int val = Integer.valueOf(ip, 16);
                if (val < 0 || val > FFFF) {
                    return NEITHER;
                }
            } catch (Exception e) {
                return NEITHER;
            }
        }
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() <= 0) {
            return NEITHER;
        } else if (IP.contains(".")) {
            return validIPV4(IP);
        } else {
            return validIPV6(IP);
        }
    }
}
