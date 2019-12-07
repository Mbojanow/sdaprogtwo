package pl.sdacademy.prog.threads.booleans;

public class SwitchingThread implements Runnable {

  private PackedBool packedBool;
  
  public SwitchingThread(final PackedBool packedBool) {
    this.packedBool = packedBool;
  }
  
  @Override
  public void run() {
    for (int idx = 0; idx < 10000; idx++) {
      packedBool.switchValue();
    }
  }
}
