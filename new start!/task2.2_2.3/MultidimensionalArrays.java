package info2;

public class MultidimensionalArrays {

    // ----------------------------------------------------------------
    // Exercise 3 (a)
    //
    //  C = A x B :
    //
    //                  b11 b12
    //                  b21 b22
    //                  b31 b32
    //
    //  a11 a12 a13     c11 c12
    //  a21 a22 a23     c21 c22
    //  a31 a32 a33     c31 c32
    //
    //  General rule: c_ij = sum_k a_ik * b_kj
    //
    //  Examples: 
    //     c11 = a11 * b11 + a12 * b21 + a13 * b31 
    //     c22 = a21 * b12 + a22 * b22 + a23 * b32
    //
    // ----------------------------------------------------------------
    public static double[][] matrixMul(double[][] A, double[][] B) {
        
        final int rowsA = A.length;//Zeilen
        final int colsA = A[0].length;//Spalten
        final int rowsB = B.length;
        final int colsB = B[0].length;
        
        int size = 0;
        if (colsA != rowsB) {
        	return null;//i)They need the same index k as rowsA and colsB
        }else {
        	size = colsA;
        }
        
        double[][] C = new double[rowsA][colsB];
        //ii)create an empty matrix C as solution
        for (int i = 0; i < rowsA; i++) {
        	for (int j = 0; j < colsB; j++) {//iii)use for-loop for Cij 
        		for (int k = 0; k < size; k++) {//iv)use for-loop for the common k
        			C[i][j] += A[i][k] * B[k][j];//the formula of matrix multiplication
        		}
        	}
        }
        
        // TODO: Implement me.
        
        return C;
    }

    // ----------------------------------------------------------------
    // Exercise 2 (b)
    // ----------------------------------------------------------------
    public static int[] flatten(int[][][] array) {
        
    	int num = 0;//elements' number of new array
    	
    	if (array == null) {
    		return null;
    	} else {
    		for (int i = 0; i < array.length; i++) {
    			if (array[i] != null) {
    				for (int j = 0; j < array[i].length; j++) {
    					if (array[i][j] != null) {
    						num += array[i][j].length;
    					}
    				}
    			}
    		}
    	}//count the number of non-null element in total as the length of new array
    	
    	
    	int[] result = new int[num];
    	num = 0;//we use this variable again to show index of new array
    	
    	for (int i = 0; i < array.length; i++) {
    		if (array[i] != null) {
    			for (int j = 0; j < array[i].length; j++) {
    				if (array[i][j] != null) {
    					for (int k = 0; k < array[i][j].length; k++) {
    						result[num] = array[i][j][k];
    						num++;//go to the next position to save new element
    					}
    				}
    			}
    		}
    	}
        // TODO: Implement me.
        
    	return result;
    }

    // ----------------------------------------------------------------

    public static String DELIMITER = ", ";
    
    //
    // Helper function for converting int-arrays into strings.
    //
    public static String asString(final int[] array) {
        if (array == null) { return "null"; }

        final StringBuilder out = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                out.append(DELIMITER);
            }
            out.append(String.valueOf(array[i]));
        }
        return out.toString();
    }

    //
    // Helper method for converting 2d-double-arrays into strings.
    //
    public static String asString(final double[][] array) {
        if (array == null) { return "null"; }

        final StringBuilder out = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                out.append(System.lineSeparator());
            }
            if (array[i] == null) {
                out.append("null");
            } else {
                for (int j = 0; j < array[i].length; j++) {
                    if (j > 0) {
                        out.append("\t");
                    }
                    out.append(String.valueOf(array[i][j]));
                }
            }
        }
        return out.toString();
    }
    
    public static void main(String[] args) {

        // ----------------------------------------------------------------
        // Exercise 3 (a)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 3 (a) --------");
            System.out.println();

            final double[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            
            final double[][] B = {
                {1, 2},
                {3, 4},
                {5, 6}
            };
            
            final double[][] C = matrixMul(A, B);
            
            System.out.println(asString(A));
            System.out.println("x");
            System.out.println(asString(B));
            System.out.println("=");
            System.out.println(asString(C));
            System.out.println();
            
        }
        
        
        
        // ----------------------------------------------------------------
        // Exercise 3 (b)
        // ----------------------------------------------------------------
        {
            System.out.println("-------- Exercise 3 (b) --------");
            System.out.println();

            int[][][] array = {
                {
                    {0},
                    {1, 2},
                    null,
                    {3, 4, 5},
                },
                {
                    {7, 8, 9, 10},
                    {11}
                },
                {
                    {12, 13, 14, 15},
                    {16, 17, 18, 19},
                    {20, 21}
                },
                null
            };
            
            int[] flat = flatten(array);
            
            System.out.println(asString(flat));
            
            System.out.println();
        } 
    }

}
