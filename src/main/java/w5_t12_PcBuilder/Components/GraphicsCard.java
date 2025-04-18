package w5_t12_PcBuilder.Components;

public class GraphicsCard extends PcComponent {
  private final int vramGB;
  private final String chipset;

  public GraphicsCard(String partName, int vramGB, String chipset) {
    super(partName);
    this.vramGB = vramGB;
    this.chipset = chipset;
  }

  public int getVramGB() {
    return vramGB;
  }

  public String getChipset() {
    return chipset;
  }

  @Override
  public String toString() {
    return super.getPartName() + ": " + chipset + " with " + vramGB + "GB VRAM";
  }
}