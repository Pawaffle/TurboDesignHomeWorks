package w6_t16_guruTvBridge;

import w6_t16_guruTvBridge.remotes.AdvancedRemote;
import w6_t16_guruTvBridge.remotes.BasicRemote;
import w6_t16_guruTvBridge.remotes.TheSmartRemote;
import w6_t16_guruTvBridge.devises.Device;
import w6_t16_guruTvBridge.devises.Radio;
import w6_t16_guruTvBridge.devises.TheSmartTv;
import w6_t16_guruTvBridge.devises.Tv;

public class Main {
  public static void main(String[] args) {
    testDevice(new Tv());
    testDevice(new Radio());
    // New implementation
    testDevice(new TheSmartTv());
  }

  public static void testDevice(Device device) {
    System.out.println("Tests with basic remote.");
    BasicRemote basicRemote = new BasicRemote(device);
    basicRemote.power();
    device.printStatus();

    System.out.println("Tests with advanced remote.");
    AdvancedRemote advancedRemote = new AdvancedRemote(device);
    advancedRemote.power();
    advancedRemote.mute();
    device.printStatus();

    // And here as well
    System.out.println("My test");
    TheSmartRemote smartRemote = new TheSmartRemote(device);
    smartRemote.power();
    smartRemote.voiceControl("open browser");
    device.printStatus();
  }
}