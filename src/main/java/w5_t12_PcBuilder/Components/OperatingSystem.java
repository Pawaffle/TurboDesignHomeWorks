package w5_t12_PcBuilder.Components;

public class OperatingSystem extends PcComponent {
  private final String version;
  private final boolean is64bit;

  public OperatingSystem(String partName, String version, boolean is64bit) {
    super(partName);
    this.version = version;
    this.is64bit = is64bit;
  }

  public String getVersion() {
    return version;
  }

  public boolean is64bit() {
    return is64bit;
  }

  @Override
  public String toString() {
    return super.getPartName() + ": " + version + (is64bit ? " 64-bit" : " 32-bit");
  }
}