public class AgedBrieItem extends Item implements CalculationItem{
    public AgedBrieItem() {
        super("Aged Brie", 2, 0);
    }

    @Override
    public void calculate() {
        if (quality < 50) {
            setQuality(getQuality() + 1);
        }
        setSellIn(this.getSellIn() - 1);
        if(getSellIn() < 0 && getQuality() < 50){
            setQuality(getQuality() + 1);
        }
    }
}
