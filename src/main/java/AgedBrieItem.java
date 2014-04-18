public class AgedBrieItem extends Item implements CalculationItem{
    public AgedBrieItem() {
        super("Aged Brie", 2, 0);
    }

    @Override
    public void calculate() {
        if (quality < 50) {
            this.setQuality(this.getQuality() + 1);
        }
    }
}
