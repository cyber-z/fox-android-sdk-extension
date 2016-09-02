[TOP](../../README.md)　>　[イベント計測の詳細](../README.md)　>　TutorialCompletion(チュートリアル完了)イベント実装

---

# TutorialCompletion(チュートリアル完了)イベント実装

チュートリアルイベントが完了したタイミングで、下記に従ってアクセス解析のイベント計測機能を実装ください。<br>
実装には[`CompleteTutorialEvent`](../../sdk_api/event/CompleteTutorialEvent.md)クラスを使用します。

### 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.CompleteTutorialEvent;

CompleteTutorialEvent event = new CompleteTutorialEvent(12345);
event.addUserId("USER_A001");
FoxTrack.sendEvent(event);
```


### 連携対応済み媒体

* [DynalystGames](../cooperation_medias/DynalystGames/README.md#comp_tutorial)

---
[戻る](../README.md#supported_events)

[トップ](../../README.md)
