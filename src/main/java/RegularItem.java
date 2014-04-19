public class RegularItem extends Item implements CalculationItem {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void calculate() {
        if (ItemHelper.isQualityGreaterThanZero(this)) {
            setQuality(getQuality() - 1);

            setSellIn(getSellIn() - 1);

            if (ItemHelper.isSellInLessThan(0, this))
                setQuality(getQuality() - 1);
        }
    }
}
