package Kiosk;

import Data.CartData;
import Data.RestaurantData;
import Menu.CancelMenu;
import Menu.DetailMenu;
import Menu.OrderMenu;
import Menu.TopMenu;
import Menu.Menu;
import Menu.Product;

import java.util.*;

import static Data.RestaurantData.restaurantName;
import static Data.RestaurantData.topMenuList;

public class KioskApp {
    static RestaurantData rd;
    static CartData cd;

    OrderMenu orderMenu = new OrderMenu("주문", "장바구니를 확인 후 주문합니다.");
    CancelMenu cancelMenu = new CancelMenu("취소", "진행 중인 주문을 취소합니다.");

    Scanner sc = new Scanner(System.in);
    Map<Integer, Menu> controlKiosk = new HashMap<>();

    public void Init() {
        rd = new RestaurantData();
        rd.Init();
        cd = new CartData();
        cd.ClearCart();
    }

    public void ShowMain() {
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

        System.out.println("\n[ 주문 메뉴 ]");
        System.out.printf("%d. %-30s | %-50s\n", index, orderMenu.getName(), orderMenu.getDesc());
        controlKiosk.put(index++, orderMenu);

        System.out.printf("%d. %-30s | %-50s\n", index, cancelMenu.getName(), cancelMenu.getDesc());
        controlKiosk.put(index, cancelMenu);

        String answer = sc.nextLine();
        switch(controlKiosk.get(Integer.parseInt(answer)).getClass().getSimpleName()) {
            case "DetailMenu":
                ShowDetail(Integer.parseInt(answer));
                break;
            case "OrderMenu":
                ShowOrder();
                break;
            case "CancelMenu":
                ShowCancel();
                break;
        }
    }

    void ShowDetail(int input) {
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

        String answer = sc.nextLine();

        ShowAddCart(Integer.parseInt(answer));
    }

    void ShowAddCart(int input) {
        Product product = (Product)controlKiosk.get(input);
        controlKiosk.clear();

        System.out.printf("\n[ %-30s | %-10s | %-50s ]\n", product.getName(), product.getPrice().toString(), product.getDesc());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t2. 취소");

        String answer = sc.nextLine();

        if(answer.equals("1")) {
            System.out.println(product.getName() + "(이)가 장바구니에 추가되었습니다.");
            cd.AddProductInCart(product);
        }

        ShowMain();
    }

    void ShowOrder() {
        System.out.println("아래와 같이 주문하시겠습니까?");
        controlKiosk.clear();
        double totalPrice = 0;

        System.out.println("\n[ 장바구니 ]");
        for(Product p : cd.GetCart().keySet()) {
            System.out.printf("%-30s | %-10s | %-10s개 | %-50s\n", p.getName(), p.getPrice(), cd.GetCart().get(p), p.getDesc());
            totalPrice += p.getPrice();
        }

        System.out.println("\n[ 가격 ]");
        System.out.println(totalPrice + " 원");

        System.out.println("\n1. 주문 \t 2. 메뉴판");
        String answer = sc.nextLine();

        if(answer.equals("1")) {
            ShowClearOrder();
        }
        else {
            ShowMain();
        }
    }

    void ShowClearOrder() {
        cd.ClearCart();

        System.out.println("주문이 완료되었습니다!");
        System.out.println("(3초 후 메인 화면으로 돌아갑니다.)");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ShowMain();
            }
        };

        timer.schedule(task, 3000);
    }

    void ShowCancel() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인 \t 2. 취소");
        String answer = sc.nextLine();

        if(answer.equals("1")) {
            System.out.println("\n진행하던 주문이 취소되었습니다.");
            cd.ClearCart();
        }
        ShowMain();
    }
}
