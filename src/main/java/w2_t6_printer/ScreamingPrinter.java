package w2_t6_printer;

public class ScreamingPrinter extends PrinterDecorator{
    public ScreamingPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text) {
        String newText = text.toUpperCase() + "!!!";
        super.print(newText);
    }
}
