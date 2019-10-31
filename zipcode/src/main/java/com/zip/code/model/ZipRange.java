package com.zip.code.model;

/**
 * Zip code range  means the range between start and end (contains start and end)</br>
 * ->[start,end]
 */
public class ZipRange {
    public int start;
    public int end;

    public ZipRange(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
