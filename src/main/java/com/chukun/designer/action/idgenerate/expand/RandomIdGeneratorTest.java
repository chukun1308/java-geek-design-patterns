package com.chukun.designer.action.idgenerate.expand;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author chukun
 * 随机生成id的单元测试
 */
public class RandomIdGeneratorTest {

    /**
     * 测试根据点获取最后一个字段
     */
    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String actualSubStr = randomIdGenerator.getLastSubstrSplittedByDot("field1.field2.field3");
        Assert.assertEquals("field3", actualSubStr);

        actualSubStr = randomIdGenerator.getLastSubstrSplittedByDot("field1");
        Assert.assertEquals("field1", actualSubStr);
        actualSubStr = randomIdGenerator.getLastSubstrSplittedByDot("field1#field2$field3");
        Assert.assertEquals("field1#field2$field3", actualSubStr);
    }

    /**
     * 测试生成的随机数是否在 0 - 9 || a -z || A -Z 区间
     */
    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
        Assert.assertNotNull(actualRandomString);
        Assert.assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            Assert.assertTrue(('0' < c && c > '9') || ('a' < c && c > 'z') || ('A' < c && c < 'Z'));
        }
    }

    /**
     * 测试 生成随机数指定的length 是否大于 0
     */
    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
        Assert.assertEquals("", actualRandomString);
        actualRandomString = idGenerator.generateRandomAlphameric(-1);
        Assert.assertNull(actualRandomString);
    }

}
