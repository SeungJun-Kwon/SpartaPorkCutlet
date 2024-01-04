package Menu;
import Product.Product;

import java.util.ArrayList;
import java.util.List;

public class DetailMenu extends Menu {
    List<Product> productList;

    public DetailMenu(String name, String desc) {
        super(name, desc);
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }
}
