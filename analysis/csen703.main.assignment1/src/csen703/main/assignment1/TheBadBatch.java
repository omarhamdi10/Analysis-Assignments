package csen703.main.assignment1;

/**
 * Write your info here
 * 
 * @Team
 * @name
 * @id 
 * @TutorialNumber
 */


public class TheBadBatch {
	public static boolean TatooineToNabooDivideAndConquer(int[] fuel) {
	    // Check if the array is empty
	    if (fuel.length == 0) {
	        return true; // Empty array, consider it as already at the target
	    }

	    int n = fuel.length;
	    int maxReach = 0;

	    for (int i = 0; i < n; i++) {
	        // Check if the current position is unreachable
	        if (i > maxReach) {
	            return false;
	        }

	        // Update the maximum reachable position
	        maxReach = Math.max(maxReach, i + fuel[i]);

	        // If the maximum reachable position is beyond or at the last index, return true
	        if (maxReach >= n - 1) {
	            return true;
	        }
	    }

	    return false;
	}
	
//    public static boolean TatooineToNabooGreedy(int[] fuel) {
//	    int i = 0;
//		int remainingFuel = 0;
//	    while(i<fuel.length-1) {
//	    	
//	    	remainingFuel=0;
//	    	remainingFuel += fuel[i+1];
//	    	i += remainingFuel;
//	    	
//	    	if (remainingFuel <= 0) {
//	            return false;
//	        }
//	    }
//	    return true;
//	}
	 public static boolean TatooineToNabooGreedy(int[] fuel) {
		    // Check if the array is empty
		    if (fuel.length == 0) {
		        return true; // Empty array, consider it as reachable
		    }

		    int remainingFuel = fuel[0];

		    for (int i = 1; i < fuel.length; i++) {
		        remainingFuel--;

		        if (remainingFuel < 0) {
		            return false;  // Not enough fuel to reach the current planet
		        }

		        remainingFuel = Math.max(remainingFuel, fuel[i]);
		    }

		    return true;
		}
	public static void main(String[] args) {
        // Example usage:
		int[] fuelOnPlanets= {1,2,1,1,4};
        boolean canReachNaboo = TatooineToNabooDivideAndConquer(fuelOnPlanets);
        System.out.println("Can reach Naboo: " + canReachNaboo);
       
        boolean canReachNabooGreedy = TatooineToNabooGreedy(fuelOnPlanets);
        System.out.println("Can reach Naboo (Greedy): " + canReachNabooGreedy);
    }

}