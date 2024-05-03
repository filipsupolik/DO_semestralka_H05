class Item {
    private int weight;
    private int value;
    private double valuePerWeight;
    private int index;

    public Item(int weight, int value, int index) {
        this.weight = weight;
        this.value = value;
        this.valuePerWeight = (double)value / weight;
        this.index = index;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

    public double getValuePerWeight() {
        return this.valuePerWeight;
    }
}
