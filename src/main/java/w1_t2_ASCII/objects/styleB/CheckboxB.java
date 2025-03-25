package w1_t2_ASCII.objects.styleB;

import w1_t2_ASCII.objects.abstractt.Checkbox;
import w1_t2_ASCII.objects.abstractt.Style;

public class CheckboxB extends Checkbox{

    public CheckboxB() {
        Style myStyle = new StyleB();
        super(myStyle);
    }
}
