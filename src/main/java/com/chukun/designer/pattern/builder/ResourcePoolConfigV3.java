package com.chukun.designer.pattern.builder;

/**
 * @author chukun
 * <p>
 * 建造者模式:
 * 假设配置项之间有一定的依赖关系，比如，设置了 maxTotal、maxIdle、minIdle 其中一个，就必须显式地设置另外两个；
 * 或者配置项之间有一定的约束条件，比如，maxIdle 和 minIdle 要小于等于 maxTotal。
 * 如果继续使用现在的设计思路，那这些配置项之间的依赖关系或者约束条件的校验逻辑就无处安放了。
 * 如果希望 ResourcePoolConfig 类对象是不可变对象，也就是说，对象在创建好之后，就不能再修改内部的属性值。
 * 要实现这个功能，就不能在 ResourcePoolConfig 类中暴露 set() 方法。
 */
public class ResourcePoolConfigV3 {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfigV3(ResourcePoolConfigBuilder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    /**
     * 建造者类
     */
    private static class ResourcePoolConfigBuilder {
        private String name;
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfigV3 builder() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (name == null || "".equals(name)) {
                throw new IllegalArgumentException("name must not be empty");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("maxIdle must less than maxTotal");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("maxIdle is not valid");
            }
            return new ResourcePoolConfigV3(this);
        }

        public ResourcePoolConfigBuilder setName(String name) {
            if (name == null || "".equals(name)) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }

        public ResourcePoolConfigBuilder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public ResourcePoolConfigBuilder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public ResourcePoolConfigBuilder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

    public static void main(String[] args) {
        // 建造者模式
        ResourcePoolConfigV3 config = new ResourcePoolConfigV3.ResourcePoolConfigBuilder()
                .setName("dbConnectionPool")
                .setMaxIdle(10)
                .setMaxTotal(16)
                .setMinIdle(12)
                .builder();
    }
}
