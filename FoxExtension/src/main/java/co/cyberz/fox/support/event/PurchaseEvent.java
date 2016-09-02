package co.cyberz.fox.support.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import co.cyberz.fox.support.event.media.IChartBoost;
import co.cyberz.fox.support.event.media.ICriteo;
import co.cyberz.fox.support.event.media.IDataFeed;
import co.cyberz.fox.support.event.media.IDynalystCommerce;
import co.cyberz.fox.support.event.media.IDynalystGames;
import co.cyberz.fox.support.event.media.IDynamicRemarketing;
import co.cyberz.fox.support.event.media.IVizury;
import co.cyberz.fox.support.util.StringUtil;

/**
 * Created by Garhira on 16/07/23.
 */
public class PurchaseEvent extends FoxBaseExtensionEvent implements ICriteo, IDataFeed, IVizury, IDynamicRemarketing, IDynalystGames, IDynalystCommerce, IChartBoost {

  private Bundle skuDetails;

  public PurchaseEvent(Bundle skuDetails) {
    this(0, skuDetails);
  }

  public PurchaseEvent(int ltvPointId) {
    this(ltvPointId, null);
  }

  public PurchaseEvent(int ltvPointId, Bundle skuDetails) {
    this("_purchase", ltvPointId, skuDetails);
  }

  public PurchaseEvent(String eventName, int ltvPointId, Bundle skuDetails) {
    super(eventName, ltvPointId);
    this.isPurchase = true;
    this.skuDetails = skuDetails;
    if (0 < ltvPointId) addParam("fox_cvpoint", ltvPointId);
  }

  public PurchaseEvent(String itemName, double price, String currency, int quantity, String sku) {
    this(0, itemName, price, currency, quantity, sku);
  }

  public PurchaseEvent(int ltvPointId, String itemName, double price, String currency, int quantity, String sku) {
    this("_purchase", ltvPointId, itemName, price, currency, quantity, sku);
  }

  public PurchaseEvent(String eventName, int ltvPointId, String itemName, double price, String currency, int quantity, String sku) {
    super(eventName, ltvPointId);
    if (price <= 0d) Log.e("PurchaseEvent ", "Price must be greater than zero");
    this.itemName = itemName;
    this.price = price;
    this.currency = (StringUtil.isEmpty(currency)) ? DEFAULT_CURRENCY : currency;
    this.isPurchase = true;
    this.quantity = quantity;
    if (!StringUtil.isEmpty(sku)) this.sku = sku;
    if (0 < ltvPointId) addParam("fox_cvpoint", ltvPointId);
  }

  public PurchaseEvent addItemId(String itemId) {
    if (!StringUtil.isEmpty(itemId)) {
      this.sku = itemId;
      addParam("item_id", itemId);
    }
    return this;
  }

  public PurchaseEvent addUserId(String userId) {
    if (!StringUtil.isEmpty(userId)) {
      this.buid = userId;
      addParam("user_id", userId);
    }
    return this;
  }

  @Override
  public PurchaseEvent addTransactionId(String id) {
    this.orderId = id;
    addBaseTransactionId(id);
    return this;
  }

  @Override
  public PurchaseEvent addDin(String din) {
    addBaseDin(din);
    return this;
  }

  @Override
  public PurchaseEvent addDout(String dout) {
    addBaseDout(dout);
    return this;
  }

  @Override
  public PurchaseEvent addDestination(String destination) {
    addBaseDestination(destination);
    return this;
  }

  @Override
  public PurchaseEvent addOrigin(String origin) {
    addBaseOrigin(origin);
    return this;
  }

  @Override
  public PurchaseEvent addLocalizedTitle(String title) {
    addBaseLocalizedTitle(title);
    return this;
  }

  @Override
  public PurchaseEvent addLocalizedDescription(String description) {
    addBaseLocalizedDescription(description);
    return this;
  }

  @Override
  public PurchaseEvent addReceiptValid(boolean valid) {
    addBaseReceiptValid(valid);
    return this;
  }

  @Override
  public PurchaseEvent addReceipt(String receipt) {
    addBaseReceipt(receipt);
    return this;
  }

  @Override
  public PurchaseEvent addDynalystAdvertiserId(String id) {
    addBaseDynalystAdvertiserId(id);
    return this;
  }

  @Override
  public PurchaseEvent addCategoryId(String categoryId) {
    addBaseCategoryId(categoryId);
    return this;
  }

  @Override
  public PurchaseEvent addProduct(String id, String itemLocationId, String category, double price, int quantity) {
    addBaseProduct(id, itemLocationId, category, price, quantity);
    return this;
  }

  @Override
  public PurchaseEvent addCriteoPartnerId(String id) {
    addBaseCriteoPartnerId(id);
    return this;
  }

  @Override
  public PurchaseEvent addDataFeed(JSONObject dataFeed) {
    addBaseDataFeed(dataFeed);
    return this;
  }

  public void setPurchaseData(Intent data) {
    if (skuDetails == null) {
      Log.w(LOG_TAG + "PurchaseEvent setPurchaseData", "'skuDetails' is must be not null.");
      return;
    } else if (data == null) {
      Log.w(LOG_TAG + "PurchaseEvent setPurchaseData", "Purchase data is must be not null.");
      return;
    }
    try {
      int responseCode = data.getIntExtra("RESPONSE_CODE", 0);
      if (responseCode != Activity.RESULT_OK) {
        Log.w(LOG_TAG + "PurchaseEvent setPurchaseData", "ResponseCode is not OK.");
        return;
      }
      String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
      JSONObject jo = new JSONObject(purchaseData);
      addItemId(jo.optString("productId"));       // sku
      addTransactionId(jo.optString("orderId"));  // orderId
    } catch (JSONException e) {
      Log.e(LOG_TAG + "setSkuDetail", e.getMessage());
    }
    try {
      ArrayList<String> responseList = skuDetails.getStringArrayList("DETAILS_LIST");
      JSONObject details = null;
      for (String thisResponse : responseList) {
        details = new JSONObject(thisResponse);
        String sku = details.optString("productId");
        if (this.sku.equals(sku)) break;
      }
      if (details != null) {
        this.price = Double.parseDouble(details.optString("price"));
        this.currency = details.optString("price_currency_code");
        this.quantity = 1;
        addLocalizedTitle(details.optString("title"));
        addLocalizedDescription(details.optString("description"));
      }
    } catch (Exception e) {

    }
  }

  @Override
  public PurchaseEvent addSearchTerm(String searchTerm) {
    return this;
  }

  @Override
  public PurchaseEvent addTrackInfo(String eventLabel, int eventField, String mainLevel, String subLevel, String description) {
    return this;
  }

}
