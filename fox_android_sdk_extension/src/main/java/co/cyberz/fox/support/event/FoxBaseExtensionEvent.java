package co.cyberz.fox.support.event;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.cyberz.fox.service.FoxEvent;
import co.cyberz.fox.support.util.StringUtil;

/**
 * Created by Garhira on 16/08/01.
 */
public class FoxBaseExtensionEvent extends FoxEvent {

  public static final String LOG_TAG = "F.O.X SDK Extension ";

  public FoxBaseExtensionEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
  }

  protected FoxBaseExtensionEvent addBaseCategoryId(String categoryId) {
    if (!StringUtil.isEmpty(categoryId)) addParam("categoryId", categoryId);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseDestination(String destination) {
    if (!StringUtil.isEmpty(destination)) addParam("destination", destination);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseOrigin(String origin) {
    if (!StringUtil.isEmpty(origin)) addParam("origin", origin);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseDin(String din) {
    if (!StringUtil.isEmpty(din)) addParam("din", din);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseDout(String dout) {
    if (!StringUtil.isEmpty(dout)) addParam("dout", dout);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseSearchTerm(String searchTerm) {
    if (!StringUtil.isEmpty(searchTerm)) addParam("search_term", searchTerm);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseProduct(String productId, String itemLocationId, String category, double price, int quantity) {
    try {
      JSONObject jo = new JSONObject();
      if (!StringUtil.isEmpty(productId)) {
        jo.put("id", productId).put("price", price);
        if (!StringUtil.isEmpty(itemLocationId)) jo.put("item_location_id", itemLocationId);
        if (!StringUtil.isEmpty(category)) jo.put("category", category);
        if (0 < price) jo.put("price", price);
        jo.put("quantity", (0 < quantity)? quantity : 1);
        if (0 < jo.length()) putProduct(jo);
        if (0 < price) this.price += (price * quantity);
      }
    } catch (JSONException e) {
    }
    return this;
  }

  public FoxBaseExtensionEvent addProduct(JSONObject product) {
    if (product != null && 0 < product.length()) putProduct(product);
    return this;
  }

  public FoxBaseExtensionEvent addParam(String key, String value) {
    try {
      if (StringUtil.isEmpty(key) || StringUtil.isEmpty(value)) return this;
      addExtraInfo(key, value);
      if (this.eventInfo != null) this.eventInfo.put(key, value);
    } catch (JSONException e) {
    }
    return this;
  }

  public FoxBaseExtensionEvent addParam(String key, double value) {
    try {
      if (StringUtil.isEmpty(key)) return this;
      addExtraInfo(key, String.valueOf(value));
      if (this.eventInfo != null) this.eventInfo.put(key, value);
    } catch (JSONException e) {
    }
    return this;
  }

  public FoxBaseExtensionEvent addParam(String key, boolean value) {
    try {
      if (StringUtil.isEmpty(key)) return this;
      addExtraInfo(key, String.valueOf(value));
      if (this.eventInfo != null) this.eventInfo.put(key, value);
    } catch (JSONException e) {
    }
    return this;
  }

  public FoxBaseExtensionEvent addParam(String key, JSONObject value) {
    try {
      if (StringUtil.isEmpty(key)) return this;
      if (this.eventInfo != null) this.eventInfo.put(key, value);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return this;
  }

  public FoxBaseExtensionEvent addParam(String key, JSONArray value) {
    try {
      if (StringUtil.isEmpty(key)) return this;
      if (this.eventInfo != null) this.eventInfo.put(key, value);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return this;
  }

  private void putProduct(JSONObject product) {
    try {
      if (product == null || product.length() == 0) return;
      JSONArray productArray = getProductArray();
      if (productArray == null || productArray.length() == 0) {
        productArray = new JSONArray();
      }
      productArray.put(product);
      this.eventInfo.put("product", productArray);
    } catch (JSONException e) {
    }
  }

  private JSONArray getProductArray() {
    try {
      if (eventInfo.has("product")) {
        return (JSONArray) eventInfo.get("product");
      }
    } catch (JSONException e) {
    }
    return null;
  }

  protected FoxBaseExtensionEvent addBaseTransactionId(String id) {
    if (!StringUtil.isEmpty(id)) addParam("transaction_id", id);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseDynalystAdvertiserId(String id) {
    if (!StringUtil.isEmpty(id)) addParam("dynalyst_advertiser_id", id);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseLocalizedTitle(String title) {
    if (!StringUtil.isEmpty(title)) addParam("localized_title", title);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseLocalizedDescription(String description) {
    if (!StringUtil.isEmpty(description)) addParam("localized_description", description);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseReceiptValid(boolean valid) {
    addParam("receipt_valid", valid);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseReceipt(String receipt) {
    if (!StringUtil.isEmpty(receipt)) addParam("receipt", receipt);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseCriteoPartnerId(String id) {
    if (!StringUtil.isEmpty(id)) addParam("criteo_partner_id", id);
    return this;
  }

  protected FoxBaseExtensionEvent addBaseDataFeed(JSONObject dataFeed) {
    if (dataFeed != null) addParam("datafeed", dataFeed);
    return this;
  }
}
