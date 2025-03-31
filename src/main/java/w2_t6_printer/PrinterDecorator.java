package w2_t6_printer;

public abstract class PrinterDecorator implements Printer {
    private Printer printer;

    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        printer.print(text);
    }
}
