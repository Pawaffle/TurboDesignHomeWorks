package w1_t2_ASCII;

import w1_t2_ASCII.factories.AFactory;
import w1_t2_ASCII.factories.UIFactory;
import w1_t2_ASCII.objects.abstractt.Button;
import w1_t2_ASCII.objects.styleA.ButtonA;

public class Main {
    public static void main(String[] args) {
        AFactory blueprintA = new AFactory();
        UIFactory myFactory = blueprintA.Create();

        Button myButton = myFactory.createButton("Press Me");
        myButton.display();
    }
}
