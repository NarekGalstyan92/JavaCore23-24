package homework.chapter3;

class FigurePainter {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        /* Output:

         *
         * *
         * * *
         * * * *
         * * * * *

         */

        System.out.println("\n");

        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        /* Output:

         * * * * *
         * * * *
         * * *
         * *
         *

         */

        System.out.println("\n");

        int line = 5;
        for (int i = 0; i < line; i++) {
            for (int j = i + 1; j < line; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        /* Output:

         *
         * *
         * * *
         * * * *
         * * * * *

         */

        System.out.println("\n");

        for (int i = line; i > 0; i--) {
            for (int j = i; j < line; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }


            System.out.println();
        }
        /* Output:

         * * * * *
         * * * *
         * * *
         * *
         *

         */

        System.out.println("\n");

        for (int i = 0; i < line; i++) {
            for (int j = i + 1; j < line; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = line -1; i > 0; i--) {
            for (int j = i; j < line; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        /* Output:

             *
            * *
           * * *
          * * * *
         * * * * *
          * * * *
           * * *
            * *
             *

         */

    }
}

