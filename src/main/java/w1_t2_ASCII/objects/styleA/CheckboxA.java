package w1_t2_ASCII.objects.styleA;

import w1_t2_ASCII.objects.abstractt.Checkbox;
import w1_t2_ASCII.objects.abstractt.Style;

public class CheckboxA extends Checkbox{

    public CheckboxA() {
        Style myStyle = new StyleA();
        super(myStyle);
    }
}
