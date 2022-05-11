public class Item {
    String Product;
    int Cost;
    int Code;
    int Count;
    boolean Sale;

    public Item(String product, int cost, int code, int count, boolean sale) {
        this.Product = product;
        this.Cost = cost;
        this.Code = code;
        this.Count = count;
        this.Sale = sale;
    }

    @Override
    public String toString() {
        return Product + " " + Cost + " " + Code + " " + Count + " " + Sale;
    }
}
