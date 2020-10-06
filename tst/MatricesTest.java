import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MatricesTest {

    @Test
    @Order(1)
    @DisplayName("Add 2 3x3 arrays")
    void testAdd() {
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        double[][] c = Matrices.addMatrix(a, b);
        Matrices.printMatrix(a, b, c, '+');
    }

    @Test
    @Order(2)
    @DisplayName("Subtract 2 3x3 arrays")
    void testSubtract() {
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        double[][] c = Matrices.subtractMatrix(a, b);
        Matrices.printMatrix(a, b, c, '-');
    }

    @Test
    @Order(3)
    @DisplayName("Multiply 3 x 3 arrays")
    void testMultiply() {
        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{0, 2, 4}, {1, 4.5, 2.2}, {1.1, 4.3, 5.2}};
        double[][] c = Matrices.multiplyMatrix(a, b);
        Matrices.printMatrix(a, b, c, '*');
    }

    @Test
    @Order(4)
    @DisplayName("3 x 4 result")
    void testMultiply2() {
        double[][] a = {{1,5},{2,3},{1,7}};
        double[][] b = {{1,2,3,7},{5,2,8,1}};
        double[][] c = Matrices.multiplyMatrix(a, b);
        Matrices.printMatrix(a, b, c, '*');
    }

    @Test
    @Order(5)
    @DisplayName("1 x 1 result")
    void testMultiply3() {
        double[][] a = {{1, 2 , 3, 4, 5}};
        double[][] b = {{10}, {20}, {30}, {40}, {50}};
        double[][] c = Matrices.multiplyMatrix(a, b);
        Matrices.printMatrix(a, b, c, '*');
    }

}