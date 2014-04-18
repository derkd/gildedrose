public interface CalculationItem {
    void calculate();

    String getName();

    int getSellIn();

    int getQuality();

    void setSellIn(int sellIn);

    void setQuality(int quality);
}
