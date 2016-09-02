package co.cyberz.fox.support.event;

import co.cyberz.fox.support.event.media.IDynamicRemarketing;

/**
 * Created by Garhira on 16/08/01.
 */
public class SearchEvent extends FoxBaseExtensionEvent implements IDynamicRemarketing {

  public SearchEvent() {
    this(0);
  }

  public SearchEvent(int ltvPointId) {
    this("_search", ltvPointId);
  }

  public SearchEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
  }

  public SearchEvent addUserId(String userId) {
    this.buid = userId;
    addParam("user_id", userId);
    return this;
  }

  @Override
  public SearchEvent addDestination(String destination) {
    addBaseDestination(destination);
    return this;
  }

  @Override
  public SearchEvent addOrigin(String origin) {
    addBaseOrigin(origin);
    return this;
  }

  @Override
  public SearchEvent addDin(String din) {
    addBaseDin(din);
    return this;
  }

  @Override
  public SearchEvent addDout(String dout) {
    addBaseDout(dout);
    return this;
  }

  @Override
  public SearchEvent addProduct(String id, String itemLocationId, String category, double price, int quantity) {
    addBaseProduct(id, itemLocationId, category, price, quantity);
    return this;
  }

  @Override
  public SearchEvent addSearchTerm(String searchTerm) {
    addBaseSearchTerm(searchTerm);
    return this;
  }
}
