public class BackStagePassItem extends Item implements CalculationItem {

    public BackStagePassItem() {
        super("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    }

    @Override
    public void calculate() {
        if (quality < 50) {
            this.setQuality(this.getQuality() + 1);

            if (this.getSellIn() < 11) {
                if (quality < 50) {
                    this.setQuality(this.getQuality() + 1);
                }
            }

            if (this.getSellIn() < 6) {
                if (quality < 50) {
                    this.setQuality(this.getQuality() + 1);
                }
            }
        }
    }
}
