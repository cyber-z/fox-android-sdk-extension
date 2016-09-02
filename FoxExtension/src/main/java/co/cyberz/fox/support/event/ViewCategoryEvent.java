package co.cyberz.fox.support.event;

import co.cyberz.fox.support.event.media.IVizury;

/**
 * Created by Garhira on 16/08/01.
 */
public class ViewCategoryEvent extends FoxBaseExtensionEvent implements IVizury {

  public ViewCategoryEvent() {
    this(0);
  }

  public ViewCategoryEvent(int ltvPointId) {
    this("_view_category", ltvPointId);
  }

  public ViewCategoryEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
  }

  public ViewCategoryEvent addUserId(String userId) {
    this.buid = userId;
    addParam("user_id", userId);
    return this;
  }

  @Override
  public ViewCategoryEvent addCategoryId(String categoryId) {
    addBaseCategoryId(categoryId);
    return this;
  }

  @Override
  public ViewCategoryEvent addProduct(String id, String itemLocationId, String category, double price, int quantity) {
    return this;
  }

}
