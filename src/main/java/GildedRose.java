import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private List<CalculationItem> items = null;

    public GildedRose() {
        initializeItems();
    }

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        GildedRose gd = new GildedRose();
        gd.updateQuality();
    }

    private void initializeItems() {
        items = new ArrayList<CalculationItem>();
        items.add(new RegularItem("+5 Dexterity Vest", 10, 20));
        items.add(new AgedBrieItem());
        items.add(new RegularItem("Elixir of the Mongoose", 5, 7));
        items.add(new SulfurasItem());
        items.add(new BackStagePassItem());
        items.add(new ConjuredManaCakeItem());
    }

    public void updateQuality() {
        for (CalculationItem item : items) {
            item.calculate();
            calculateSellIn(item);
        }
    }

    private static boolean isNot(CalculationItem item, String agedBrie) {
        return !is(item, agedBrie);
    }

    private static boolean is(CalculationItem item, String backstage) {
        return backstage.equals(item.getName());
    }

    private void calculateSellIn(CalculationItem item) {

        if (item.getSellIn() < 0) {
            if (isNot(item, "Aged Brie")) {
                if (isNot(item, "Backstage passes to a TAFKAL80ETC concert")) {
                    if (isQualityGreaterThanZero(item)) {
                        if (isNot(item, "Sulfuras, Hand of Ragnaros")) {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                } else {
                    item.setQuality(0);
                }
            } else {
                if (isQualityLessThan50(item)) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

    private static boolean isQualityGreaterThanZero(CalculationItem item) {
        return item.getQuality() > 0;
    }

    private static boolean isQualityLessThan50(CalculationItem item) {
        return item.getQuality() < 50;
    }

    public List<CalculationItem> getItems() {
        return items;
    }
}