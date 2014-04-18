import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GildedRoseTest {

    private GildedRose gd;
    private List<CalculationItem> items;

    @Before
    public void setUp() throws Exception {
        gd = new GildedRose();
        items = gd.getItems();
    }

    @Test
    public void should_decrease_quality_and_sell_in_by_1_for_plus5_Dexterity_Vest_after_one_day() throws Exception {
        gd.updateQuality();

        CalculationItem selectedItem = getItem("+5 Dexterity Vest");
        assertThat(selectedItem.getQuality(), is(19));
        assertThat(selectedItem.getSellIn(), is(9));
    }

    @Test
    public void should_decrease_quality_twice_as_fast_when_sell_in_date_has_passed_for_plus5_Dexterity_Vest() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 11);

        CalculationItem selectedItem = getItem("+5 Dexterity Vest");
        assertThat(selectedItem.getQuality(), is(8));
        assertThat(selectedItem.getSellIn(), is(-1));
    }

    @Test
    public void should_decrease_quality_and_sell_in_by_1_for_Elixir_of_the_Mongoose_after_one_day() throws Exception {
        gd.updateQuality();

        CalculationItem selectedItem = getItem("Elixir of the Mongoose");
        assertThat(selectedItem.getQuality(), is(6));
        assertThat(selectedItem.getSellIn(), is(4));
    }

    @Test
    public void should_decrease_quality_twice_as_fast_when_sell_in_date_has_passed_for_Elixir_of_the_Mongoose() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 6);

        CalculationItem selectedItem = getItem("Elixir of the Mongoose");
        assertThat(selectedItem.getQuality(), is(0));
        assertThat(selectedItem.getSellIn(), is(-1));
    }

    @Test
    public void should_increase_in_quality_the_older_it_gets_for_Aged_Brie() throws Exception {
        gd.updateQuality();

        CalculationItem selectedItem = getItem("Aged Brie");
        assertThat(selectedItem.getQuality(), is(1));
        assertThat(selectedItem.getSellIn(), is(1));
    }

    @Test
    public void should_increase_quality_by_2_when_sell_in_date_is_passed_for_Aged_Brie() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 6);

        CalculationItem selectedItem = getItem("Aged Brie");
        assertThat(selectedItem.getQuality(), is(10));
        assertThat(selectedItem.getSellIn(), is(-4));
    }

    @Test
    public void should_never_exceeds_quality_of_50_for_Aged_Brie() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 27);

        CalculationItem selectedItem = getItem("Aged Brie");
        assertThat(selectedItem.getQuality(), is(50));
        assertThat(selectedItem.getSellIn(), is(-25));
    }

    @Test
    public void should_never_increase_or_decrease_quality_for_Sulfuras_Hand_of_Ragnaros() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 10);

        CalculationItem selectedItem = getItem("Sulfuras, Hand of Ragnaros");
        assertThat(selectedItem.getQuality(), is(80));
        assertThat(selectedItem.getSellIn(), is(0));
    }

    @Test
    public void should_increase_quality_by_2_when_only_10_days_are_left_for_Backstage_passes_to_a_TAFKAL80ETC_concert() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 6);

        CalculationItem selectedItem = getItem("Backstage passes to a TAFKAL80ETC concert");
        assertThat(selectedItem.getQuality(), is(27));
        assertThat(selectedItem.getSellIn(), is(9));
    }

    @Test
    public void should_increase_quality_by_3_when_only_5_days_are_left_for_Backstage_passes_to_a_TAFKAL80ETC_concert() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 11);

        CalculationItem selectedItem = getItem("Backstage passes to a TAFKAL80ETC concert");
        assertThat(selectedItem.getQuality(), is(38));
        assertThat(selectedItem.getSellIn(), is(4));
    }

    @Test
    public void should_drop_quality_when_convert_is_over_for_Backstage_passes_to_a_TAFKAL80ETC_concert() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 16);

        CalculationItem selectedItem = getItem("Backstage passes to a TAFKAL80ETC concert");
        assertThat(selectedItem.getQuality(), is(0));
        assertThat(selectedItem.getSellIn(), is(-1));
    }

    @Test
    public void should_never_exceeds_quality_of_50_for_Backstage_passes_to_a_TAFKAL80ETC_concert() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 15);

        CalculationItem selectedItem = getItem("Backstage passes to a TAFKAL80ETC concert");
        assertThat(selectedItem.getQuality(), is(50));
        assertThat(selectedItem.getSellIn(), is(0));
    }

    @Test
    public void should_decrease_quality_twice_as_for_Conjured_Mana_Cake() throws Exception {
        callUpdateQualityAmountOfTimes(gd, 1);

        CalculationItem selectedItem = getItem("Conjured Mana Cake");
        assertThat(selectedItem.getQuality(), is(4));
        assertThat(selectedItem.getSellIn(), is(2));
    }

    private void callUpdateQualityAmountOfTimes(GildedRose gd, int calls) {
        for (int i = 0; i < calls; i++)
            gd.updateQuality();
    }

    private CalculationItem getItem(String name) {
        for (CalculationItem item : items) {
            if (item.getName().equals(name))
                return item;
        }
        return null;
    }
}
