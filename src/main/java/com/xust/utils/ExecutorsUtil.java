package com.xust.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lenovo on 2018/5/30.
 */
public class ExecutorsUtil {
    public static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
}
