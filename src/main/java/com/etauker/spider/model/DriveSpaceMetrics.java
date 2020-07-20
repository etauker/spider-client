package com.etauker.spider.model;

public class DriveSpaceMetrics {
    private static final long BYTES_IN_GIGABYTE = 1073741824;

    private final long totalDriveSpaceBytes;
    private final long freeDriveSpaceBytes;
    private final long usableDriveSpaceBytes;

    public DriveSpaceMetrics(
        long totalDriveSpaceBytes,
        long freeDriveSpaceBytes,
        long usableDriveSpaceBytes
    ) {
        this.totalDriveSpaceBytes = totalDriveSpaceBytes;
        this.freeDriveSpaceBytes = freeDriveSpaceBytes;
        this.usableDriveSpaceBytes = usableDriveSpaceBytes;
    }

    public long getTotalDriveSpaceBytes() {
        return this.totalDriveSpaceBytes;
    }
    public double getTotalDriveSpaceGigabytes() {
        return (double) this.getTotalDriveSpaceBytes() / DriveSpaceMetrics.BYTES_IN_GIGABYTE;
    }
    public long getFreeDriveSpaceBytes() {
        return this.freeDriveSpaceBytes;
    }
    public double getFreeDriveSpaceGigabytes() {
        return (double) this.getFreeDriveSpaceBytes() / DriveSpaceMetrics.BYTES_IN_GIGABYTE;
    }
    public long getUsableDriveSpaceBytes() {
        return this.usableDriveSpaceBytes;
    }
    public double getUsableDriveSpaceGigabytes() {
        return (double) this.getUsableDriveSpaceBytes() / DriveSpaceMetrics.BYTES_IN_GIGABYTE;
    }

    public String toReadableString() {
        String format = "drive_space={total='%.2fGB', free='%.2fGB', usable='%.2fGB'}";

        String output = String.format(
                format,
                this.getTotalDriveSpaceGigabytes(),
                this.getFreeDriveSpaceGigabytes(),
                this.getUsableDriveSpaceGigabytes()
        );
        return output;
    }
}
