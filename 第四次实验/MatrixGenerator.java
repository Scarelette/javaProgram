public class MatrixGenerator {
    //生成一个n阶矩阵A,并打印A
    public static double[][] create_Matrix(int row_number,int column_number ) {


        double matrixA[][] = new double[row_number][column_number];
        for (int i = 0; i <= row_number - 1; i++) {
            for (int j = 0; j <= column_number - 1; j++) {
                matrixA[i][j] = random_number();
//                System.out.print(matrixA[i][j] + " ");
            }
//            System.out.println();
        }
        return matrixA;
    }

    //产生一个1~100的随机整数，用于自动填入矩阵A的每个位之中
    public static int random_number(){
        int number;
        number = new java.util.Random().nextInt(100)+1;
        return number;
    }

}
