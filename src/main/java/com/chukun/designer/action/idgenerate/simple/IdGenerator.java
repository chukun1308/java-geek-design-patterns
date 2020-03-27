package com.chukun.designer.action.idgenerate.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author chukun
 * 简单的id生成器
 *    hostName 变量不应该被重复使用，尤其当这两次使用时的含义还不同的时候；
 *    将获取 hostName 的代码抽离出来，定义为 getLastfieldOfHostName() 函数；
 *    删除代码中的魔法数，比如，57、90、97、122；
 *    将随机数生成的代码抽离出来，定义为 generateRandomAlphameric() 函数；
 *    generate() 函数中的三个 if 逻辑重复了，且实现过于复杂，我们要对其进行简化；
 *    对 IdGenerator 类重命名，并且抽象出对应的接口
 *
 *  -------------------------------------------------------------------------
 *
 *  generate() 函数定义为静态函数，会影响使用该函数的代码的可测试性；
 *  generate() 函数的代码实现依赖运行环境（本机名）、时间函数、随机函数，所以 generate() 函数本身的可测试性也不好
 *
 */
public class IdGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdGenerator.class);

    /**
     * id 生成算法
     * @return
     */
    public static String generate() {
        String id = "";
        try {
            /**
             * hostName 变量不应该被重复使用，尤其当这两次使用时的含义还不同的时候
             * 将获取 hostName 的代码抽离出来，定义为 getLastfieldOfHostName() 函数
             */
            String hostname = InetAddress.getLocalHost().getHostName();
            String[] token = hostname.split("\\.");
            if (token.length > 4) {
                hostname = token[token.length - 1];
            }
            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();

            /**
             * randomAscii 的范围是 0～122，
             * 但可用数字仅包含三段子区间（0~9，a~z，A~Z），
             * 极端情况下会随机生成很多三段区间之外的无效数字，
             * 需要循环很多次才能生成随机字符串，所以随机字符串的生成算法也可以优化一下。
             */
            while (count < 8) {
                int randomAscii = random.nextInt(123);
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char) ('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char) ('A' + (randomAscii - 65));
                    count++;
                }else if(randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char) ('a' + (randomAscii - 97));
                    count++;
                }
            }
            id = String.format("%s-%d-%s",hostname,System.currentTimeMillis(),new String(randomChars));
        } catch (UnknownHostException e) {
            LOGGER.warn("failed to get the host name", e);
        }

        return id;
    }

    public static void main(String[] args) {

        String id = IdGenerator.generate();
        System.out.println(id);
    }
}
