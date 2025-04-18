package w5_t14_PcBuilder.Components;

public class HardDisk extends PcComponent {
  private final int capacityGB;
  private final boolean isSSD;

  public HardDisk(String partName, int capacityGB, boolean isSSD) {
    super(partName);
    this.capacityGB = capacityGB;
    this.isSSD = isSSD;
  }

  public int getCapacityGB() {
    return capacityGB;
  }

  public boolean isSSD() {
    return isSSD;
  }

  @Override
  public String toString() {
    return super.getPartName() + ": " + capacityGB + "GB " + (isSSD ? "SSD" : "HDD");
  }
}