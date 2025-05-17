public class TipCalculator {
    public static void main(String[] args) {
        int[] totalCost = {2000, 1000, 500, 500};
        System.out.println(calculateTipAmount(totalCost, 80));
    }

    public static int calculateCosts(int[] totalCost) {
        int costs = 0;
        for (int cost : totalCost) {
            costs += cost;
        }
        return costs;
    }

    public static boolean isTipValid(int tip) {
        return tip <= 80 && tip >= 10;
    }

    public static int calculateTipAmount(int[] costs, int tipPercentage) {
        if (isTipValid(tipPercentage)) {
            return (calculateCosts(costs) * tipPercentage) / 100;
        } else {
            return -1;
        }
    }
}