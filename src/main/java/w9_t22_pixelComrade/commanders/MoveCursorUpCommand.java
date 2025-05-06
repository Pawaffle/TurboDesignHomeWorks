package w9_t22_pixelComrade.commanders;

import w9_t22_pixelComrade.Model;

public class MoveCursorUpCommand implements Command {
  private Model model;
  public MoveCursorUpCommand(Model model) { this.model = model; }
  public void execute() { model.moveUp(); }
}
