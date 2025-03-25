package w1_t2_ASCII.objects.abstractt;

public abstract class Checkbox{
    private final String firstLine;
    private final String secondLine;

    public Checkbox(Style style){
        this.firstLine = String.format("%s%s%s", style.U_L_CORNER, style.HORIZONTAL_LINE.repeat(2),  style.U_R_CORNER);
        this.secondLine = String.format("%s%s%s", style.D_L_CORNER, style.HORIZONTAL_LINE.repeat(2), style.D_R_CORNER);
    };

    public void display(){
        System.out.println(firstLine);
        System.out.println(secondLine);
    }
}
