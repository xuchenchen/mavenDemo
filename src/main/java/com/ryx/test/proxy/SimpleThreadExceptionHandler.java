package com.ryx.test.proxy;

public class SimpleThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
//        System.err.printf("%s: %s at line %d of %s%n",
//                t.getName(),
//                e.toString(),
//                e.getStackTrace()[0].getLineNumber(),
//                e.getStackTrace()[0].getFileName());
        System.out.println("我抓住了异常");
    }
}
