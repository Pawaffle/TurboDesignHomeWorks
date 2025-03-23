package w1_t2_ASCII.objects.abstractt;

public abstract class TextField implements AbstractStyle{
    private final String firstLine;
    private final String secondLine;
    private final String thirdLine;

    public TextField(int width){
        String horizontal = HORIZONTAL_LINE.repeat(width);
        String space = " ".repeat(width);

        this.firstLine = String.format("%s%s%s", U_L_CORNER, horizontal, U_R_CORNER);
        this.secondLine = String.format("%s %s %s", VERTICAL_LINE, space, VERTICAL_LINE);
        this.thirdLine = String.format("%s%s%s", D_L_CORNER, horizontal, D_R_CORNER);
    };

    public void display(){
        System.out.printf("%s%n%s%n%s%n", firstLine, secondLine, thirdLine);
    };
}
