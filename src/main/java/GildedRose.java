import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private List<Item> items = null;

    public GildedRose() {
        initializeItems();
    }

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        GildedRose gd = new GildedRose();
        gd.updateQuality();
    }

    private void initializeItems() {
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    public void updateQuality() {
        for (Item item : items) {
            calculateQuality(item);
            calculateSellIn(item);
        }
    }

    private void calculateQuality(Item item) {
        if (isNot(item, "Aged Brie") && isNot(item, "Backstage passes to a TAFKAL80ETC concert")) {
            if (item.getQuality() > 0) {
                if (isNot(item, "Sulfuras, Hand of Ragnaros")) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        } else {
            if (isQualityLessThan50(item)) {
                item.setQuality(item.getQuality() + 1);

                if (is(item, "Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.getSellIn() < 11) {
                        if (isQualityLessThan50(item)) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }

                    if (item.getSellIn() < 6) {
                        if (isQualityLessThan50(item)) {
                            item.setQuality(item.getQuality() + 1);
                        }
                    }
                }
            }
        }

        if (is(item, "Conjured Mana Cake")) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private static boolean isNot(Item item, String agedBrie) {
        return !is(item, agedBrie);
    }

    private static boolean is(Item item, String backstage) {
        return backstage.equals(item.getName());
    }

    private void calculateSellIn(Item item) {
        if (isNot(item, "Sulfuras, Hand of Ragnaros")) {
            item.setSellIn(item.getSellIn() - 1);
        }

        if (item.getSellIn() < 0) {
            if (isNot(item, "Aged Brie")) {
                if (isNot(item, "Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.getQuality() > 0) {
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

    private static boolean isQualityLessThan50(Item item) {
        return item.getQuality() < 50;
    }

    public List<Item> getItems() {
        return items;
    }
}