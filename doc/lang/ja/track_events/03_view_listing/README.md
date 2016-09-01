[TOP](../../README.md)　>　[イベント計測の詳細](../README.md)　>　ViewListing(複数商品閲覧)イベント実装

---

# ViewListing(複数商品閲覧)イベント実装

View Listing（複数商品閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。上位３つの商品が計測されます。<br>
実装には[`ViewListingEvent`](../../sdk_api/event/ViewListingEvent.md)クラスを使用します。

### 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewListingEvent;

ViewListingEvent event = new ViewListingEvent(12345);
event.addUserId("USER_A001")
     .addCriteoPartnerId("XXXXX")
     .addProduct(111, null, "movie", 1890, 1)
     .addProduct(121, null, "sport", 2300, 1)
     .addDin("2016-05-01")
     .addDout("2016-05-05");
FoxTrack.sendEvent(event);
```


### 連携対応済み媒体

* [Criteo](../cooperation_medias/Criteo/README.md#view_listing)
* [DynamicRemarketing](../cooperation_medias/DynamicRemarketing/README.md#view_listing)
* [DynalystCommerce](../cooperation_medias/DynalystCommerce/README.md#view_listing)


---
[戻る](../README.md#supported_events)

[トップ](../../README.md)
