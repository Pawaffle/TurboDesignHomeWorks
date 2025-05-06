package w9_t22_pixelComrade.commanders;

import w9_t22_pixelComrade.Model;

public class MoveCursorLeftCommand implements Command {
  private Model model;
  public MoveCursorLeftCommand(Model model) { this.model = model; }
  public void execute() { model.moveLeft(); }
}