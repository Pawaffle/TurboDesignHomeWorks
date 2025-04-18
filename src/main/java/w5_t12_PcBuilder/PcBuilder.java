package w5_t12_PcBuilder;

public interface PcBuilder {

    void addProcessor();
    void addRam();
    void addHardMemory();
    void addGraphics();
    void installOperatingSystem();
    PC getPc();

}
