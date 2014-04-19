public class ItemHelper {

    public static boolean isQualityGreaterThanZero(CalculationItem item) {
        return item.getQuality() > 0;
    }

    public static boolean isQualityLessThan50(CalculationItem item) {
        return item.getQuality() < 50;
    }

    public static boolean isSellInLessThan(int days, CalculationItem item) {
        return item.getSellIn() < days;
    }
}
