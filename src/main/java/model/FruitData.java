package model;

public class FruitData {
    private Type type;
    private String fruit;
    private String date;
    private int quantity;

    public FruitData(Type type, String fruit, int quantity, String date) {
        this.type = type;
        this.fruit = fruit;
        this.quantity = quantity;
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
