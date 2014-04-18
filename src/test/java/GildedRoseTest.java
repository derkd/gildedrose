import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;


public class GildedRoseTest {

    @Test
    public void shouldCreateInstance() throws Exception {
        GildedRose gd = new GildedRose();

        assertThat(gd, is(instanceOf(GildedRose.class)));
    }

    @Test
    public void should_decrease_quality_and_sell_in_by_1_for_plus5_Dexterity_Vest_after_one_day() throws Exception {
        GildedRose gd = new GildedRose();

        gd.updateQuality();

        List<Item> items = gd.getItems();
        Item selectedItem = getItem(items, "+5 Dexterity Vest");
        assertThat(selectedItem.getQuality(), is(19));
        assertThat(selectedItem.getSellIn(), is(9));
    }

    @Test
    public void should_decrease_quality_twice_as_fast_when_sell_in_date_has_passed_for_plus5_Dexterity_Vest() throws Exception {
        GildedRose gd = new GildedRose();

        callUpdateQualityAmountOfTimes(gd, 11);

        List<Item> items = gd.getItems();
        Item selectedItem = getItem(items, "+5 Dexterity Vest");
        assertThat(selectedItem.getQuality(), is(8));
        assertThat(selectedItem.getSellIn(), is(-1));
    }

    @Test
    public void should_decrease_quality_and_sell_in_by_1_for_Elixir_of_the_Mongoose_after_one_day() throws Exception {
        GildedRose gd = new GildedRose();

        gd.updateQuality();

        List<Item> items = gd.getItems();
        Item selectedItem = getItem(items, "Elixir of the Mongoose");
        assertThat(selectedItem.getQuality(), is(6));
        assertThat(selectedItem.getSellIn(), is(4));
    }

    @Test
    public void should_decrease_quality_twice_as_fast_when_sell_in_date_has_passed_for_Elixir_of_the_Mongoose() throws Exception {
        GildedRose gd = new GildedRose();

        callUpdateQualityAmountOfTimes(gd, 6);

        List<Item> items = gd.getItems();
        Item selectedItem = getItem(items, "Elixir of the Mongoose");
        assertThat(selectedItem.getQuality(), is(0));
        assertThat(selectedItem.getSellIn(), is(-1));
    }

    private void callUpdateQualityAmountOfTimes(GildedRose gd, int calls) {
        for (int i = 0; i < calls; i++)
            gd.updateQuality();
    }

    private Item getItem(List<Item> items, String name) {
        for (Item item : items) {
            if (item.getName().equals(name))
                return item;
        }
        return null;
    }
}
