[TOP](../../README.md)　>　[イベント計測の詳細](../README.md)　>　ViewProduct(商品閲覧)イベント実装

---

# ViewProduct(商品閲覧)イベント実装

View Product（単一商品閲覧）イベントが発生する箇所に、下記に従ってアクセス解析のイベント計測機能を実装ください。<br>
実装には[`ViewContentEvent`](../../sdk_api/event/ViewContentEvent.md)クラスを使用します。

### 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewContentEvent;

ViewContentEvent event = new ViewContentEvent(12345);
event.addUserId("USER_A001")
     .addCriteoPartnerId("XXXXX")
     .addDin("2016-05-01")
     .addDout("2016-05-05")
     .addProduct(111, null, null, 0, 0);
FoxTrack.sendEvent(event);
```

### 連携対応済み媒体

* [Criteo](../cooperation_medias/Criteo/README.md#view_content)
* [Vizury](../cooperation_medias/Vizury/README.md#view_content)
* [DynamicRemaketing](../cooperation_medias/DynamicRemarketing/README.md#view_content)
* [DynalystCommerce](../cooperation_medias/DynalystCommerce/README.md#view_content)


---
[戻る](../README.md#supported_events)

[トップ](../../README.md)
