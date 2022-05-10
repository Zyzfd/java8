public class Otziv {
    int Stars;
    int Code;
    String Otziv;

    public Otziv(int stars, String otziv, int code) {
        this.Stars = stars;
        this.Otziv = otziv;
        this.Code = code;
    }

    @Override
    public String toString() {
        return Stars + " " + Otziv + " " + Code;
    }
}
