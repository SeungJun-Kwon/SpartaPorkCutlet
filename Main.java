import Data.RestaurantData;
import Menu.DetailMenu;
import Menu.TopMenu;
import Menu.Menu;
import Product.Product;

import java.util.*;

import static Data.RestaurantData.restaurantName;
import static Data.RestaurantData.topMenuList;

public class Main {
    static Map<Integer, Menu> controlKiosk = new HashMap<Integer, Menu>();
    static RestaurantData rd;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        rd = new RestaurantData();
        rd.Init();

        ShowMain();
    }

    static void ShowMain() {
        System.out.println("\"" + restaurantName + "에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        int index = 1;
        controlKiosk.clear();

        for(TopMenu topMenu : topMenuList) {
            System.out.println("\n[ " + topMenu.getName() + " ]");
            for(DetailMenu detailMenu : topMenu.getChildMenuList()) {
                System.out.printf("%d. %-30s | %-50s\n", index, detailMenu.getName(), detailMenu.getDesc());
                controlKiosk.put(index, detailMenu);
                index++;
            }
        }

        String input = sc.nextLine();
        ShowDetail(Integer.parseInt(input));
    }

    static void ShowDetail(int input) {
        System.out.println("\n\"" + restaurantName + "에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 상품를 골라 입력해주세요.");

        DetailMenu detailMenu = (DetailMenu)controlKiosk.get(input);

        System.out.println("[ " + detailMenu.getName() + " ]");

        int index = 1;
        controlKiosk.clear();

        for(Product p : detailMenu.getProductList()) {
            System.out.printf("%d. %-30s | %-10s | %-50s\n", index, p.getName(), p.getPrice().toString(), p.getDesc());
            controlKiosk.put(index, p);
            index++;
        }
    }
}
