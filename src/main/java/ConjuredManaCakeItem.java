public class ConjuredManaCakeItem extends Item implements CalculationItem{

    public ConjuredManaCakeItem() {
        super("Conjured Mana Cake", 3, 6);
    }

    @Override
    public void calculate() {
        if (ItemHelper.isQualityGreaterThanZero(this))
            setQuality(getQuality() - 2);

        setSellIn(getSellIn() - 1);
    }
}
