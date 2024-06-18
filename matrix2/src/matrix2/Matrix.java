package matrix2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @immutable
 */
public class Matrix {
	
	/**
	 * @invar | elements != null	 
	 * @representationObject
	 */
	private double[] elements;
	
	/**	 
	 * @invar | nrRows >= 0
	 */
	private int nrRows;
	
	/**	 
	 * @invar | nrCols >= 0
	 */
	private int nrCols;
	
	
	/**
	 * @pre | nrRows > 0
	 * @pre | nrCols > 0
	 * @pre | elements != null
	 * 
	 * @post | getNrCols() == nrCols
	 * @post | getNrRows() == nrRows
	 * @post | Arrays.equals(getRowMajor(), elements)
	 */
	public Matrix(int nrRows, int nrCols, double[] elements) {
		this.elements = elements.clone();
		this.nrRows = nrRows;
		this.nrCols = nrCols;
	}

	/**
	 * @post | result != null
	 * @post | result.length == getNrRows() * getNrCols()

	 */
	public double[] getRowMajor() {
		return this.elements.clone();
	}
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | result.length == getNrRows() * getNrCols()
	 * @post | IntStream.range(0, getNrRows()-1).allMatch(i -> IntStream.range(0, getNrCols()-1).allMatch(j -> result[j * getNrRows() + i] == getRowMajor()[i * getNrCols() + j]))
	 */
	public double[] getColMajor() {
		double[] result = new double[elements.length];
		for(int i = 0; i < nrRows; i++) {
			for(int j = 0; j < nrRows; j++) {
				result[j * nrRows + i] = elements[i * nrCols + j];
			}
		}
		return result;
	}
	
	/**
	 * @creates | result,... result
	 * 
	 * @post | result != null
	 * @post | Arrays.stream(result).allMatch(row -> row != null)
	 * @post | IntStream.range(0, getNrRows()-1).allMatch(i -> IntStream.range(0, getNrCols()-1).allMatch(j -> result[i][j] == getRowMajor()[i * getNrCols() + j]))
	 */
	public double[][] ArrayOfArray() {
		double[][] result = new double[nrRows][nrCols];
		for(int i = 0; i < nrRows; i++) {
			for(int j = 0; j < nrRows; j++) {
				result[i][j] = elements[i * nrCols + j];
			}
		}
		return result;
	}
	
	/**
	 * @post | result >= 0
	 */
	public int getNrRows() {
		return this.nrRows;
	}
	
	/**
	 * @post | result >= 0
	 */
	public int getNrCols() {
		return this.nrCols;
	}
	
	/**
	 * @pre | 0 <= row && row < getNrRows()
	 * @pre | 0 <= col && col < getNrCols()
	 * @post | result == getRowMajor()[row * getNrCols() + col]
	 */
	public double at(int row, int col) {
		int index = (row * this.nrCols + col);
		return elements[index];
	}
	
	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | result.getNrRows() == getNrRows()
	 * @post | result.getNrCols() == getNrCols()
	 * 
	 * @post | IntStream.range(0,getRowMajor().length-1).allMatch(i -> result.getRowMajor()[i] == getRowMajor()[i] * multiplier)

	 */
	public Matrix scaled(int multiplier) {
		double[] scaledElements = new double[elements.length];
		for(int i = 0; i < elements.length; i++) {
			scaledElements[i] = elements[i] * multiplier;
		}
		return new Matrix(nrRows, nrCols, scaledElements);
	}

	
	/**
	 * @creates | result
	 * @post | result != null
	 * @post | result.getNrRows() == getNrRows()
	 * @post | result.getNrCols() == getNrCols()
	 * 
	 * @post | IntStream.range(0,getRowMajor().length-1).allMatch(i -> result.getRowMajor()[i] == getRowMajor()[i] + plus)
	 */
	public Matrix plus(int plus) {
		double[] plusElements = new double[elements.length];
		for(int i = 0; i < elements.length; i++) {
			plusElements[i] = elements[i] + plus;
		}
		return new Matrix(nrRows, nrCols, plusElements);
	}
	
	
	
}
