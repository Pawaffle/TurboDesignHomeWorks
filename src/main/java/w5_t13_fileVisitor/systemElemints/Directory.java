package w5_t13_fileVisitor.systemElemints;

import w5_t13_fileVisitor.visitors.FileSystemVisitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
  private String name;
  private List<FileSystemElement> children = new ArrayList<>();

  public Directory(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void add(FileSystemElement element) {
    children.add(element);
  }

  public List<FileSystemElement> getChildren() {
    return children;
  }

  @Override
  public void accept(FileSystemVisitor visitor) {
    visitor.visit(this);
  }
}
