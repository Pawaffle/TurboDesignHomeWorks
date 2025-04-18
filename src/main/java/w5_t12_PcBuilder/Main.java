package w5_t12_PcBuilder;

import w5_t12_PcBuilder.ConcreteBuilders.EnthusiastComputerBuilder;
import w5_t12_PcBuilder.ConcreteBuilders.GamingComputerBuilder;
import w5_t12_PcBuilder.ConcreteBuilders.OfficeComputerBuilder;

public class Main {
  public static void main(String[] args) {
    PcBuilder myRaceBuilder = new GamingComputerBuilder();
    PcBuilder myBoringBuilder = new OfficeComputerBuilder();
    PcBuilder myRealStuffBuilder = new EnthusiastComputerBuilder();

    ComputerDirector director = new ComputerDirector(myRaceBuilder);

    director.constructRamConsumingPC(4);
    PC racePc = myRaceBuilder.getPc();

    director.ChangeBuilder(myBoringBuilder);
    director.constructBiggerStoragePC(2);
    PC boringPc = myBoringBuilder.getPc();

    director.ChangeBuilder(myRealStuffBuilder);
    director.constructSimplePC();
    PC realStuffPc = myRealStuffBuilder.getPc();

    System.out.println(boringPc);
    System.out.println(racePc);
    System.out.println(realStuffPc);

  }
}
