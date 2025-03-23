package w1_t2_ASCII.factories;

import w1_t2_ASCII.objects.abstractt.Button;
import w1_t2_ASCII.objects.abstractt.Checkbox;
import w1_t2_ASCII.objects.abstractt.TextField;

import java.util.function.Function;
import java.util.function.Supplier;

public class GenericFactory implements UIFactory {


    // mapping Function - map x to y - lambda based interface

    private final Function<String, Button> buttonCreator;
    private final Supplier<Checkbox> checkboxCreator;
    private final Function<Integer, TextField> textFieldCreator;

    public GenericFactory(
            Function<String, Button> buttonCreator,
            Supplier<Checkbox> checkboxCreator,
            Function<Integer, TextField> textFieldCreator) {


        this.buttonCreator = buttonCreator;
        this.checkboxCreator = checkboxCreator;
        this.textFieldCreator = textFieldCreator;
    }

    @Override
    public Button createButton(String text) {
        return buttonCreator.apply(text);
    }

    @Override
    public Checkbox createCheckbox() {
        return checkboxCreator.get();
    }

    @Override
    public TextField createTextField(int width) {
        return textFieldCreator.apply(width);
    }
}
