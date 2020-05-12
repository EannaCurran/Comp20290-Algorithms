package src.Practical3;
/**
 * Practical 3 - Towers of Hanoi using recursion - 10/2/2020
 */
public class towerOfHanoi {

    /**
     * Implementation to Towers of Hanoi problem using recursion
     * @param disk: Number of disks in the original pile
     * @param source: Name given to first position
     * @param middle: Name given to second position
     * @param destination: Name given to final position
     */
    public static void towersOfHanoi(int disk, char source, char middle, char destination) {

        // Moves disk from start to end position when possible
        if (disk == 0) {
            System.out.println(source + " to " + destination);

        } else {

            // Recursively moves disks from start to middle
            towersOfHanoi(disk - 1, source, destination, middle);

             System.out.println(source + " to " + destination);

            // Recursively moves disks from middle to end
            towersOfHanoi(disk - 1, middle, source, destination);
        }


    }

    public static void towersOfHanoiTiming(){
        int n = 1;
        while(n <= 30){
            final long startTime = System.nanoTime();
            towersOfHanoi(n, 'A', 'B', 'C');
            final long elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed time for size  "+n+" : " +elapsedTime);
            n++;
        }
    }

    public static void main(String[] args) {
        towersOfHanoiTiming();
    }
}
