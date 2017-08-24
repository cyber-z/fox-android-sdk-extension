package co.cyberz.fox.support.event;

import co.cyberz.fox.support.event.media.ICriteo;
import co.cyberz.fox.support.event.media.IDynalystCommerce;
import co.cyberz.fox.support.event.media.IDynamicRemarketing;

/**
 * Created by Garhira on 16/08/01.
 */
public class ViewListingEvent extends FoxBaseExtensionEvent implements ICriteo, IDynamicRemarketing, IDynalystCommerce {

  public ViewListingEvent() {
    this(0);
  }

  public ViewListingEvent(int ltvPointId) {
    this("_view_listing", ltvPointId);
  }

  public ViewListingEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
  }

  public ViewListingEvent addUserId(String userId) {
    this.buid = userId;
    addParam("user_id", userId);
    return this;
  }

  @Override
  public ViewListingEvent addTransactionId(String id) {
    super.addBaseTransactionId(id);
    return this;
  }

  @Override
  public ViewListingEvent addDestination(String destination) {
    addBaseDestination(destination);
    return this;
  }

  @Override
  public ViewListingEvent addOrigin(String origin) {
    addBaseOrigin(origin);
    return this;
  }

  @Override
  public ViewListingEvent addDin(String din) {
    addBaseDin(din);
    return this;
  }

  @Override
  public ViewListingEvent addDout(String dout) {
    addBaseDout(dout);
    return this;
  }

  @Override
  public ViewListingEvent addCriteoPartnerId(String id) {
    addBaseCriteoPartnerId(id);
    return this;
  }

  @Override
  public ViewListingEvent addProduct(String id, String itemLocationId, String category, double price, int quantity) {
    addBaseProduct(id, itemLocationId, category, price, quantity);
    return this;
  }

  @Override
  public ViewListingEvent addCategoryId(String id) {
    return this;
  }

  @Override
  public ViewListingEvent addSearchTerm(String searchTerm) {
    return this;
  }


}
