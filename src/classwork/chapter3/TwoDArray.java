package classwork.chapter3;

class TwoDArray {
    public static void main(String[] args) {
        int[][] two = new int[4][5];
        int i, j, k = 0;

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                two[i][j] = k;
                k++;
            }
        }

        for (i = 0; i < 4; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print(two[i][j] + " ");
            }
            System.out.println();
        }
    }
}
