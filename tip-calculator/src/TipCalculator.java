public class TipCalculator {
    public static void main(String[] args) {
        int[] totalCost = {2000, 1000, 500, 500};
        System.out.println(calculateTipAmount(totalCost, 20));
    }

    public static int calculateCosts(int[] cost) {
        int costs = 0;
        for (int j : cost) {
            costs += j;
        }
        return costs;
    }

    public static int calculateTipAmount(int[] costs, int tip) {
        if (tip < 10 || tip > 80) {
            return -1;
        } else {
            return (calculateCosts(costs) * tip) / 100;
        }
    }
}