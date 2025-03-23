package w1_t2_ASCII.factories;

import w1_t2_ASCII.objects.styleB.ButtonB;
import w1_t2_ASCII.objects.styleB.CheckboxB;
import w1_t2_ASCII.objects.styleB.TextFieldB;

public class BFactory {
    UIFactory styleBFactory = new GenericFactory(
            ButtonB::new,
            CheckboxB::new,
            TextFieldB::new
    );

    public UIFactory Create(){
        return styleBFactory;
    }
}
