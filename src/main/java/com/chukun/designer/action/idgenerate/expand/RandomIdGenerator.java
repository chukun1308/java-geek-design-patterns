package com.chukun.designer.action.idgenerate.expand;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class RandomIdGenerator implements IdExpandGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomIdGenerator.class);

    /**
     * 生成id
     * @return
     */
    @Override
    public String generate() {
        String lastHostnameField = getLastFieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomAlphameric = generateRandomAlphameric(8);
        String currentId = String.format("%s-%d-%s",lastHostnameField,currentTimeMillis,randomAlphameric);
        return currentId;
    }

    /**
     * 获取hostname 最后一位
     * @return
     */
    @VisibleForTesting
    private String getLastFieldOfHostName() {
        String subStrHostname = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            subStrHostname = getLastSubstrSplittedByDot(hostName);
        }catch (UnknownHostException e) {
            LOGGER.warn("Failed to get the host name.", e);
            subStrHostname = "dev0000001";
        }
        return subStrHostname;
    }

    /**
     * 根据 点分割字符串，获取最后一个
     * @param hostname
     * @return
     */
    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostname) {
        String[] token = hostname.split("\\.");
        String tokenLastField = token[token.length -1];
        return tokenLastField;
    }

    /**
     * 生成随机字符串  0-9 a-z A-Z
     * @param length
     * @return
     */
    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("length must greater than 0");
        }
        char[] randomChars = new char[length];
        int count  = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <='9';
            boolean isUppercase = randomAscii>= 'A' && randomAscii<='Z';
            boolean isLowercase = randomAscii>='a'  && randomAscii<='z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) randomAscii;
                count ++ ;
            }
        }
        return new String(randomChars);
    }
}
