package Product;

import Menu.DetailMenu;

public class Product extends DetailMenu {
    double price;

    public Product(String name, String desc, double price) {
        super(name, desc);
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
