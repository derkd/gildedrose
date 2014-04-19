public class AgedBrieItem extends Item implements CalculationItem{
    public AgedBrieItem() {
        super("Aged Brie", 2, 0);
    }

    @Override
    public void calculate() {
        if (ItemHelper.isQualityLessThan50(this))
            setQuality(getQuality() + 1);

        setSellIn(getSellIn() - 1);

        if(ItemHelper.isSellInLessThan(0, this) && ItemHelper.isQualityLessThan50(this))
            setQuality(getQuality() + 1);
    }
}
