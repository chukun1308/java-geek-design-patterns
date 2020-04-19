package com.chukun.designer.pattern.create.builder;

/**
 * @author 初坤
 * 普通对象生成
 *
 * 缺点:
 *    现在，ResourcePoolConfig 只有 4 个可配置项，对应到构造函数中，也只有 4 个参数，参数的个数不多。
 *    但是，如果可配置项逐渐增多，变成了 8 个、10 个，甚至更多，那继续沿用现在的设计思路，
 *    构造函数的参数列表会变得很长，代码在可读性和易用性上都会变差。
 *    在使用构造函数的时候，就容易搞错各参数的顺序，传递进错误的参数值，导致非常隐蔽的 bug。
 */
public class ResourcePoolConfigV1 {
    private String name;
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfigV1(String name,Integer maxTotal,Integer maxIdle,Integer minIdle) {
        if (null == name || "".equals(name)) {
            throw new IllegalArgumentException("name must not be empty");
        }
        this.name = name;
        if (maxTotal != null) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("maxTotal should be positive");
            }
            this.maxTotal = maxTotal;
        }

        if (maxIdle != null) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should be positive");
            }
            this.maxIdle = maxIdle;
        }

        if (minIdle != null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should be positive");
            }
            this.minIdle = minIdle;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public static void main(String[] args) {

      // 参数太多，导致可读性差、参数可能传递错误
      ResourcePoolConfigV1 config = new ResourcePoolConfigV1("dbConnectionPool", 16, 30, 8);
    }
}
