package w5_t13_fileVisitor.visitors;

import w5_t13_fileVisitor.systemElemints.*;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
  private String keyword;
  private List<File> matchingFiles = new ArrayList<>();

  public SearchVisitor(String keyword) {
    this.keyword = keyword;
  }

  public List<File> getMatchingFiles() {
    return matchingFiles;
  }

  @Override
  public void visit(File file) {
    if (file.getName().contains(keyword)) {
      matchingFiles.add(file);
    }
  }

  @Override
  public void visit(Directory directory) {
    for (FileSystemElement child : directory.getChildren()) {
      child.accept(this);
    }
  }
}
