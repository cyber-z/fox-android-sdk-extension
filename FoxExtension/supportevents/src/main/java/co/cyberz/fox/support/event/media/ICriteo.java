package co.cyberz.fox.support.event.media;

/**
 * Created by Garhira on 16/08/05.
 */
public interface ICriteo {

  public ICriteo addDestination(String destination);

  public ICriteo addOrigin(String origin);

  public ICriteo addDin(String din);

  public ICriteo addDout(String dout);

  public ICriteo addCriteoPartnerId(String id);

  public ICriteo addCategoryId(String id);

  public ICriteo addProduct(String id, String itemLocationId, String category, double price, int quantity);

}
