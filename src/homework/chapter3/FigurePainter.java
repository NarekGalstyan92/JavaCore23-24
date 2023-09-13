package homework.chapter3;

class FigurePainter {

    void figureOne(int n, char c) {
        if (n < 1){
            System.out.println("Incorrect value!");
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(c + " ");
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
    }

    void figureTwo(int n) {
        System.out.println("\n");

        for (int i = n; i > 0; i--) {
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

    }

    void figureThree(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
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
    }

    void figureFour(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = i; j < n; j++) {
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
    }

    void figureFive(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("* ");
            }
            System.out.println();

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
}




