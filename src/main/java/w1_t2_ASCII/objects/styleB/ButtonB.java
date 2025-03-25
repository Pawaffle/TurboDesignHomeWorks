package w1_t2_ASCII.objects.styleB;

import w1_t2_ASCII.objects.abstractt.Button;
import w1_t2_ASCII.objects.abstractt.Style;

public class ButtonB extends Button{

    public ButtonB(String text) {
        Style myStyle = new StyleB();
        super(text, myStyle);
    }
}
