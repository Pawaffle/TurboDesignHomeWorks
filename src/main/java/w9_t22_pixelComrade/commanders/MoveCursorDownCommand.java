package w9_t22_pixelComrade.commanders;

import w9_t22_pixelComrade.Model;

public class MoveCursorDownCommand implements Command {
  private Model model;
  public MoveCursorDownCommand(Model model) { this.model = model; }
  public void execute() { model.moveDown(); }
}