package w1_t2_ASCII.objects.abstractt;

public abstract class Button {

    private final String firstLine;
    private final String secondLine;
    private final String thirdLine;


    public Button(String text, Style style){
        String horizontal = style.HORIZONTAL_LINE.repeat(text.length() + 2);
        this.firstLine = String.format("%s%s%s", style.U_L_CORNER, horizontal, style.U_R_CORNER);
        this.secondLine = String.format("%s %s %s", style.VERTICAL_LINE, text, style.VERTICAL_LINE);
        this.thirdLine = String.format("%s%s%s", style.D_L_CORNER, horizontal, style.D_R_CORNER);
    }

    public void display(){
        System.out.printf("%s%n%s%n%s%n", firstLine, secondLine, thirdLine);
    }
}