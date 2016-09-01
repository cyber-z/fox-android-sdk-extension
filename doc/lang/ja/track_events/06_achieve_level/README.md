[TOP](../../README.md)　>　[イベント計測の詳細](../README.md)　>　AchieveLevel(レベルアップ)イベント実装

---

# AchieveLevel(レベルアップ)イベント実装

主にゲームアプリなどのレベルアップイベントが発生する箇所に、下記に従ってアクセス解析のイベント計測機能を実装ください。<br>
実装には[`AchievedLevelEvent`](../../sdk_api/event/AchievedLevelEvent.md)クラスを使用します。

### 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AchievedLevelEvent;

AchievedLevelEvent event = new AchievedLevelEvent(12345);
event.addUserId("USER_A001")
     .addEventLabel("MonthlyEvent")
     .addEventField(123)
     .addMainLevel(10)
     .addSubLevel(9)
     .addDescription("XXXXXXXXXXX")
FoxTrack.sendEvent(event);
```


### 連携対応済み媒体

* [ChartBoost](../cooperation_medias/Chartboost/README.md#ahieved_level)

---
[戻る](../README.md#supported_events)

[トップ](../../README.md)
