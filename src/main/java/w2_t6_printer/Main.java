package w2_t6_printer;

public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");
        //Hello World!

        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");
        //<message>Mjqqt Btwqi!</message>

        Printer printer3 = new DecryptedPrinter(printer2);
        printer3.print("Hello World!");
        //<message>Hello World!</message>

        Printer printer4 = new ScreamingPrinter(new XMLPrinter(new BasicPrinter()));
        printer4.print("Hello World!");
        //<message>HELLO WORLD!!!!</message>

        Printer printer5 = new XMLPrinter(new ScreamingPrinter(new BasicPrinter()));
        printer5.print("Hello World!");
        //<MESSAGE>HELLO WORLD!</MESSAGE>!!!
    }
}
