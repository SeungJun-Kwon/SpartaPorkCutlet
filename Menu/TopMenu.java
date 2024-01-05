package Menu;
import java.util.ArrayList;
import java.util.List;

public class TopMenu extends Menu {
    List<DetailMenu> childMenuList;

    public TopMenu(String name, String desc) {
        super(name, desc);
        childMenuList = new ArrayList<>();
    }

    public List<DetailMenu> getChildMenuList() {
        return childMenuList;
    }

    public void addChildMenu(DetailMenu childMenu) {
        childMenuList.add(childMenu);
    }

    public void removeChildMenu(DetailMenu childMenu) {
        childMenuList.remove(childMenu);
    }
}
