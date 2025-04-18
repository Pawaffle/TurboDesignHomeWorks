package w5_t12_PcBuilder;

import w5_t12_PcBuilder.Components.PcComponent;

import java.util.ArrayList;
import java.util.List;

public class PC {

  private List<PcComponent> components;
  private String pcType;

  public PC(String pcType) {
    this.components = new ArrayList<>();
    this.pcType = pcType;
  }

  public void addComponent(PcComponent component) {
    this.components.add(component);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("pcType: " + pcType + "\n");
    for (PcComponent component : components) {
      sb.append(component.toString());
      sb.append("\n");
    }
    return sb.toString();
  }
}