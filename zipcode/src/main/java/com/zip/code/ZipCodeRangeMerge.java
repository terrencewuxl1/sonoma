package com.zip.code;

import java.util.*;

public class ZipCodeRangeMerge {

    /**
     * Produces the minimum number of ranges required to represent the same restrictions as the input range array
     *
     * @param zipCodeRanges Range array, input example: [[94133,94133] [94200,94299] [94600,94699]]
     * @return Range array contains minimum number of ranges represent the same restrictions as the input
     */
    public int[][] mergeRange(int[][] zipCodeRanges) {
        if (zipCodeRanges == null || zipCodeRanges.length == 0) return zipCodeRanges;
        sortZipCodeList(zipCodeRanges);
        List<int[]> resultRanges = new ArrayList<>();
        int[] tempRange = zipCodeRanges[0];
        for (int i = 0; i < zipCodeRanges.length - 1; i++) {
            if (tempRange[1] >= zipCodeRanges[i + 1][0]) {
                tempRange[1] = Math.max(tempRange[1], zipCodeRanges[i + 1][1]);
            } else {
                resultRanges.add(tempRange);
                tempRange = zipCodeRanges[i + 1];
            }
        }
        resultRanges.add(tempRange);
        return resultRanges.toArray(new int[resultRanges.size()][]);
    }

    private void sortZipCodeList(int[][] zipCodeRanges) {
        Arrays.sort(zipCodeRanges, Comparator.comparingInt(o -> o[0]));
    }


}
