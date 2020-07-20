package com.etauker.spider.model;

import com.etauker.spider.service.ByteConversionService;

public class HeapMemoryMetrics {

    private final long initial;
    private final long used;
    private final long max;
    private final long committed;

    public HeapMemoryMetrics(long initial, long used, long max, long committed) {
        this.initial = initial;
        this.used = used;
        this.max = max;
        this.committed = committed;
    }

    public long getInitialBytes() {
        return initial;
    }
    public double getInitialGigabytes() {
        return ByteConversionService.bytesToGigabytes(this.getInitialBytes());
    }
    public long getUsedBytes() {
        return used;
    }
    public double getUsedGigabytes() {
        return ByteConversionService.bytesToGigabytes(this.getUsedBytes());
    }
    public long getMaxBytes() {
        return max;
    }
    public double getMaxGigabytes() {
        return ByteConversionService.bytesToGigabytes(this.getMaxBytes());
    }
    public long getCommittedBytes() {
        return committed;
    }
    public double getCommittedGigabytes() {
        return ByteConversionService.bytesToGigabytes(this.getCommittedBytes());
    }

    public String toReadableString() {
        String format = "heap_memory={initial='%.2fGB', used='%.2fGB', max='%.2fGB', committed='%.2fGB'}";

        String output = String.format(
            format,
            this.getInitialGigabytes(),
            this.getUsedGigabytes(),
            this.getMaxGigabytes(),
            this.getCommittedGigabytes()
        );
        return output;
    }
}
