package w5_t13_fileVisitor.visitors;

import w5_t13_fileVisitor.systemElemints.*;

public class SizeCalculatorVisitor implements FileSystemVisitor {
  private int totalSize = 0;

  public int getTotalSize() {
    return totalSize;
  }

  @Override
  public void visit(File file) {
    totalSize += file.getSizeMB();
  }

  @Override
  public void visit(Directory directory) {
    for (FileSystemElement child : directory.getChildren()) {
      child.accept(this);
    }
  }
}
