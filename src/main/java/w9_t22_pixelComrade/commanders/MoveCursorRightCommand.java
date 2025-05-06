package w9_t22_pixelComrade.commanders;

import w9_t22_pixelComrade.Model;

public class MoveCursorRightCommand implements Command {
  private Model model;
  public MoveCursorRightCommand(Model model) { this.model = model; }
  public void execute() { model.moveRight(); }
}
