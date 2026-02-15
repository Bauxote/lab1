import org.junit.Assert;
import org.junit.Test;

    public class MatrixTest {
        @Test
        public void testMultiplyMatrix(){
            Matrix testSubject = new Matrix(1, 1, 5, 5);
            Matrix result = testSubject.multiply(10);
            Assert.assertTrue(result.toString().contains("50"));
        }

        @Test
        public void testCalculateSumMinRow(){
            Matrix testSubject = new Matrix(3, 1, 5, 5);
            // should be 15, ig
            int result = testSubject.calculateSumMinRow();

            Assert.assertEquals(15, result);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testInvalidLimitsOldStyle() {
            new Matrix(2, 2, 50, 10);
        }

    }
