public class SalaryCalculator {

    private static final double BASE_SALARY = 1000.0;
    private static final int PENALTY_AFTER_THRESHOLD_DAYS_SKIPPED = 15;

    public double multiplierPerDaysSkipped(int daysSkipped) {
        return (daysSkipped > 5) ? 0.15 : 0;
    }

    public int multiplierPerProductsSold(int productsSold) {
        return (productsSold > 20) ? 13 : 10;

    }

    public double bonusForProductSold(int productsSold) {
        return (double) multiplierPerProductsSold(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double calculatedSalary =
            BASE_SALARY - BASE_SALARY * multiplierPerDaysSkipped(daysSkipped) + bonusForProductSold(
                productsSold);
        return calculatedSalary > 2000 ? 2000 : calculatedSalary;
    }
}
