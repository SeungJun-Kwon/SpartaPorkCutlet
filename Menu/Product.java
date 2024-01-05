package Menu;

import Menu.Menu;

public class Product extends Menu {
    double price;

    public Product(String name, String desc, double price) {
        super(name, desc);
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
