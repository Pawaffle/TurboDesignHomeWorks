package w5_t14_PcBuilder.ConcreteBuilders;

import w5_t14_PcBuilder.*;
import w5_t14_PcBuilder.Components.*;

public class OfficeComputerBuilder implements PcBuilder {

  private final PC pc;

  public OfficeComputerBuilder() {
    this.pc = new PC("Office Computer");
  }

  @Override
  public void addProcessor() {
    pc.addComponent(new Processor("Intel i3", 3.1, 4));
  }

  @Override
  public void addRam() {
    pc.addComponent(new Ram("Kingston", 8, "DDR4"));
  }

  @Override
  public void addHardMemory() {
    pc.addComponent(new HardDisk("WD Blue", 500, false));
  }

  @Override
  public void addGraphics() {
    // Office PCs usually don't need dedicated GPU
    pc.addComponent(new GraphicsCard("Integrated Graphics", 1, "Intel UHD"));
  }

  @Override
  public void installOperatingSystem() {
    pc.addComponent(new OperatingSystem("Windows 10 Professional", "10.0", true));
  }

  @Override
  public PC getPc() {
    return this.pc;
  }
}
