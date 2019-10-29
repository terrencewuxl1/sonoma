package com.zip.code;

import java.util.*;

public class ZipCodeRangeMerge {

    /**
     * Produces the minimum number of ranges required to represent the same restrictions as the input range array
     *
     * @param zipCodeArray Range array input example: [[94133,94133] [94200,94299] [94600,94699]]
     * @return int array contains minimum number of ranges represent the same restrictions as the input
     */
    public int[][] mergeRange(int[][] zipCodeArray) {
        if (zipCodeArray == null || zipCodeArray.length == 0) return zipCodeArray;
        sortZipCodeList(zipCodeArray);
        List<int[]> result = new ArrayList<>();
        int[] temp = zipCodeArray[0];
        for (int i = 0; i < zipCodeArray.length - 1; i++) {
            if (temp[1] >= zipCodeArray[i + 1][0]) {
                temp[1] = Math.max(temp[1], zipCodeArray[i + 1][1]);
            } else {
                result.add(temp);
                temp = zipCodeArray[i + 1];
            }
        }
        result.add(temp);
        return result.toArray(new int[result.size()][]);
    }

    private void sortZipCodeList(int[][] zipCodeArray) {
        Arrays.sort(zipCodeArray, Comparator.comparingInt(o -> o[0]));
    }


}
