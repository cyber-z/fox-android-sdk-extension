package co.cyberz.fox.support.event.media;

/**
 * Created by Garhira on 16/08/03.
 */
public interface IVizury {

  public IVizury addCategoryId(String categoryId);

  public IVizury addProduct(String id, String itemLocationId, String category, double price, int quantity);

}
