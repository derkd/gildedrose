public class ConjuredManaCakeItem extends Item implements CalculationItem{

    public ConjuredManaCakeItem() {
        super("Conjured Mana Cake", 3, 6);
    }

    @Override
    public void calculate() {
        this.setQuality(this.getQuality() - 2);
        this.setSellIn(this.getSellIn() - 1);
    }
}
