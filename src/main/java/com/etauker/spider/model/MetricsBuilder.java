package com.etauker.spider.model;

import java.util.Date;

public class MetricsBuilder {

    protected Date datetime = new Date();

    protected String osName = "Unknown";
    protected String osFamily = "UNKNOWN";

    protected long driveSpaceTotalBytes = 0L;
    protected long driveSpaceFreeBytes = 0L;
    protected long driveSpaceUsableBytes = 0L;

    protected long heapMemoryInitialBytes = 0L;
    protected long heapMemoryUsedBytes = 0L;
    protected long heapMemoryMaxBytes = 0L;
    protected long heapMemoryCommittedBytes = 0L;


    public MetricsBuilder datetime(Date datetime) {
        this.datetime = datetime;
        return this;
    }

    public MetricsBuilder os(OS os) {
        this.osName = os.getName();
        this.osFamily = os.getFamily();
        return this;
    }

    public MetricsBuilder driveSpaceMetrics(DriveSpaceMetrics metrics) {
        this.driveSpaceTotalBytes = metrics.getTotalDriveSpaceBytes();
        this.driveSpaceFreeBytes = metrics.getFreeDriveSpaceBytes();
        this.driveSpaceUsableBytes = metrics.getUsableDriveSpaceBytes();
        return this;
    }
    public MetricsBuilder driveSpaceTotalBytes(long bytes) {
        this.driveSpaceTotalBytes = bytes;
        return this;
    }
    public MetricsBuilder driveSpaceFreeBytes(long bytes) {
        this.driveSpaceFreeBytes = bytes;
        return this;
    }
    public MetricsBuilder driveSpaceUsableBytes(long bytes) {
        this.driveSpaceUsableBytes = bytes;
        return this;
    }

    public MetricsBuilder heapMemoryMetrics(HeapMemoryMetrics metrics) {
        this.heapMemoryInitialBytes = metrics.getInitialBytes();
        this.heapMemoryUsedBytes = metrics.getUsedBytes();
        this.heapMemoryMaxBytes = metrics.getMaxBytes();
        this.heapMemoryCommittedBytes = metrics.getCommittedBytes();
        return this;
    }
    public MetricsBuilder heapMemoryInitialBytes(long bytes) {
        this.heapMemoryInitialBytes = bytes;
        return this;
    }
    public MetricsBuilder heapMemoryUsedBytes(long bytes) {
        this.heapMemoryUsedBytes = bytes;
        return this;
    }
    public MetricsBuilder heapMemoryMaxBytes(long bytes) {
        this.heapMemoryMaxBytes = bytes;
        return this;
    }
    public MetricsBuilder heapMemoryCommittedBytes(long bytes) {
        this.heapMemoryCommittedBytes = bytes;
        return this;
    }
}
