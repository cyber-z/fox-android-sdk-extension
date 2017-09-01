package co.cyberz.fox.support.event;

import co.cyberz.fox.support.event.media.IDynalystCommerce;
import co.cyberz.fox.support.event.media.IDynamicRemarketing;
import co.cyberz.fox.support.event.media.IVizury;

/**
 * Created by Garhira on 16/08/01.
 */
public class AddToCartEvent extends FoxBaseExtensionEvent implements IVizury, IDynamicRemarketing, IDynalystCommerce {

  public AddToCartEvent() {
    this(0);
  }

  public AddToCartEvent(int ltvPointId) {
    this("_add_to_cart", ltvPointId);
  }

  public AddToCartEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
  }

  public AddToCartEvent addUserId(String userId) {
    this.buid = userId;
    addParam("user_id", userId);
    return this;
  }

  public AddToCartEvent addItemId(String id) {
    this.sku = id;
    addParam("item_id", id);
    return this;
  }

  public AddToCartEvent addCurrency(String currency) {
    this.currency = currency;
    addParam("currency", currency);
    return this;
  }

  @Override
  public AddToCartEvent addDestination(String destination) {
    addBaseDestination(destination);
    return this;
  }

  @Override
  public AddToCartEvent addOrigin(String origin) {
    addBaseOrigin(origin);
    return this;
  }

  @Override
  public AddToCartEvent addDin(String din) {
    addBaseDin(din);
    return this;
  }

  @Override
  public AddToCartEvent addDout(String dout) {
    addBaseDout(dout);
    return this;
  }

  @Override
  public AddToCartEvent addCategoryId(String categoryId) {
    addBaseCategoryId(categoryId);
    return this;
  }

  @Override
  public AddToCartEvent addProduct(String id, String itemLocationId, String category, double price, int quantity) {
    addBaseProduct(id, itemLocationId, category, price, quantity);
    return this;
  }

  @Override
  public AddToCartEvent addTransactionId(String id) {
    return this;
  }

  @Override
  public AddToCartEvent addSearchTerm(String searchTerm) {
    return this;
  }

}
