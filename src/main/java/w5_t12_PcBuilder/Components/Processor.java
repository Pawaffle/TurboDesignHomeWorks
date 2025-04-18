package w5_t12_PcBuilder.Components;

public class Processor extends PcComponent {
  private final double frequencyGHz;
  private final int cores;

  public Processor(String partName, double frequencyGHz, int cores) {
    super(partName);
    this.frequencyGHz = frequencyGHz;
    this.cores = cores;
  }

  public double getFrequencyGHz() {
    return frequencyGHz;
  }

  public int getCores() {
    return cores;
  }

  @Override
  public String toString() {
    return super.getPartName() + ": " + cores + " cores @ " + frequencyGHz + "GHz";
  }
}