public class RegularItem extends Item implements CalculationItem {
    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void calculate() {
        if (quality > 0) {
            this.setQuality(this.getQuality() - 1);
        }
        this.setSellIn(this.getSellIn() - 1);
    }
}
