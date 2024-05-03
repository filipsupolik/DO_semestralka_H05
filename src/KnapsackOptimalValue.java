import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KnapsackOptimalValue {
    private int capacity;
    private int maxItems;
    private int[] weights;
    private int[] values;
    private int itemCount;

    public KnapsackOptimalValue(String weightFile, String valueFile, int maxItems, int capacity) throws IOException {
        this.maxItems = maxItems;
        this.capacity = capacity;
        this.loadData(weightFile, valueFile);
    }

    private void loadData(String weightFile, String valueFile) throws IOException {
        List<Integer> weightList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(weightFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                weightList.add(Integer.parseInt(line.trim()));
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(valueFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                valueList.add(Integer.parseInt(line.trim()));
            }
        }

        this.itemCount = weightList.size();
        this.weights = weightList.stream().mapToInt(i -> i).toArray();
        this.values = valueList.stream().mapToInt(i -> i).toArray();
    }
    public void solve() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < this.itemCount; i++) {
            items.add(new Item(this.weights[i], this.values[i], i));
        }

        items.sort((a, b) -> Double.compare(b.getValuePerWeight(), a.getValuePerWeight()));

        int currentWeight = 0;
        int currentValue = 0;
        int itemsSelected = 0;

        for (Item item : items) {
            if (currentWeight + item.getWeight() <= this.capacity && itemsSelected < this.maxItems) {
                currentWeight += item.getWeight();
                currentValue += item.getValue();
                itemsSelected++;
            }
        }

        System.out.println("ucelova funkcia: " + currentValue);
        System.out.println("Hmotnost batohu: " + currentWeight);
        System.out.println("Pocet predmetov v batohu: " + itemsSelected);

    }
}