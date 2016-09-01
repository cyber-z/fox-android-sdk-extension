[TOP](../../README.md)　>　[イベント計測の詳細](../README.md)　>　Track Transaction (商品購入) イベント実装

---

# Track Transaction (商品購入) イベント実装

Track Transaction（商品購入）イベントが発生する箇所に、下記に従ってアクセス解析のイベント計測機能を実装ください。<br>
実装には[`PurchaseEvent`](../../sdk_api/event/PurchaseEvent.md)クラスを使用します。

### 実装例1

各値をセットした通常の課金計測のサンプル

```java
PurchaseEvent event = new PurchaseEvent(12345, "life", 4.99, "USD", 1, "ITEM-001");
event.addUserId("USER_A001");
FoxTrack.sendEvent(event);
```

### 実装例2

GooglePlayから発行されるオブジェクトを引数に課金計測を行うサンプル

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;

IInAppBillingService mService;
Bundle skuDetails;

...
  // 商品情報の取得例
  skuDetails = mService.getSkuDetails(3, getPackageName(), "inapp", querySkus);

...

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 1001) {
      // 課金計測
      PurchaseEvent event = new PurchaseEvent(12345, skuDetails);
      event.addUserId("USER_A001")
           .setPurchaseData(data);
      FoxTrack.sendEvent(event);
    }

  }
...
```

### 実装例3

媒体との連携時のサンプル

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;

PurchaseEvent event = new PurchaseEvent(12345);
event.addUserId("USER_A001")
     .addCurrency("JPY")
     .addProduct(111, null, null, 0, 0)
     .addCriteoPartnerId("XXXXX")
     .addDin("2016-05-01")
     .addDout("2016-05-05");
FoxTrack.sendEvent(event);
```


### 連携対応済み媒体

* [Criteo](../cooperation_medias/Criteo/README.md#purchase)
* [Vizury](../cooperation_medias/Vizury/README.md#purchase)
* [DynamicRemaketing](../cooperation_medias/DynamicRemarketing/README.md#purchase)
* [DynalystGames](../cooperation_medias/DynalystGames/README.md#purchase)
* [DynalystCommerce](../cooperation_medias/DynalystCommerce/README.md#purchase)
* [ChartBoost](../cooperation_medias/Chartboost/README.md#purchase)

---
[戻る](../README.md#supported_events)

[トップ](../../README.md)
