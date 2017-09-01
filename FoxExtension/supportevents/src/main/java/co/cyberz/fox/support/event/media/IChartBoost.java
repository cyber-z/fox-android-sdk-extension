package co.cyberz.fox.support.event.media;

/**
 * Created by Garhira on 16/08/03.
 */
public interface IChartBoost {

  public IChartBoost addLocalizedTitle(String title);


  public IChartBoost addLocalizedDescription(String description);


  public IChartBoost addReceiptValid(boolean valid);


  public IChartBoost addReceipt(String receipt);


  public IChartBoost addTrackInfo(String eventLabel, int eventField, String mainLevel, String subLevel, String description);

}
