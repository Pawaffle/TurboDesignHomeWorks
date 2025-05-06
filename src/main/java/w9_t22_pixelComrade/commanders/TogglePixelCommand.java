package w9_t22_pixelComrade.commanders;

import w9_t22_pixelComrade.Model;

public class TogglePixelCommand implements Command {
  private Model model;
  public TogglePixelCommand(Model model) { this.model = model; }
  public void execute() { model.toggle(); }
}
