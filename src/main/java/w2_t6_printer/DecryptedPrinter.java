package w2_t6_printer;

public class DecryptedPrinter extends PrinterDecorator{
    Integer shift = 26-5;

    public DecryptedPrinter(Printer printer) {
        super(printer);
    }

     @Override
     public void print(String text) {
         StringBuilder result = new StringBuilder();

         for (char character : text.toCharArray()) {
             if (Character.isLetter(character)) {
                 char base = Character.isLowerCase(character) ? 'a' : 'A';
                 char shifted = (char) ((character - base + this.shift) % 26 + base);
                 result.append(shifted);
             } else {
                 result.append(character); // Leave non-letters unchanged
             }
         }

         super.print(result.toString());
     }
}
