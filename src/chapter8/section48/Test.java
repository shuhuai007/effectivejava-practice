package chapter8.section48;

import java.math.BigDecimal;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
         double funds = 1.00;
         int itemsBought = 0;
         for (double price = .10; funds >= price; price += .10) {
         funds -= price;
         itemsBought++;
         }
         System.out.println(itemsBought + " items bought.");
         System.out.println("Change: $" + funds);
        

        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBoughtA = 0;
        BigDecimal fundsa = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; fundsa.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            itemsBoughtA++;
            fundsa = fundsa.subtract(price);
        }
        System.out.println(itemsBoughtA + " items bought.");
        System.out.println("Money left over: $" + fundsa);
        
        System.out.println(Integer.MAX_VALUE);
    }

}
