import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            KnapsackOptimalValue knapsack = new KnapsackOptimalValue("H5_a.txt", "H5_c.txt", 330, 11200);
            knapsack.solve();
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }
}