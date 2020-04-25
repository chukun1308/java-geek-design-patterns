package com.chukun.designer.pattern.behaviour.strategy.expand;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chukun
 * <p>
 * 经过拆分之后，每个类的代码都不会太多，每个类的逻辑都不会太复杂，代码的可读性、可维护性提高了。
 * 除此之外，将排序算法设计成独立的类，跟具体的业务逻辑（代码中的 if-else 那部分逻辑）解耦，也让排序算法能够复用。
 * 这一步实际上就是策略模式的第一步，也就是将策略的定义分离出来。
 * <p>
 * 代码还可以继续优化。每种排序类都是无状态的，没必要在每次使用的时候，
 * 都重新创建一个新的对象。所以，可以使用工厂模式对对象的创建进行封装
 */
public class SorterV2 {

    private static final long GB = 1024 * 1024 * 1024;

    private static final List<AlgRange> algs = new ArrayList<>();

    static {
        algs.add(new AlgRange(0, 6 * GB, SorterFactory.getSort("QuickSort")));
        algs.add(new AlgRange(6 * GB, 10 * GB, SorterFactory.getSort("ExternalSort")));
        algs.add(new AlgRange(10 * GB, 100 * GB, SorterFactory.getSort("ConcurrentExternalSort")));
        algs.add(new AlgRange(100 * GB, Long.MAX_VALUE, SorterFactory.getSort("MapReduceSort")));
    }


    /**
     * 排序
     *
     * @param sortPath
     */
    public void sortFile(String sortPath) {
        File file = new File(sortPath);
        long fileSize = file.length();
        ISorter sorter = null;
        if (fileSize < 6 * GB) {
            sorter = new QuickSort();
        } else if (fileSize < 10 * GB) {
            sorter = new ExternalSort();
        } else if (fileSize < 100 * GB) {
            sorter = new ConcurrentExternalSort();
        } else {
            sorter = new MapReduceSort();
        }
        sorter.sort(sortPath);
    }

    /**
     * 排序
     *
     * @param sortPath
     *    通过策略模式将策略的定义、创建、使用解耦，让每一部分都不至于太复杂。
     *  不过，Sorter 类中的 sortFile() 函数还是有一堆 if-else 逻辑。
     *  这里的 if-else 逻辑分支不多、也不复杂，这样写完全没问题
     */
    public void sortFileV2(String sortPath) {
        File file = new File(sortPath);
        long fileSize = file.length();
        ISorter sorter = null;
        if (fileSize < 6 * GB) {
            sorter = SorterFactory.getSort("QuickSort");
        } else if (fileSize < 10 * GB) {
            sorter = SorterFactory.getSort("ExternalSort");
        } else if (fileSize < 100 * GB) {
            sorter = SorterFactory.getSort("ConcurrentExternalSort");
        } else {
            sorter = SorterFactory.getSort("MapReduceSort");
        }
        sorter.sort(sortPath);
    }

    /**
     * 排序
     * @param sortPath
     *  消除 if - else
     */
    public void sortFileV3(String sortPath) {
        File file = new File(sortPath);
        long fileSize = file.length();
        ISorter sorter = null;
        // 消除 if - else 条件判断
        for (AlgRange alg : algs) {
            if (alg.inRange(fileSize)) {
                sorter = alg.getSorter();
                break;
            }
        }
        sorter.sort(sortPath);
    }

    private static class AlgRange {
        private long start;
        private long end;
        private ISorter sorter;

        public AlgRange(long start, long end, ISorter sorter) {
            this.start = start;
            this.end = end;
            this.sorter = sorter;
        }

        public ISorter getSorter() {
            return sorter;
        }

        public boolean inRange(long size) {
            return size >= start && size < end;
        }
    }
}
