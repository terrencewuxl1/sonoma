package com.zip.code.model;

/**
 * Zip code range  means the range between start and end (contains start and end)
 * <p>
 * start not larger than end, otherwise, throw a runtime exception
 */
public class ZipRange {
    private int start;
    private int end;

    public ZipRange(int start, int end) {
        if (start > end) {
            throw new RuntimeException("Zip range error as : the start larger than end.");
        }
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        if (start > end) {
            throw new RuntimeException("Zip range error as : the start larger than end.");
        }
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        if (start > end) {
            throw new RuntimeException("Zip range error as : the start larger than end.");
        }
        this.end = end;
    }
}
