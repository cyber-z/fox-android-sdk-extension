[TOP](../../README.md)　>　[イベント計測の詳細](../README.md)　>　ViewCategory(カテゴリページ)イベント実装

---

# ViewCategory(カテゴリページ)イベント実装

イベントが発生する箇所に、下記に従ってアクセス解析のイベント計測機能を実装ください。<br>
実装には[`ViewCategoryEvent`](../../sdk_api/event/ViewCategoryEvent.md)クラスを使用します。

### 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewCategoryEvent;

ViewCategoryEvent event = new ViewCategoryEvent(12345);
event.addUserId("USER_A001")
     .addCategoryId("furniture")
FoxTrack.sendEvent(event);
```

### 連携対応済み媒体

* [Vizury](../cooperation_medias/Vizury/README.md#view_category)

---
[戻る](../README.md#supported_events)

[トップ](../../README.md)
