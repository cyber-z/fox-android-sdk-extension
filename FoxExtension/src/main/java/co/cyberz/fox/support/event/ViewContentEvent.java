package co.cyberz.fox.support.event;

import co.cyberz.fox.support.event.media.ICriteo;
import co.cyberz.fox.support.event.media.IDynalystCommerce;
import co.cyberz.fox.support.event.media.IDynamicRemarketing;
import co.cyberz.fox.support.event.media.IVizury;

/**
 * Created by Garhira on 16/07/29.
 */
public class ViewContentEvent extends FoxBaseExtensionEvent implements ICriteo, IVizury, IDynamicRemarketing, IDynalystCommerce {

  public ViewContentEvent() {
    this(0);
  }

  public ViewContentEvent(int ltvPointId) {
    this("_view_content", ltvPointId);
  }

  public ViewContentEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
    if(0 < ltvPointId) addParam("fox_cvpoint", ltvPointId);
  }

  public ViewContentEvent addUserId(String id) {
    this.buid = id;
    addParam("user_id", id);
    return this;
  }

  public ViewContentEvent addItemId(String id) {
    this.sku = id;
    addParam("item_id", id);
    return this;
  }


  @Override
  public ViewContentEvent addDestination(String destination) {
    addBaseDestination(destination);
    return this;
  }

  @Override
  public ViewContentEvent addOrigin(String origin) {
    addBaseOrigin(origin);
    return this;
  }

  @Override
  public ViewContentEvent addDin(String din) {
    addBaseDin(din);
    return this;
  }

  @Override
  public ViewContentEvent addDout(String dout) {
    addBaseDout(dout);
    return this;
  }

  @Override
  public ViewContentEvent addCriteoPartnerId(String id) {
    addBaseCriteoPartnerId(id);
    return this;
  }

  @Override
  public ViewContentEvent addCategoryId(String categoryId) {
    addBaseCategoryId(categoryId);
    return this;
  }

  @Override
  public ViewContentEvent addProduct(String id, String itemLocationId, String category, double price, int quantity) {
    addBaseProduct(id, itemLocationId, category, price, quantity);
    return this;
  }

  @Override
  public ViewContentEvent addSearchTerm(String searchTerm) {
    return this;
  }

  @Override
  public ViewContentEvent addTransactionId(String id) {
    return this;
  }

}
