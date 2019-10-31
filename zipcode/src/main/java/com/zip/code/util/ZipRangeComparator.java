package com.zip.code.util;

import com.zip.code.model.ZipRange;

import java.util.Comparator;

/**
 * Compare ZipRange object using ZipRange.start number
 */
public class ZipRangeComparator implements Comparator<ZipRange> {

    @Override
    public int compare(ZipRange o1, ZipRange o2) {
        return o1.start<o2.start?-1:o1.start==o2.start?0:1;
    }
}
