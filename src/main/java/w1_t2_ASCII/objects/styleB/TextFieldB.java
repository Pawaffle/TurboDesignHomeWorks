package w1_t2_ASCII.objects.styleB;

import w1_t2_ASCII.objects.abstractt.Style;
import w1_t2_ASCII.objects.abstractt.TextField;

public class TextFieldB extends TextField{

    public TextFieldB(int width) {
        Style myStyle = new StyleB();
        super(width, myStyle);
    }
}
