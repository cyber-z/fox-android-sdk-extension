package co.cyberz.fox.support.event.media;

/**
 * Created by Garhira on 16/08/03.
 */
public interface IDynamicRemarketing {

  public IDynamicRemarketing addDestination(String destination);

  public IDynamicRemarketing addOrigin(String origin);

  public IDynamicRemarketing addDin(String din);

  public IDynamicRemarketing addDout(String dout);

  public IDynamicRemarketing addProduct(String id, String itemLocationId, String category, double price, int quantity);

  public IDynamicRemarketing addSearchTerm(String searchTerm);

}
