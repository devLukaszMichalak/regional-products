package dev.lukaszmichalak.regionalproducts.voivodeship;

public class TestVoivodeshipConfig {

  public static VoivodeshipService voivodeshipService() {
    return new TestVoivodeshipService();
  }
}
