package w9_t22_pixelComrade.commanders;

import w9_t22_pixelComrade.Model;

public class GenerateCodeCommand implements Command {
  private Model model;
  public GenerateCodeCommand(Model model) { this.model = model; }
  public void execute() { model.display(); }
}