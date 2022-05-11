import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class Otzivy {
    public ArrayList<Otziv> Otzivy = new ArrayList<Otziv>();

    public List<Otziv> Filter(String field, String value) {
        switch (field) {
            case "Звезды":
                try {
                    return Otzivy.stream().filter(p -> p.Stars==Integer.parseInt(value)).collect(Collectors.toList());
                } catch (Exception e) {
                    return Otzivy;
                }
            case "Отзыв":
                return Otzivy.stream().filter(p -> p.Otziv.compareTo(value) == 0).collect(Collectors.toList());
            case "Артикул":
                try {
                    return Otzivy.stream().filter(p -> p.Code==Integer.parseInt(value)).collect(Collectors.toList());
                } catch (Exception e) {
                    return Otzivy;
                }
            default:
                return Otzivy;
        }
    }
}
