package w1_t2_ASCII.objects.abstractt;

public abstract class Checkbox implements AbstractStyle {
    private final String firstLine;
    private final String secondLine;

    public Checkbox(){
        this.firstLine = String.format("%s%s", U_L_CORNER,  U_R_CORNER);
        this.secondLine = String.format("%s%s", D_L_CORNER, D_R_CORNER);
    };

    public void display(){
        System.out.println(firstLine);
        System.out.println(secondLine);
    }
}
