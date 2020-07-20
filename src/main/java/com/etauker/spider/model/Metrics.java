package com.etauker.spider.model;


import java.util.Date;

public class Metrics {
    private static final long BYTES_IN_GIGABYTE = 1073741824;

    private final String osName;
    private final String osFamily;
    private final Date datetime;
    private final DriveSpaceMetrics driveSpaceMetrics;
    private final HeapMemoryMetrics memoryMetrics;

    private Metrics(
        String osName,
        String osFamily,
        Date datetime,
        DriveSpaceMetrics driveSpaceMetrics,
        HeapMemoryMetrics memoryMetrics
    ) {
        this.osName = osName;
        this.osFamily = osFamily;
        this.datetime = datetime;
        this.driveSpaceMetrics = driveSpaceMetrics;
        this.memoryMetrics = memoryMetrics;
    }

    public String getOsName() {
        return this.osName;
    }
    public String getOsFamily() {
        return this.osFamily;
    }
    public Date getDatetime() {
        return this.datetime;
    }
    public HeapMemoryMetrics getHeapMemoryMetrics() {
        return this.memoryMetrics;
    }
    public DriveSpaceMetrics getDriveSpaceMetrics() {
        return this.driveSpaceMetrics;
    }

    public static class Builder extends MetricsBuilder {
        public Metrics build() {
            return new Metrics(
                this.osName,
                this.osFamily,
                this.datetime,
                new DriveSpaceMetrics(
                    this.driveSpaceTotalBytes,
                    this.driveSpaceFreeBytes,
                    this.driveSpaceUsableBytes
                ),
                new HeapMemoryMetrics(
                    this.heapMemoryInitialBytes,
                    this.heapMemoryUsedBytes,
                    this.heapMemoryMaxBytes,
                    this.heapMemoryCommittedBytes
                )
            );
        }
    }

    public String toReadableString() {
        String heapMemoryMessage = this.getHeapMemoryMetrics().toReadableString();
        String driveSpaceMessage = this.getDriveSpaceMetrics().toReadableString();

        return "Metrics {" +
            "datetime=\"" + this.getDatetime().toString() + '\"' +
            ", os_family=\"" + this.getOsFamily() + '\"' +
            ", os_name=\"" + this.getOsName() + '\"' +
            ", " + driveSpaceMessage +
            ", " + heapMemoryMessage +
            "}"
        ;
    }
}
