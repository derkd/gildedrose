public class BackStagePassItem extends Item implements CalculationItem {

    public BackStagePassItem() {
        super("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    }

    @Override
    public void calculate() {
        if (quality < 50) {
            setQuality(getQuality() + 1);

            if (getSellIn() < 11) {
                if (quality < 50) {
                    setQuality(getQuality() + 1);
                }
            }

            if (getSellIn() < 6) {
                if (quality < 50) {
                    setQuality(getQuality() + 1);
                }
            }

        }

        setSellIn(getSellIn() - 1);
        if (sellIn < 0)
            setQuality(0);
    }
}
