public class PlaneFigures {
    public static void main(String[] args) {

        System.out.println("Square:");
        System.out.println("***************");
        System.out.println("***************");
        System.out.println("***************");
        System.out.println("***************");
        System.out.println("***************");
        System.out.println();


        System.out.println("Rectangle:");
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println();


        System.out.println("Parallelogram:");
        System.out.println("    ***************");
        System.out.println("   ***************");
        System.out.println("  ***************");
        System.out.println(" ***************");
        System.out.println("***************");
        System.out.println();


        System.out.println("Trapezium:");
        System.out.println("    ****************");
        System.out.println("   ******************");
        System.out.println("  ********************");
        System.out.println(" **********************");
        System.out.println("************************");
        System.out.println();


        System.out.println("Diamond:");
        System.out.println("     *");
        System.out.println("    ***");
        System.out.println("   *****");
        System.out.println("  *******");
        System.out.println(" ÷********");
        System.out.println("***********");
        System.out.println(" *********");
        System.out.println("  *******");
        System.out.println("   *****");
        System.out.println("    ***");
        System.out.println("     *");
        System.out.println();


        System.out.println("Deltoid:");
        System.out.println("    *");
        System.out.println("  *****");
        System.out.println("*********");
        System.out.println(" *******");
        System.out.println("  *****");
        System.out.println("   ***");
        System.out.println("    *");
        System.out.println();


        System.out.println("Triangle:");
        System.out.println("     *");
        System.out.println("    ***");
        System.out.println("   *****");
        System.out.println("  *******");
        System.out.println(" *********");

        String star = "*";
        String space = " ";

        System.out.println();
        System.out.println("Square:");
        for (int i = 0; i < 5; i++) {
            System.out.println(star.repeat(15));
        }


        System.out.println();
        System.out.println("Rectangle:");
        for (int i = 0; i < 5; i++) {
            System.out.println(star.repeat(20));
        }


        System.out.println();
        System.out.println("Parallelogram:");
        for (int i = 0; i < 5; i++) {
            System.out.print(space.repeat(4 - i));
            System.out.println(star.repeat(20));
        }


        System.out.println();
        System.out.println("Trapezium:");
        for (int i = 0; i < 5; i++) {
            System.out.print(space.repeat(4 - i));
            System.out.println(star.repeat(16 + 2 * i));
        }


        System.out.println();
        System.out.println("Diamond:");
        for (int i = 0; i < 6; i++) {
            System.out.print(space.repeat(5 - i));
            System.out.println(star.repeat(1 + 2 * i));
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(space.repeat(1 + i));
            System.out.println(star.repeat(9 - 2 * i));
        }


        System.out.println();
        System.out.println("Deltoid:");
        for (int i = 0; i < 3; i++) {
            System.out.print(space.repeat(4 - 2 * i));
            System.out.println(star.repeat(1 + 4 * i));
        }
        for (int i = 0; i < 4; i++) {
            System.out.print(space.repeat(1 + i));
            System.out.println(star.repeat(7 - 2 * i));
        }


        System.out.println();
        System.out.println("Triangle:");
        for (int i = 0; i < 5; i++) {
            System.out.print(space.repeat(5 - i));
            System.out.println(star.repeat(1 + 2 * i));
        }





        System.out.println();
        System.out.println("Deltoid:");
        for (int i = 0; i < 7; i++) {
            if (i >= 3) {
                System.out.print(space.repeat(1 + i - 3));
                System.out.println(star.repeat(13 - i * 2));
            } else {
                System.out.print(space.repeat(4 - i * 2));
                System.out.println(star.repeat(1 + i * 4));
            }
        }


        System.out.println();
        System.out.println("Diamond:");
        for (int i = 0; i < 11; i++) {
            if (i >= 6) {
                System.out.print(space.repeat(1 + i - 6));
                System.out.println(star.repeat(21 - 2 * i));
            } else {
                System.out.print(space.repeat(5 - i));
                System.out.println(star.repeat(1 + 2 * i));
            }
        }

    }
}


