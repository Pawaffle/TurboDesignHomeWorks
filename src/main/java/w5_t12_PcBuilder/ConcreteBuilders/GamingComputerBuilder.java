package w5_t12_PcBuilder.ConcreteBuilders;

import w5_t12_PcBuilder.*;
import w5_t12_PcBuilder.Components.*;

public class GamingComputerBuilder implements PcBuilder {

  private final PC pc;

  public GamingComputerBuilder() {
    this.pc = new PC("Gaming Machine");
  }

  @Override
  public void addProcessor() {
    pc.addComponent(new Processor("AMD Ryzen 7 5800X", 3.8, 8));
  }

  @Override
  public void addRam() {
    pc.addComponent(new Ram("Corsair Vengeance", 16, "DDR4"));
  }

  @Override
  public void addHardMemory() {
    pc.addComponent(new HardDisk("Samsung 980 Pro", 1000, true));
  }

  @Override
  public void addGraphics() {
    pc.addComponent(new GraphicsCard("NVIDIA RTX 3080", 10, "Ampere"));
  }

  @Override
  public void installOperatingSystem() {
    pc.addComponent(new OperatingSystem("Steam OS", "3.0", true));
  }

  @Override
  public PC getPc() {
    return this.pc;
  }
}
