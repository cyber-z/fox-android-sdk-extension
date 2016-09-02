package co.cyberz.fox.support.event.media;

/**
 * Created by Garhira on 16/08/03.
 */
public interface IDynalystCommerce {

  public IDynalystCommerce addTransactionId(String id);

  public IDynalystCommerce addProduct(String id, String itemLocationId, String category, double price, int quantity);
}
