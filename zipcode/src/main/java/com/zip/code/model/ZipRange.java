package com.zip.code.model;

/**
 * Zip code range  means the range between start and end (contains start and end)
 * <p>
 * start not larger than end, otherwise, should be processed as the range </br>
 * only contains the start zip code. example: [95001,94001] -> [95001,95001]
 */
public class ZipRange {
    private int start;
    private int end;

    public ZipRange(int start, int end) {
        this.start = start;
        this.end = start > end ? start : end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = start > end ? start : end;
    }
}
