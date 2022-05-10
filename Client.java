public class Client {
    public String FIO;
    public String Nikname;
    public String Sity;
    public String Email;
    public long Phone;

    public Client(String fio, String nikname, String sity, String email, long phone) {
        this.FIO = fio;
        this.Nikname = nikname;
        this.Sity = sity;
        this.Email = email;
        this.Phone = phone;
    }

    @Override
    public String toString() {
        return FIO + " " + Nikname + " " + Sity + " " + Email + " " + Phone;
    }
}