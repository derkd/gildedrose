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
        }
    }

    public List<CalculationItem> getItems() {
        return items;
    }
}