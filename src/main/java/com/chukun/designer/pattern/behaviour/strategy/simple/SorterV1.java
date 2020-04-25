package com.chukun.designer.pattern.behaviour.strategy.simple;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author chukun
 * 不使用策略模式，编程实现排序相关的问题
 * <p>
 * 需求:
 * 假设有这样一个需求，希望写一个小程序，实现对一个文件进行排序的功能。
 * 文件中只包含整型数，并且，相邻的数字通过逗号来区隔。如何来实现呢？
 * 只需要将文件中的内容读取出来，并且通过逗号分割成一个一个的数字，放到内存数组中，然后编写某种排序算法（比如快排），
 * 或者直接使用编程语言提供的排序函数，对数组进行排序，最后再将数组中的数据写入文件就可以了。但是，如果文件很大呢？
 * 比如有 10GB 大小，因为内存有限（比如只有 8GB 大小），我们没办法一次性加载文件中的所有数据到内存中，
 * 这个时候，就要利用外部排序算法了。如果文件更大，比如有 100GB 大小，我们为了利用 CPU 多核的优势，
 * 可以在外部排序的基础之上进行优化，加入多线程并发排序的功能，这就有点类似“单机版”的 MapReduce。
 * 如果文件非常大，比如有 1TB 大小，即便是单机多线程排序，这也算很慢了。这个时候，可以使用真正的 MapReduce 框架，
 * 利用多机的处理能力，提高排序的效率。
 *
 *
 *  缺点:
 *    每种排序算法实现都很复杂，这样，这个类就会很冗长，不好维护
 *
 */
public class SorterV1 {

    private static final long GB = 1024 * 1024 * 1024;

    /**
     * 排序
     * @param sortPath
     */
    public void sortFile(String sortPath) {
        File file = new File(sortPath);
        long fileSize = file.length();
        if (fileSize < 6 * GB) {
            quickSort(sortPath);
        } else if (fileSize < 10 * GB) {
            externalSort(sortPath);
        } else if (fileSize < 100 * GB) {
            concurrentExternalSort(sortPath);
        } else {
            mapreduceSort(sortPath);
        }
    }

    private void quickSort(String filePath) {
        // 快速排序
    }

    private void externalSort(String filePath) {
        // 外部排序
    }

    private void concurrentExternalSort(String filePath) {
        // 多线程外部排序
    }

    private void mapreduceSort(String filePath) {
        // 利用MapReduce多机排序
    }
}
