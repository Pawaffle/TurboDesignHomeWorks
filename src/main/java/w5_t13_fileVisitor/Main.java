package w5_t13_fileVisitor;

import w5_t13_fileVisitor.systemElemints.*;
import w5_t13_fileVisitor.visitors.*;

public class Main {
  public static void main(String[] args) {
    Directory root = new Directory("root");
    Directory docs = new Directory("docs");
    Directory images = new Directory("images");

    File file1 = new File("notes.txt", 2);
    File file2 = new File("report.docx", 5);
    File file3 = new File("photo.jpg", 10);
    File file4 = new File("diagram.png", 3);

    docs.add(file1);
    docs.add(file2);
    images.add(file3);
    images.add(file4);
    root.add(docs);
    root.add(images);

    // Size calculation
    SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
    root.accept(sizeVisitor);
    System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

    // File search
    SearchVisitor searchVisitor = new SearchVisitor(".jpg");
    root.accept(searchVisitor);
    System.out.println("Matching files:");
    for (File f : searchVisitor.getMatchingFiles()) {
      System.out.println(" - " + f.getName());
    }
  }
}
