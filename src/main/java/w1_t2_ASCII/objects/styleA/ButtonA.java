package w1_t2_ASCII.objects.styleA;

import w1_t2_ASCII.objects.abstractt.Button;
import w1_t2_ASCII.objects.abstractt.Style;

public class ButtonA extends Button{

    public ButtonA(String text) {
        Style myStyle = new StyleA();
        super(text, myStyle);
    }
}
