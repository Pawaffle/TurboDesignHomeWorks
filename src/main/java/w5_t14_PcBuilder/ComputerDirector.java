package w5_t14_PcBuilder;

public class ComputerDirector {

  private PcBuilder pcBuilder;

  public ComputerDirector(PcBuilder pcBuilder) {
    this.pcBuilder = pcBuilder;
  }

  public void ChangeBuilder(PcBuilder newBuilder) {
    this.pcBuilder = newBuilder;
  }

  public void constructSimplePC() {
    pcBuilder.addProcessor();
    pcBuilder.addGraphics();
    pcBuilder.addHardMemory();
    pcBuilder.addRam();
    pcBuilder.installOperatingSystem();
  }

  public void constructBiggerStoragePC(int timesNormalSize) {
    pcBuilder.addProcessor();
    pcBuilder.addGraphics();
    for (int i = 0; i < timesNormalSize; i++) {
      pcBuilder.addHardMemory();;
    }
    pcBuilder.addRam();
    pcBuilder.installOperatingSystem();
  }

  public void constructRamConsumingPC(int timesNormalSize) {
    pcBuilder.addProcessor();
    pcBuilder.addGraphics();
    for (int i = 0; i < timesNormalSize; i++) {
      pcBuilder.addRam();
    }
    pcBuilder.addHardMemory();
    pcBuilder.installOperatingSystem();
  }
}
