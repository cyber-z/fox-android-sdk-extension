[TOP](../../README.md)　>　[イベント計測の詳細](../README.md)　>　ViewBasket(買い物かご)イベント実装

---

# ViewBasket(買い物かご)イベント実装

View Basket（商品購入予定一覧）イベントが発生する箇所に、下記に従ってアクセス解析のイベント計測機能を実装ください。<br>
実装には[`AddToCartEvent`](../../sdk_api/event/AddToCartEvent.md)クラスを使用します。

### 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AddToCartEvent;

AddToCartEvent event = new AddToCartEvent(12345);
event.addUserId("USER_A001")
     .addCurrency("JPY")
     .addProduct(111, null, null, 0, 0)
     .addProduct(212, null, null, 0, 0)
     .addProduct(513, null, null, 0, 0)
     .addCriteoPartnerId("XXXXX")
     .addDin("2016-05-01")
     .addDout("2016-05-05");
FoxTrack.sendEvent(event);
```


### 連携対応済み媒体

* [Criteo](../cooperation_medias/Criteo/README.md#add_to_cart)
* [Vizury](../cooperation_medias/Vizury/README.md#add_to_cart)
* [DynamicRemaketing](../cooperation_medias/DynamicRemarketing/README.md#add_to_cart)
* [DynalystCommerce](../cooperation_medias/DynalystCommerce/README.md#add_to_cart)


---
[戻る](../README.md#supported_events)

[トップ](../../README.md)
