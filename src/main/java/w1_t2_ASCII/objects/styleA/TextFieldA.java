package w1_t2_ASCII.objects.styleA;

import w1_t2_ASCII.objects.abstractt.Style;
import w1_t2_ASCII.objects.abstractt.TextField;

public class TextFieldA extends TextField{

    public TextFieldA(int width) {
        Style myStyle = new StyleA();
        super(width, myStyle);
    }
}
