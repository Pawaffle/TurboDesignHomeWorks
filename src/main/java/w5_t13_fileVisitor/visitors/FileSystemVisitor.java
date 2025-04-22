package w5_t13_fileVisitor.visitors;

import w5_t13_fileVisitor.systemElemints.File;
import w5_t13_fileVisitor.systemElemints.Directory;

public interface FileSystemVisitor {
  void visit(File file);
  void visit(Directory directory);
}
