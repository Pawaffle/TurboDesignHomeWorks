package w2_t6_printer;

public class XMLPrinter extends PrinterDecorator{
    public XMLPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text) {
        String decoratedText = String.format("<message>%s</message>", text);
        super.print(decoratedText);
    }
}
