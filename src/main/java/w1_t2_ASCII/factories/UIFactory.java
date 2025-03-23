package w1_t2_ASCII.factories;

import w1_t2_ASCII.objects.abstractt.Button;
import w1_t2_ASCII.objects.abstractt.Checkbox;
import w1_t2_ASCII.objects.abstractt.TextField;

public interface UIFactory {
    Button createButton(String text);
    Checkbox createCheckbox();
    TextField createTextField(int width);
}
