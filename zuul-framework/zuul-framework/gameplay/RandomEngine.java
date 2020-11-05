package gameplay;
import java.util.Random;

public class RandomEngine {
     private Random randomEngine;

     public RandomEngine() {
          //Using current system time as seed for the random number generator
          randomEngine = new Random(System.currentTimeMillis());
     }

     public int getRandom(int min, int max) {
          return randomEngine.nextInt(max-min+1)+min;
     }

     public boolean getOutcome(int probabilityOfSuccess) {

          //successPercentage should be an integer between 0 and 100.

          if (probabilityOfSuccess < 0 || probabilityOfSuccess > 100) {
               System.out.println("Error: invalid probability input");
               return false;
          }

          return (getRandom(0, 100) < probabilityOfSuccess);
     }
}