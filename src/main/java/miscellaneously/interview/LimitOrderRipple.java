package src.miscellaneously.interview;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Function Signature
//double calculateXrpQuote(LimitOrders[] orders, double usdAmount);

//Input 
//sellOrders = [
//LimitOrder(0.25, 10.00),   2.50
//LimitOrder(0.75, 5.00),   6
//LimitOrder(0.50, 20.00),
//];
//calculateXrpQuote(sellOrders, 1.25);  // 5.0

//Note the Following Requirements:
//The function should raise an error or an exception if there is insufficient XRP for sale for the USD amount provided.
//The function should not accept zero or negative amounts.
//You may purchase all or a portion of the XRP for sale in a given order.
//You must purchase all of the XRP for a given order before moving on to the next.

public class LimitOrderRipple {

    public static void main(String[] args) {
        LimitOrderRipple limitOrder = new LimitOrderRipple();

        LimitOrders[] orders = new LimitOrders[3];
        orders[0] = new LimitOrders(0.50, 10.00);
        orders[1] = new LimitOrders(0.75, 5.00);
        orders[2] = new LimitOrders(0.25, 10.00);

        System.out.println(limitOrder.calculateXrpQuote(orders, 5.0d));
    }

    double calculateXrpQuote(LimitOrders[] orders, double usdAmount) {

        if (orders == null || orders.length == 0 || usdAmount <= 0.0d)
            return 0.0d;

        Queue<LimitOrders> priorityOrders = new PriorityQueue<LimitOrders>(new LimitOrdersComparator());

        for (LimitOrders order : orders) {
            priorityOrders.add(order);
        }
        double qty = 0.0d;

        while (!priorityOrders.isEmpty()) {

            LimitOrders queueOrder = priorityOrders.poll();
            double amount = queueOrder.price * queueOrder.qty;

            if (usdAmount > amount) {
                qty += queueOrder.qty;
                usdAmount -= amount;
            } else {
                qty += usdAmount / queueOrder.price;
                return qty;
            }
        }
        return qty;
    }

}

class LimitOrders {
    double price;
    double qty;

    LimitOrders(double price, double qty) {
        this.price = price;
        this.qty = qty;
    }
}

class LimitOrdersComparator implements Comparator<LimitOrders> {

    @Override
    public int compare(LimitOrders o1, LimitOrders o2) {
        // TODO Auto-generated method stub
        if (o1.price < o2.price)
            return -1;
        else if (o1.price == o2.price)
            return 0;
        else
            return 1;

    }

}
