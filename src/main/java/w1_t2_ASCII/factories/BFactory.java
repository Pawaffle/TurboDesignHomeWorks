package w1_t2_ASCII.factories;

import w1_t2_ASCII.objects.styleB.ButtonB;
import w1_t2_ASCII.objects.styleB.CheckboxB;
import w1_t2_ASCII.objects.styleB.TextFieldB;

public class BFactory extends GenericFactory {
    public BFactory() {
        super(
            ButtonB::new,
            CheckboxB::new,
            TextFieldB::new
        );
    }
}
