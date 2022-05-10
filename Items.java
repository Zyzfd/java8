import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class Items {
    public ArrayList<Item> Items = new ArrayList<Item>();

    public Object[] to_String() {
        return Items.toArray();
    }

    public List<Item> Filter(String field, String value) {
        switch (field) {
            case "Название":
                return Items.stream().filter(p -> p.Product.compareTo(value) == 0).collect(Collectors.toList());
            case "Стоимость":
                try {
                    return Items.stream().filter(p -> p.Cost==Integer.parseInt(value)).collect(Collectors.toList());
                } catch (Exception e) {
                    return Items;
                }
            case "Артикул":
                try {
                    return Items.stream().filter(p -> p.Code==Integer.parseInt(value)).collect(Collectors.toList());
                } catch (Exception e) {
                    return Items;
                }
            case "Количество":
                try {
                    return Items.stream().filter(p -> p.Count==Integer.parseInt(value)).collect(Collectors.toList());
                } catch (Exception e) {
                    return Items;
                }
            case "Скидочный?":
                try {
                    return Items.stream().filter(p -> p.Sale==Boolean.parseBoolean(value)).collect(Collectors.toList());
                } catch (Exception e) {
                    return Items;
                }
            default:
                return Items;
        }
    }
}
