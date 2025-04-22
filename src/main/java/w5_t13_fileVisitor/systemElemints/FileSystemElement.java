package w5_t13_fileVisitor.systemElemints;

import w5_t13_fileVisitor.visitors.FileSystemVisitor;

public interface FileSystemElement {
  void accept(FileSystemVisitor visitor);
}
