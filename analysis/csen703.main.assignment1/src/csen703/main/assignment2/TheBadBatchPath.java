package csen703.main.assignment2;

import java.util.ArrayList;

public class TheBadBatchPath {
	
    public static Integer TatooineToNabooDP(int[] fuel) {	
    	 if (fuel.length == 0 || fuel.length==1 || fuel[0]==0) {
 	        return 0;
 	 }
    	 
    	 int n = fuel.length;
    	    int[] minLandings = new int[n];

    	    for (int i = 1; i < n; i++) {
    	        minLandings[i] = Integer.MAX_VALUE;
    	    }

    	    minLandings[0] = 0;

    	    for (int i = 0; i < n; i++) {
    	        if (minLandings[i] != Integer.MAX_VALUE) {
    	            for (int j = i + 1; j <= Math.min(i + fuel[i], n - 1); j++) {
    	                minLandings[j] = Math.min(minLandings[j], minLandings[i] + 1);
    	            }
    	        }//else {
    	        	//return 0;
    	        //}
    	    }
    	    if (minLandings[n - 1] == Integer.MAX_VALUE) {
    	    	return -1;
    	    }
    	    return minLandings[n - 1];
    	}

    public static ArrayList<Integer> TatooineToNabooPath(int[] fuel) {
        if (fuel.length == 0) {
            return new ArrayList<>();
        }

        if (fuel.length == 1 || fuel[0] == 0) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(0);
            return path;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int n = fuel.length;
        int[] minLandings = new int[n];
        int[] prevPlanet = new int[n];

        for (int i = 0; i < n; i++) {
            minLandings[i] = Integer.MAX_VALUE;
            prevPlanet[i] = -1;
        }

        minLandings[0] = 0;

        for (int i = 0; i < n; i++) {
            if (minLandings[i] != Integer.MAX_VALUE) {
                for (int j = i + 1; j <= Math.min(i + fuel[i], n - 1); j++) {
                    if (minLandings[j] > minLandings[i] + 1) {
                        minLandings[j] = minLandings[i] + 1;
                        prevPlanet[j] = i;
                    }
                }
            }
        }

        int currentPlanet = n - 1;
        if (minLandings[currentPlanet] == Integer.MAX_VALUE) {
            // No valid path found
            return new ArrayList<>();
        }

        while (currentPlanet != -1) {
            path.add(currentPlanet);
            currentPlanet = prevPlanet[currentPlanet];
        }

        ArrayList<Integer> reversedPath = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            reversedPath.add(path.get(i));
        }

        return reversedPath;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] alliesFuel = {2,1,1,1,4};

        // Testing Dynamic Programming
        Integer minLandings = TatooineToNabooDP(alliesFuel);
        System.out.println("Minimum number of landings: " + minLandings);

        // Testing Path Reconstruction
        ArrayList<Integer> path = TatooineToNabooPath(alliesFuel);
        System.out.println("Minimum path: " + path);
    }
	
}