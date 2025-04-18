package w5_t14_PcBuilder;

public interface PcBuilder {

    void addProcessor();
    void addRam();
    void addHardMemory();
    void addGraphics();
    void installOperatingSystem();
    PC getPc();

}
