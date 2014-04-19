public class BackStagePassItem extends Item implements CalculationItem {

    public BackStagePassItem() {
        super("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    }

    @Override
    public void calculate() {
        if (ItemHelper.isQualityLessThan50(this)) {
            setQuality(getQuality() + 1);

            if (ItemHelper.isSellInLessThan(11, this)) {
                setQuality(getQuality() + 1);
            }

            if (ItemHelper.isSellInLessThan(6, this)) {
                setQuality(getQuality() + 1);
            }
        }

        setSellIn(getSellIn() - 1);

        if (ItemHelper.isSellInLessThan(0, this))
            setQuality(0);
    }
}
