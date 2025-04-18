package w5_t14_PcBuilder.ConcreteBuilders;

import w5_t14_PcBuilder.*;
import w5_t14_PcBuilder.Components.*;

public class EnthusiastComputerBuilder implements PcBuilder {

  private PC pc;

  public EnthusiastComputerBuilder() {
    this.pc = new PC("Enthusiast Build");
  }

  @Override
  public void addProcessor() {
    pc.addComponent(new Processor("Intel i9-13900K", 3.0, 24));
  }

  @Override
  public void addRam() {
    pc.addComponent(new Ram("G.SKILL Trident Z", 32, "DDR5"));
  }

  @Override
  public void addHardMemory() {
    pc.addComponent(new HardDisk("Seagate FireCuda", 2000, true));
  }

  @Override
  public void addGraphics() {
    pc.addComponent(new GraphicsCard("NVIDIA RTX 4090", 24, "Ada Lovelace"));
  }

  @Override
  public void installOperatingSystem() {
    pc.addComponent(new OperatingSystem("Tiny Windows 11", "11.0", true));
  }

  @Override
  public PC getPc() {
    return this.pc;
  }
}
