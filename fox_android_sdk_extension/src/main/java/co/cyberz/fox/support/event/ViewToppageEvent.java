package co.cyberz.fox.support.event;

import co.cyberz.fox.support.event.media.ICriteo;

/**
 * Created by Garhira on 16/08/01.
 */
public class ViewToppageEvent extends FoxBaseExtensionEvent implements ICriteo {

  public ViewToppageEvent() {
    this(0);
  }

  public ViewToppageEvent(int ltvPointId) {
    this("_view_toppage", ltvPointId);
  }

  public ViewToppageEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
  }

  public ViewToppageEvent addUserId(String userId) {
    this.buid = userId;
    addParam("user_id", userId);
    return this;
  }

  @Override
  public ViewToppageEvent addDin(String din) {
    addBaseDin(din);
    return this;
  }

  @Override
  public ViewToppageEvent addDout(String dout) {
    addBaseDout(dout);
    return this;
  }

  @Override
  public ViewToppageEvent addCriteoPartnerId(String id) {
    addBaseCriteoPartnerId(id);
    return this;
  }

  @Override
  public ViewToppageEvent addDestination(String destination) {
    return this;
  }

  @Override
  public ViewToppageEvent addOrigin(String origin) {
    return this;
  }

  @Override
  public ViewToppageEvent addCategoryId(String id) {
    return this;
  }

  @Override
  public ViewToppageEvent addProduct(String id, String itemLocationId, String category, double price, int quantity) {
    return this;
  }

}
