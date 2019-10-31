package com.zip.code.util;

import com.zip.code.model.ZipRange;

import java.util.Comparator;

/**
 * Compare ZipRange object using ZipRange.start
 */
public class ZipRangeComparator implements Comparator<ZipRange> {

    @Override
    public int compare(ZipRange o1, ZipRange o2) {
        return Integer.compare(o1.getStart(), o2.getStart());
    }
}
