package cookAndCount.domain;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 */

//продукт
public class FoodItem {
    //id должен генерироваться автоматически БД - это первичный ключ
    private int foodItemId;
    private String foodItemName;
    //КБЖУ продукта на 100 г
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

    private double quantity;
    //гликемический индекс - необязательное поле
    private int glycemicIndex;

    public FoodItem() {
    }

    public FoodItem(final int foodItemId, final String foodItemName, final double calories, final double protein,
                    final double fat,
                    final double carbohydrates,
                    final double quantity) {
        this.foodItemId = foodItemId;
        this.foodItemName = foodItemName;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.quantity = quantity;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(final int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(final String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(final double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(final double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(final double fat) {
        this.fat = fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(final double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getGlycemicIndex() {
        return glycemicIndex;
    }

    public void setGlycemicIndex(final int glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(final double quantity) {
        this.quantity = quantity;
    }
}
