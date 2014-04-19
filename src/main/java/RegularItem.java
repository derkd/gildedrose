public class RegularItem extends Item implements CalculationItem {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void calculate() {
        if (getQuality() > 0)
            setQuality(getQuality() - 1);

        setSellIn(getSellIn() - 1);

        if (getSellIn() < 0 && getQuality() > 0)
            setQuality(getQuality() - 1);

    }
}
