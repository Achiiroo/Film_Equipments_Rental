/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

/**
 *
 * @author dave
 */
public class Equipment {
    private final int itemId;
    private final String brand;
    private final String model;

    public Equipment(int itemId, String brand, String model) {
        this.itemId = itemId;
        this.brand = brand;
        this.model = model;
    }

    public int getItemId() {
        return itemId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
