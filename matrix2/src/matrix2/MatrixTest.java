package matrix2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixTest {

	double[] elementen;
	Matrix matrix;
	
	@BeforeEach
	void setup() {
		elementen = new double [] {0.0, 0.1, 0.2, 1.0, 1.1, 1.2, 2.0, 2.1, 2.2};
		matrix = new Matrix(3, 3, elementen);
	}
	
	@Test
	void testGetRowMajor() {
		assertTrue(Arrays.equals(new double [] {0.0, 0.1, 0.2, 1.0, 1.1, 1.2, 2.0, 2.1, 2.2}, matrix.getRowMajor()));
	}
	
	@Test
	void testGetColMajor() {
		assertTrue(Arrays.equals(new double [] {0.0, 1.0, 2.0, 0.1, 1.1, 2.1, 0.2, 1.2, 2.2}, matrix.getColMajor()));
	}
	
	@Test
	void testArrayOfArray() {
		assertTrue(Arrays.deepEquals(new double[][]{{0.0, 0.1, 0.2}, {1.0, 1.1, 1.2}, {2.0, 2.1, 2.2}}, matrix.ArrayOfArray()));
	}
	
	@Test
	void testAt() {
		assertEquals(0.1, matrix.at(0, 1));
		assertEquals(1.2, matrix.at(1, 2));
	}
	
	@Test
	void testPlus() {
		assertTrue(Arrays.equals(new double [] {1.0, 2.0, 3.0, 1.1, 2.1, 3.1, 1.2, 2.2, 3.2}, matrix.plus(1).getColMajor()));
	}
	
	@Test
	void testScaled() {
		assertTrue(Arrays.equals(new double [] {0.0, 2.0, 4.0, 0.2, 2.2, 4.2, 0.4, 2.4, 4.4}, matrix.scaled(2).getColMajor()));
	}
	
	
	
	
}
