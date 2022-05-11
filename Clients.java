import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

public class Clients {
    public ArrayList<Client> Clients = new ArrayList<Client>();

    public List<Client> Filter(String field, String value) {
        switch (field) {
            case "ФИО":
                return Clients.stream().filter(p -> p.FIO.compareTo(value) == 0).collect(Collectors.toList());
            case "Ник":
                return Clients.stream().filter(p -> p.Nikname.compareTo(value) == 0).collect(Collectors.toList());
            case "Город":
                return Clients.stream().filter(p -> p.Sity.compareTo(value) == 0).collect(Collectors.toList());
            case "Email":
                return Clients.stream().filter(p -> p.Email.compareTo(value) == 0).collect(Collectors.toList());
            case "Телефон":
                try {
                    return Clients.stream().filter(p -> p.Phone==Long.parseLong(value)).collect(Collectors.toList());
                } catch (Exception e) {
                    return Clients;
                }
            default:
                return Clients;
        }
    }
}
