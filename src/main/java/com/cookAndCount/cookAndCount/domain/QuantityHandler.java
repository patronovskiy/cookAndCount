package com.cookAndCount.cookAndCount.domain;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

public class QuantityHandler {

    public static double parseQuantity(String stringQuantity) {
        double quantity = -1;
        try {
            String handledString = stringQuantity.replace(",", ".");
            System.out.println(handledString);
            quantity = Double.parseDouble(handledString);
        } catch (java.lang.NumberFormatException ex) {
            System.out.println("неверный формат входных данных");
            //todo всплывающее окно о неверном формате данных
        }
        return quantity;
    }
}
