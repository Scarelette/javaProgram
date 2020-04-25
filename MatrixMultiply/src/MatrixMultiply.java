import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class MatrixMultiply extends Thread {
    private double[][] matrixA,matrixB;
    private int gap;
    private int index;
    private CountDownLatch countDownLatch;
    private double[][] result;

    public static double[][] serialMultipply(double[][] matrixA, double[][] matrixB) {
        double startTime = System.currentTimeMillis();
        if(matrixA[0].length != matrixB.length){
            System.out.println("两个矩阵不能相乘");
            return null;
        }
        int x = matrixA.length;
        int y = matrixB[0].length;
        double[][] result = new double[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        double endTime = System.currentTimeMillis();
        int mid = matrixB.length;
        System.out.println("矩阵(" + x + "," + mid + ")(" + mid + "," + y +")串行计算运行时间为: " + (endTime - startTime));
        return result;
    }

    public MatrixMultiply(double[][] A, double[][] B, int index, int gap, double[][] result, CountDownLatch countDownLatch) {
        this.matrixA = A;
        this.matrixB = B;
        this.index = index;
        this.gap = gap;
        this.result = result;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = index * gap; i < (index + 1) * gap; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixB.length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        countDownLatch.countDown();
    }

    public static double[][] parallelMultiply(double[][] matrixA, double[][] matrixB, int threadnum) throws InterruptedException {
        double startTime = System.currentTimeMillis();
        int x = matrixA.length;
        int y = matrixB[0].length;
        double[][] result = new double[x][y];
        int gap = matrixA.length / threadnum;
        CountDownLatch countDownLatch = new CountDownLatch(threadnum);
        for (int i = 0; i < threadnum; i++) {
            MatrixMultiply task = new MatrixMultiply(matrixA,matrixB,i,gap,result,countDownLatch);
            task.start();
        }
        countDownLatch.await();
        double endTime = System.currentTimeMillis();
        int mid = matrixB.length;
        System.out.println("矩阵(" + x + "," + mid + ")(" + mid + "," + y +") thread = " + threadnum + ", 并行计算运行时间为: " + (endTime - startTime));
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        double[][] matrix1 = MatrixGenerator.create_Matrix(400,400);
        double[][] martrix2 = MatrixGenerator.create_Matrix(400,400);

        double[][] serialRes = serialMultipply(matrix1, martrix2);
        double[][] parallelRes = parallelMultiply(matrix1,martrix2,50);
        assert Arrays.deepEquals(serialRes, parallelRes);
    }

}
