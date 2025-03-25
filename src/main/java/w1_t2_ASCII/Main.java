package w1_t2_ASCII;

import w1_t2_ASCII.factories.AFactory;
import w1_t2_ASCII.objects.abstractt.Button;
import w1_t2_ASCII.objects.abstractt.Checkbox;
import w1_t2_ASCII.objects.abstractt.TextField;

public class Main {
    public static void main() {
        AFactory myFactory = new AFactory();
        //BFactory myFactory = new BFactory();

        TextField myField = myFactory.createTextField(40);
        System.out.println("Please fill this field:");
        myField.display();

        Checkbox myCheck = myFactory.createCheckbox();
        System.out.println(" Please check this box:");
        myCheck.display();

        Button myButton = myFactory.createButton("Button");
        myButton.display();
    }
}
