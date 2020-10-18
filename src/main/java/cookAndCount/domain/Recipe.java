package cookAndCount.domain;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

public class Recipe {
    private int recipeId;

    private String recipeName;

    private double sumCalories;
    private double sumProtein;
    private double sumFat;
    private double sumCarbohydrates;

    private String description;

    ArrayList<FoodItem> foodItemsList;

    public Recipe() {
        this.foodItemsList = getFoodItems();
        getSumCount(this.foodItemsList);
    }

    public Recipe(final int recipeId, final String recipeName) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.foodItemsList = getFoodItems();
        getSumCount(this.foodItemsList);
    }

    //todo где хранится количество каждого продукта?
    //todo подумать как пробрасывать объект продукта пользователю
    private ArrayList<FoodItem> getFoodItems() {

        ArrayList<FoodItem> itemsList = new ArrayList<FoodItem>();

        Scanner in = new Scanner(System.in);
        int itemId = 0;
        do {
            itemId++;
            System.out.println("Введите продукт: ");
            String foodItemName = in.nextLine();
            System.out.println("введите кол-во продукта");
            double quantity = in.nextDouble();
            System.out.println("введите кол-во ккал на 100 г");
            double ccal = in.nextDouble();
            System.out.println("введите кол-во белков на 100 г");
            double protein = in.nextDouble();
            System.out.println("введите кол-во жиров на 100 г");
            double fat = in.nextDouble();
            System.out.println("введите кол-во углеводов на 100 г");
            double carbohydrates = in.nextDouble();

            itemsList.add(new FoodItem(itemId, foodItemName, ccal, protein, fat, carbohydrates, quantity));
            System.out.println("Для завершения введите q");
            if (in.nextLine().equals("q")){
                break;
            }
        } while (!in.nextLine().equals("q"));

        return itemsList;
    }

    @Override
    public String toString() {
        return "Название рецепта: " + this.recipeName +
            "\nКБЖУ на 100 г: " + this.sumCalories + "/" + this.sumProtein +
            "/" + this.sumFat + "/" + this.sumCarbohydrates;
    }

    //todo округление
    //присваивает полям рецепта КБЖУ значения
    private void getSumCount(ArrayList<FoodItem> itemsList) {

        this.sumCalories = 0;
        this.sumCarbohydrates = 0;
        this.sumFat = 0;
        this.sumProtein = 0;

        for (FoodItem foodItem : itemsList) {
            this.sumCalories += ((foodItem.getCalories() / 100)*foodItem.getQuantity());
            this.sumCarbohydrates += ((foodItem.getCarbohydrates() / 100)*foodItem.getQuantity());
            this.sumFat += ((foodItem.getFat() / 100)*foodItem.getQuantity());
            this.sumProtein += ((foodItem.getProtein() / 100)*foodItem.getQuantity());
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(final int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(final String recipeName) {
        this.recipeName = recipeName;
    }

    public ArrayList<FoodItem> getFoodItemsList() {
        return foodItemsList;
    }

    public void setFoodItemsList(final ArrayList<FoodItem> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }
}
