package com.etauker.spider.service;

public class ByteConversionService {

    private static final long BYTES_IN_GIGABYTE = 1073741824;

    public static double bytesToGigabytes(long bytes) {
        return (double) bytes / ByteConversionService.BYTES_IN_GIGABYTE;
    }
}
