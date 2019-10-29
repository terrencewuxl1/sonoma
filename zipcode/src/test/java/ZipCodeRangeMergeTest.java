import com.zip.code.ZipCodeRangeMerge;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ZipCodeRangeMergeTest {

    @Test
    public void inputNull() {
        Assert.assertNull(new ZipCodeRangeMerge().mergeRange(null));
    }

    @Test
    public void inputEmptyArray() {
        int[][] input = new int[0][0];
        int[][] output = new ZipCodeRangeMerge().mergeRange(input);
        Assert.assertEquals("[]", Arrays.deepToString(output));
    }

    @Test
    public void onlyOneRange() {
        int[][] input = new int[][]{{95112, 95234}};
        int[][] output = new ZipCodeRangeMerge().mergeRange(input);
        Assert.assertEquals("[[95112, 95234]]", Arrays.deepToString(output));
    }

    @Test
    public void noOverlapRange() {
        int[][] input = new int[][]{{95234, 95235}, {95236, 95237}, {95232, 95233}};
        int[][] output = new ZipCodeRangeMerge().mergeRange(input);
        Assert.assertEquals("[[95232, 95233], [95234, 95235], [95236, 95237]]", Arrays.deepToString(output));
    }

    @Test
    public void OverlapRange() {
        int[][] input = new int[][]{{95234, 95235}, {95236, 95237}, {95232, 95234}};
        int[][] output = new ZipCodeRangeMerge().mergeRange(input);
        Assert.assertEquals("[[95232, 95235], [95236, 95237]]", Arrays.deepToString(output));
    }

    @Test
    public void containsSameRange() {
        int[][] input = new int[][]{{95234, 95235}, {95236, 95237}, {95232, 95233}, {95236, 95237}, {95232, 95233}};
        int[][] output = new ZipCodeRangeMerge().mergeRange(input);
        Assert.assertEquals("[[95232, 95233], [95234, 95235], [95236, 95237]]", Arrays.deepToString(output));
    }

    @Test
    public void aRangeContainsAllRange() {
        int[][] input = new int[][]{{95234, 95235}, {95236, 95237}, {95232, 95250}};
        int[][] output = new ZipCodeRangeMerge().mergeRange(input);
        Assert.assertEquals("[[95232, 95250]]", Arrays.deepToString(output));
    }

    @Test
    public void overlapAndContainsMultiRange() {
        int[][] input = new int[][]{{95234, 95235}, {95236, 95237}, {95235, 95250}, {95221, 95222}, {95211, 95221}};
        int[][] output = new ZipCodeRangeMerge().mergeRange(input);
        Assert.assertEquals("[[95211, 95222], [95234, 95250]]", Arrays.deepToString(output));
    }

}
