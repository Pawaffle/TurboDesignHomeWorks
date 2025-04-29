package w6_t16_guruTvBridge.remotes;

import w6_t16_guruTvBridge.devises.Device;
import w6_t16_guruTvBridge.devises.TheSmartTv;

public class TheSmartRemote extends BasicRemote{
  public TheSmartRemote(Device device) {
    super.device = device;
  }

  public void voiceControl(String command) {
    if ("open browser".equals(command) && device instanceof TheSmartTv) {
      ((TheSmartTv) device).browseInternet();
    } else {
      System.out.println("Sorry, I can't evaluate 'open browser' for dummy devices!");
    }
  }
}
