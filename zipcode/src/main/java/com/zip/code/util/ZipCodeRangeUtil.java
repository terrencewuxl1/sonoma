package com.zip.code.util;

import com.zip.code.model.ZipRange;

import java.util.*;

public class ZipCodeRangeUtil {

    /**
     * Produces the minimum number of ranges required to represent the same </br>
     * restrictions as the input range array
     *
     * @param zipRanges {@link ZipRange} object's array
     * @return {@link ZipRange} array contains minimum number of ranges represent</br>
     * the same restrictions as the input
     */
    public ZipRange[] findMinNumOfZipRanges(ZipRange[] zipRanges) {
        //null/empty input return null/empty
        if (zipRanges == null || zipRanges.length == 0) return zipRanges;

        sortZipCodeRangeArray(zipRanges); //sort input zip range array

        List<ZipRange> result = new ArrayList<>();
        for (ZipRange currentZipRange : zipRanges) {
            //merge current zip range into result list
            mergeZipRangeToResult(result, currentZipRange);
        }

        return result.toArray(new ZipRange[result.size()]);
    }

    /**
     * merge current Zip range into result list's range.
     * If they are contains or continuous, merge into last of result list's elements.
     * If not, add current range in result list.
     *
     * @param result          the result list being merged
     * @param currentZipRange zip code range merged to result list
     */
    private void mergeZipRangeToResult(List<ZipRange> result, ZipRange currentZipRange) {
        ZipRange lastRange = null;
        if (!result.isEmpty()) {
            //get the last(biggest) range in the result list
            lastRange = result.get(result.size() - 1);
        }
        if (result.isEmpty() || lastRange.getEnd() < currentZipRange.getStart() - 1) {
            // Save the first zip range into result  OR
            // There is gap between last range in result and current zip range, save
            // current zip range to result.
            result.add(currentZipRange);
        } else {
            // Merge current zip range into last range in result.
            lastRange.setEnd(Math.max(lastRange.getEnd(), currentZipRange.getEnd()));
        }
    }

    /**
     * sort zip ranges array using {@link ZipRangeComparator}, sort by ascending order of </br>
     * ZipRange.start
     *
     * @param zipRanges unsorted ZipRange object's array
     */
    private void sortZipCodeRangeArray(ZipRange[] zipRanges) {
        Arrays.sort(zipRanges, new ZipRangeComparator());
    }

    /**
     * same function as {@link ZipCodeRangeUtil#findMinNumOfZipRanges(ZipRange[])} using </br>
     * int[] array structure at input and output data.
     *
     * @param zipIntArray zip code range array using int[] array structure, every range is a </br>
     *                    length 2 int[], the first element is start number, second element </br>
     *                    is the end number
     * @return minimum number of zip code ranges same restrictions as the input zip range array
     */
    public int[][] findMinNumOfZipRanges(int[][] zipIntArray) {
        ZipRange[] result = findMinNumOfZipRanges(convertToZipRangeArray(zipIntArray));
        return convertToIntArray(result);
    }


    /**
     * Convert int[] array into {@link ZipRange} array
     *
     * @param zipIntArray zip code range array using int[] array structure, every range is a </br>
     *                    length 2 int[], the first element is start number, second element </br>
     *                    is the end number
     * @return zipRange objects array same value as the input
     */
    private ZipRange[] convertToZipRangeArray(int[][] zipIntArray) {
        if(zipIntArray==null)return null;
        ZipRange[] zipRanges = new ZipRange[zipIntArray.length];
        for (int i = 0; i < zipRanges.length; i++) {
            zipRanges[i] = new ZipRange(zipIntArray[i][0], zipIntArray[i][1]);
        }
        return zipRanges;
    }

    /**
     * Convert {@link ZipRange} array into int[] array
     *
     * @param zipRanges ZipRange object's array
     * @return int[] array the same value as input
     */
    private int[][] convertToIntArray(ZipRange[] zipRanges) {
        if(zipRanges==null)return null;
        int[][] intArray = new int[zipRanges.length][2];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i][0] = zipRanges[i].getStart();
            intArray[i][1] = zipRanges[i].getEnd();
        }
        return intArray;
    }


}
