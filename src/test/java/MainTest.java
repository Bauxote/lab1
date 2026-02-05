import org.junit.Assert;
import org.junit.Test;

    public class MainTest {
        @Test
        public void testMultiplyMatrix() {
            short[][] inputMatrix = {{1, 2}, {3, 4}};
            short multiplier = 2;
            short[][] expected = {{2, 4}, {6, 8}};
            short[][] result = Main.multiplyMatrix(inputMatrix, multiplier);

            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void testFindMin() {
            short[] inputArray = {2,3,1,4};
            short expected = 1;
            short result = Main.findMin(inputArray);

            Assert.assertEquals(expected, result);
        }

        @Test
        public void testCalculateSumMinRow() {
            short[][] inputMatrix = {{1, 2}, {3, 4}, {8,3}};
            // 1+3+3 = 7
            short result = Main.calculateSumMinRow(inputMatrix);

            Assert.assertEquals(7, result);
        }
    }