package com.dscexpen.tools;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PdfItemPool {
    private static PdfItemPool instance;
    private Lock lockCells = new ReentrantLock();

    public static PdfItemPool getInstance() {
        if (null == instance) {
            instance = new PdfItemPool();
        }
        return instance;
    }

    // 从对象池中获取新的对象
    public String createCell() {
        String it = "";
        lockCells.lock();
        try {
            if (it != null) {
                System.out.println("对象所测试");
            }

        } finally {
            lockCells.unlock();
        }


        return it;
    }


}
