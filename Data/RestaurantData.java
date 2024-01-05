package Data;

import Menu.DetailMenu;
import Menu.TopMenu;
import Menu.Product;

import java.util.ArrayList;
import java.util.List;

public class RestaurantData {
    public static String restaurantName = "스파르타 돈까스";
    public static List<TopMenu> topMenuList = new ArrayList<>();

    TopMenu mainMenu = new TopMenu("메인 메뉴", "");
    TopMenu addMenu = new TopMenu("추가 메뉴", "");

    DetailMenu porkCutlet = new DetailMenu("돈까스", "바삭바삭한 돈까스");
    DetailMenu soba = new DetailMenu("소바", "소바");
    DetailMenu udon = new DetailMenu("우동", "뜨끈뜨끈한 우동");
    DetailMenu curry = new DetailMenu("카레", "맛있는 카레");

    DetailMenu miniCurry = new DetailMenu("미니 카레라이스", "맛있는 미니 카레");
    DetailMenu miniPorkCutlet = new DetailMenu("미니 돈까스", "바삭바삭한 미니 돈까스");
    DetailMenu shrimpTempura = new DetailMenu("에비텐(새우 튀김)", "새우 튀김");
    DetailMenu miniUdon = new DetailMenu("미니 우동", "뜨끈뜨끈한 미니 우동");

    Product sirloinCutlet = new Product("등심까스", "부드러운 등심으로 만든 돈까스", 10500);
    Product cheeseCutlet = new Product("모짜렐라치즈까스", "쭉 늘어나는 치즈까스", 12900);
    Product shrimpTempuraCutlet = new Product("에비텐모듬까스", "새우튀김과 돈까스", 13900);

    Product mazeSoba = new Product("마제소바", "풍미가 느껴지는 일본식 비빔면", 9900);
    Product karaiMazeSoba = new Product("카라이마제소바", "매운 마제소바", 10500);

    Product eomukUdon = new Product("우동", "깊고 진한 일본식 우동", 7900);
    Product shrimpTempuraUdon = new Product("에비텐우동", "새우튀김이 들어간 일본식 우동", 9900);

    Product mushroomPorkCurry = new Product("머쉬룸포크카레", "버섯향이 느껴지는 부드럽고 진한 카레", 9500);
    Product shrimpTempuraCurry = new Product("에비텐카레", "새우튀김이 들어간 부드럽고 진한 카레", 11500);

    Product p_miniCurry = new Product("미니 카레라이스", "맛있는 미니 카레", 4500);
    Product p_miniPorkCutlet = new Product("미니 돈까스", "바삭바삭한 미니 돈까스", 5500);
    Product p_shrimpTempura = new Product("에비텐(새우 튀김)", "새우 튀김", 3000);
    Product p_miniUdon = new Product("미니 우동", "뜨끈뜨끈한 미니 우동", 4500);

    public void Init() {
        mainMenu.addChildMenu(porkCutlet);
        mainMenu.addChildMenu(soba);
        mainMenu.addChildMenu(udon);
        mainMenu.addChildMenu(curry);

        addMenu.addChildMenu(miniCurry);
        addMenu.addChildMenu(miniPorkCutlet);
        addMenu.addChildMenu(shrimpTempura);
        addMenu.addChildMenu(miniUdon);

        topMenuList.add(mainMenu);
        topMenuList.add(addMenu);

        porkCutlet.addProduct(cheeseCutlet);
        porkCutlet.addProduct(sirloinCutlet);
        porkCutlet.addProduct(shrimpTempuraCutlet);

        soba.addProduct(mazeSoba);
        soba.addProduct(karaiMazeSoba);

        udon.addProduct(eomukUdon);
        udon.addProduct(shrimpTempuraUdon);

        curry.addProduct(mushroomPorkCurry);
        curry.addProduct(shrimpTempuraCurry);

        miniCurry.addProduct(p_miniCurry);
        miniUdon.addProduct(p_miniUdon);
        miniPorkCutlet.addProduct(p_miniPorkCutlet);
        shrimpTempura.addProduct(p_shrimpTempura);
    }
}