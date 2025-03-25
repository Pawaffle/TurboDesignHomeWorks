package w1_t2_ASCII.factories;

import w1_t2_ASCII.objects.styleA.ButtonA;
import w1_t2_ASCII.objects.styleA.CheckboxA;
import w1_t2_ASCII.objects.styleA.TextFieldA;

public class AFactory extends GenericFactory {
    public AFactory(){
        super(
            ButtonA::new,
            CheckboxA::new,
            TextFieldA::new
        );
    }
}
