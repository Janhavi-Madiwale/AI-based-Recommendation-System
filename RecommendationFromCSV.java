import java.io.*;
import java.util.*;

public class RecommendationFromCSV {

    static int[][] ratings;
    static int numUsers;
    static int numItems;

    public static void main(String[] args) {
        try {
            ratings = loadRatingsFromCSV("ratings.csv");
            numUsers = ratings.length;
            numItems = ratings[0].length;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Available Users:");
            for (int i = 0; i < numUsers; i++) {
                System.out.println("User " + i);
            }

            System.out.print("\nEnter user ID to get recommendations (0 to " + (numUsers - 1) + "): ");
            int userId = scanner.nextInt();

            System.out.println("\nFetching recommendations for User " + userId + "...\n");
            List<Integer> recommendedItems = getRecommendations(userId);

            if (recommendedItems.isEmpty()) {
                System.out.println("No recommendations available.");
            } else {
                System.out.println("Recommended Items for User " + userId + ":");
                for (int item : recommendedItems) {
                    System.out.println("Item " + item);
                }
            }
            scanner.close();
             
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Load ratings from a CSV file
    public static int[][] loadRatingsFromCSV(String fileName) throws IOException {
        List<int[]> rows = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int[] row = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                row[i] = Integer.parseInt(values[i].trim());
            }
            rows.add(row);
        }

        br.close();
        return rows.toArray(new int[0][]);
    }

    // Recommend unrated items based on similarity
    public static List<Integer> getRecommendations(int userId) {
        double[] similarity = new double[numUsers];
        for (int other = 0; other < numUsers; other++) {
            if (other != userId) {
                similarity[other] = cosineSimilarity(ratings[userId], ratings[other]);
                System.out.printf("Similarity with User %d: %.2f\n", other, similarity[other]);
            }
        }

        double[] scores = new double[numItems];
        for (int item = 0; item < numItems; item++) {
            if (ratings[userId][item] == 0) {
                for (int other = 0; other < numUsers; other++) {
                    scores[item] += similarity[other] * ratings[other][item];
                }
            }
        }

        List<Integer> recommended = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int bestItem = -1;
            double bestScore = -1;
            for (int item = 0; item < numItems; item++) {
                if (ratings[userId][item] == 0 && scores[item] > bestScore && !recommended.contains(item)) {
                    bestScore = scores[item];
                    bestItem = item;
                }
            }
            if (bestItem != -1) {
                recommended.add(bestItem);
            }
        }

        return recommended;
    }

    public static double cosineSimilarity(int[] a, int[] b) {
        double dot = 0, normA = 0, normB = 0;
        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            normA += a[i] * a[i];
            normB += b[i] * b[i];
        }
        return (normA == 0 || normB == 0) ? 0 : dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
