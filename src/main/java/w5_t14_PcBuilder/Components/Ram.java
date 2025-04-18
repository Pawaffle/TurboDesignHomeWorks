package w5_t14_PcBuilder.Components;

public class Ram extends PcComponent {
  private final int capacityGB; // e.g., 16
  private final String type;    // e.g., DDR4

  public Ram(String partName, int capacityGB, String type) {
    super(partName);
    this.capacityGB = capacityGB;
    this.type = type;
  }

  public int getCapacityGB() {
    return capacityGB;
  }

  public String getType() {
    return type;
  }

  @Override
  public String toString() {
    return super.getPartName() + ": " + capacityGB + "GB " + type;
  }
}
