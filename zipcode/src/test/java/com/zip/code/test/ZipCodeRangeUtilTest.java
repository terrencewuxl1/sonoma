package com.zip.code.test;

import com.zip.code.util.ZipCodeRangeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ZipCodeRangeUtilTest {

    @Test
    public void inputNull() {
        int[][] input = null;
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertNull(output);
    }

    @Test
    public void inputEmptyArray() {
        int[][] input = new int[0][0];
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[]", Arrays.deepToString(output));
    }

    @Test
    public void oneRange() {
        int[][] input = new int[][]{{95112, 95176}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95112, 95176]]", Arrays.deepToString(output));
    }

    @Test
    public void oneRangeStartLargerThanEnd() {
        int[][] input = new int[][]{{95500, 95176}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95500, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesHaveAGap() {
        int[][] input = new int[][]{{95000, 95200}, {95400, 95500}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95000, 95200], [95400, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesAreContinuous() {
        int[][] input = new int[][]{{95000, 95200}, {95201, 95500}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95000, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesFirstEndEqualsSecondStart() {
        int[][] input = new int[][]{{95000, 95200}, {95200, 95500}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95000, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesHaveOverlap() {
        int[][] input = new int[][]{{95000, 95200}, {95100, 95500}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95000, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesFirstContainsSecond() {
        int[][] input = new int[][]{{95000, 95500}, {95200, 95300}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95000, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesSecondContainsFirst() {
        int[][] input = new int[][]{{95200, 95400}, {95000, 95500}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95000, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesSameStartDifferenceEnd() {
        int[][] input = new int[][]{{95000, 95500}, {95000, 95300}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95000, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesSameEndDifferenceStart() {
        int[][] input = new int[][]{{95200, 95500}, {95300, 95500}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95200, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesSameRange() {
        int[][] input = new int[][]{{95200, 95500}, {95200, 95500}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95200, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void twoRangesContains4DigitZipCode() {
        int[][] input = new int[][]{{9520, 95300}, {95200, 95500}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[9520, 95500]]", Arrays.deepToString(output));
    }

    @Test
    public void threeRangesWithOverlap() {
        int[][] input = new int[][]{{95200, 95500}, {95500, 95800},{95100,95300}};
        int[][] output = new ZipCodeRangeUtil().findMinNumOfZipRanges(input);
        Assert.assertEquals("[[95100, 95800]]", Arrays.deepToString(output));
    }


}
