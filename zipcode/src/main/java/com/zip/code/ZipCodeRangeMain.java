package com.zip.code;

import com.zip.code.util.ZipCodeRangeUtil;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class ZipCodeRangeMain {


    public static void main(String[] args) {

        // using args to input zip code ranges, each range as a arg by [number,number] format
        if (args.length < 1) {
            System.out.println("Usage:java -jar <jar name> <zip range> <zip range>...");
            System.out.println(" <zip range> format : [number,number]");
            return;
        }
        int[][] inputArray = convertStringToIntArray(args);
        if (inputArray == null) return;
        int[][] result = new ZipCodeRangeUtil().findMinNumOfZipRanges(inputArray);
        System.out.println(Arrays.deepToString(result));
    }


    /**
     * convert args to int[] array, args must be [number,number] [number,number]...</br>
     * format, otherwise, return null.
     *
     * @param args program arguments, input the zip ranges string array
     * @return int[] array contains zip ranges
     */
    private static int[][] convertStringToIntArray(String[] args) {
        int[][] zipIntArray = new int[args.length][2];
        for (int i = 0; i < args.length; i++) {
            String[] numbers = args[i].substring(1, args[i].length() - 1)
                    .split(",");
            try {
                zipIntArray[i][0] = parseInt(numbers[0]);
                zipIntArray[i][1] = parseInt(numbers[1]);
            } catch (NumberFormatException e) {
                //If the args format incorrect, print usage message.
                System.out.println("Zip range format error, <zip range> format : [number,number]");
                return null;
            }
        }
        return zipIntArray;
    }
}
