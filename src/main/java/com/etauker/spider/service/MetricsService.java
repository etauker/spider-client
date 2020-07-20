package com.etauker.spider.service;

import com.etauker.spider.model.HeapMemoryMetrics;
import com.etauker.spider.model.Metrics;
import com.etauker.spider.model.OS;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.Date;

public class MetricsService {

    public static Metrics getMetrics() {

        String rootPath = "/";
        OS os = MetricsService.getOs();
        if (os.getFamily().equals(OS.FAMILIES.WINDOWS.toString())) {
            rootPath = "C:";
        }


        Metrics.Builder builder = new Metrics.Builder();

        // misc info
        builder.datetime(new Date());
        builder.os(os);

        // disk space
        File rootDrive = new File(rootPath);
        builder.driveSpaceTotalBytes(rootDrive.getTotalSpace());
        builder.driveSpaceFreeBytes(rootDrive.getFreeSpace());
        builder.driveSpaceUsableBytes(rootDrive.getUsableSpace());

        // memory
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        builder.heapMemoryInitialBytes(memoryMXBean.getHeapMemoryUsage().getInit());
        builder.heapMemoryUsedBytes(memoryMXBean.getHeapMemoryUsage().getUsed());
        builder.heapMemoryMaxBytes(memoryMXBean.getHeapMemoryUsage().getMax());
        builder.heapMemoryCommittedBytes(memoryMXBean.getHeapMemoryUsage().getCommitted());

        return builder.build();
    }

    private static OS getOs() {
        String osName = System.getProperty("os.name");
        OS os = new OS(osName, MetricsService.getOsFamily(osName).toString());
        return os;
    }

    private static OS.FAMILIES getOsFamily(String osName) {
        if (osName.contains("Windows")) {
            return OS.FAMILIES.WINDOWS;
        } else if (osName.contains("Mac")) {
            return OS.FAMILIES.MAC;
        } else {
            return OS.FAMILIES.LINUX;
        }
    }

}
