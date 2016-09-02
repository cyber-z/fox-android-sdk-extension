[TOP](../../README.md)　>　[イベント計測の詳細](../README.md)　>　Search(検索)イベント実装

---

# Search(検索)イベント実装

検索イベントが発生する箇所で、下記に従ってアクセス解析のイベント計測機能を実装ください。<br>
実装には[`SearchEvent`](../../sdk_api/event/SearchEvent.md)クラスを使用します。

### 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.SearchEvent;

SearchEvent event = new SearchEvent(12345);
event.addUserId("USER_A001");
     .addSearchTerm("XXXXXX")
     .addDestination("XXXXX")
     .addDin("YYYY-MM-DD")
     .addDout("YYYY-MM-DD")
     .addProduct("XXXX", "XXXXX", "XXXXX", 120, 1);
FoxTrack.sendEvent(event);
```


### 連携対応済み媒体

* [DynamicRemaketing](../cooperation_medias/DynamicRemarketing/README.md#search)
* [DynalystCommerce](../cooperation_medias/DynalystCommerce/README.md#search)

---
[戻る](../README.md#supported_events)

[トップ](../../README.md)
