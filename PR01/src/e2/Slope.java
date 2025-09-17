package e2;

public class Slope {

    private static boolean isNotCharAllowed(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar != '.' && aChar != '#') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isJagged(char[][] matrix) {
        for (char[] chars : matrix) {
            if (matrix[0].length != chars.length) {
                return true;
            }
        }
        return false;
    }

    private static void checkExceptions(char[][] slopeMap, int right, int down) {
        if (slopeMap.length != slopeMap[0].length || isJagged(slopeMap)) {
            throw new IllegalArgumentException("The matrix is not square");
        }

        if (isNotCharAllowed(slopeMap)) {
            throw new IllegalArgumentException("The matrix has characters other than \".\" and \"#\"");
        }

        if (right >= slopeMap[0].length || 1 > right || down >= slopeMap.length || 1 > down) {
            throw new IllegalArgumentException("The right, down or matrix size values are not allowed");
        }
    }

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * @param slopeMap A square matrix representing the slope with spaces
     * represented as "." and trees represented as "#".
     * @param right Movement to the right
     * @param down Downward movement
     * @return Number of trees
     * @throws IllegalArgumentException if the matrix is incorrect because :
     * - It is not square .
     * - It has characters other than "." and "#"
     * - right >= number of columns or right < 1
     * - down >= number of rows of the matrix or down < 1
     */
    public static int downTheSlope ( char [][] slopeMap , int right , int down ) {
        int trees = 0;
        int nextright = 0;
        int downpos = 0;

        checkExceptions(slopeMap, right, down);

        do {
            if (nextright == 0 && downpos == 0 && slopeMap[nextright][downpos] == '#') {
                trees++;
                nextright++;
            }
            for (int i = 0; i < right; i++) {
                if (nextright != slopeMap[0].length) {
                    nextright++;
                }
                if (nextright == slopeMap[0].length) {
                    nextright = 0;
                }
                if (slopeMap[downpos][nextright] == '#') {
                    trees++;
                }
            }
            for (int i = 0; i < down; i++) {
                if (++downpos == slopeMap.length) break;
                if (slopeMap[downpos][nextright] == '#') {
                    trees++;
                }
            }
        }while (downpos < slopeMap.length);
        return trees;
    }

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * Since it " jumps " from the initial position to the final position ,
     * only takes into account the trees on those initial / final positions .
     * Params , return value and thrown expections as in downTheSlope ...
     */

    public static int jumpTheSlope ( char [][] slopeMap , int right , int down ) {
        int trees = 0;
        int nextright = 0;
        int downpos = 0;

        checkExceptions(slopeMap, right, down);

        do {
            if (nextright == 0 && downpos == 0 && slopeMap[nextright][downpos] == '#') {
                trees++;
                nextright++;
            }
            for (int i = 0; i < right; i++) {
                if (nextright != slopeMap[0].length) {
                    nextright++;
                }
                if (nextright == slopeMap[0].length) {
                    nextright = 0;
                }
            }
            for (int i = 0; i < down; i++) {
                if (++downpos == slopeMap.length) break;
            }
            if (downpos < slopeMap.length && slopeMap[downpos][nextright] == '#') {
                trees++;
            }
        }while (downpos < slopeMap.length);
        return trees;
    }

    public static void main(String[] args) {
        char [][] slopeMap = {
                {'.','.','#','#','.','.','.','.','.','.','.'},
                {'#','.','.','.','#','.','.','.','#','.','.'},
                {'.','#','.','.','.','.','#','.','.','#','.'},
                {'.','.','#','.','#','.','.','.','#','.','#'},
                {'.','#','.','.','.','#','#','.','.','#','.'},
                {'.','.','#','.','#','#','.','.','.','.','.'},
                {'.','#','.','#','.','#','.','.','.','.','#'},
                {'.','#','.','.','.','.','.','.','.','.','#'},
                {'#','.','#','#','.','.','.','#','.','.','.'},
                {'#','.','.','.','#','#','.','.','.','.','#'},
                {'.','#','.','.','#','.','.','.','#','.','#'}

        };
        int right = 3;
        int down = 1;

        System.out.println("Down the slope: " + downTheSlope (slopeMap , right , down));
        System.out.println("Jump the slope: " + jumpTheSlope (slopeMap , right , down));
    }
}
