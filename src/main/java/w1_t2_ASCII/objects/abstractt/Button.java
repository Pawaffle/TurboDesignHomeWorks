package w1_t2_ASCII.objects.abstractt;

public abstract class Button implements AbstractStyle {

    private final String firstLine;
    private final String secondLine;
    private final String thirdLine;


    public Button(String text){
        String horizontal = HORIZONTAL_LINE.repeat(text.length());
        this.firstLine = String.format("%s%s%s", U_L_CORNER, horizontal, U_R_CORNER);
        this.secondLine = String.format("%s %s %s", VERTICAL_LINE, text, VERTICAL_LINE);
        this.thirdLine = String.format("%s%s%s", D_L_CORNER, horizontal, D_R_CORNER);
    };

    public void display(){
        System.out.printf("%s%n%s%n%s%n", firstLine, secondLine, thirdLine);
    };
}