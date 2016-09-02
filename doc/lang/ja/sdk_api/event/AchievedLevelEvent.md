# AchievedLevelEvent

public class AchievedLevelEvent

[java.lang.Object](https://developer.android.com/reference/java/lang/Object.html)<br>
　↳&nbsp;[co.cyberz.fox.FoxEvent](https://github.com/cyber-z/public-fox-android-sdk/blob/master/4.x/lang/ja/doc/sdk_api/README.md#foxevent)<br>
　　　↳&nbsp;[co.cyberz.fox.support.event.FoxBaseExtensionEvent](./FoxBaseExtensionEvent.md)<br>
　　　　　↳&nbsp;co.cyberz.fox.support.event.AchievedLevelEvent

### Public constructors

|**Constructor**|**Details**|
|:---|:---|
|**AchievedLevelEvent** ( )|イベント名はデフォルトで"_achieved_level"が設定されます。|
|**AchievedLevelEvent** ( int ltvPointId ) <br><br> `ltvPointId` : LTV成果地点ID|・規定のイベント名を内部で定義しているため、媒体連携を行う場合はこちらをお使いください。<br>・イベント名はデフォルトで"_achieved_level"が設定されます。<br>・LTV成果地点IDは管理者が発行した値を指定ください。|
|**AchievedLevelEvent** ( String eventName, int ltvPointId ) <br><br> ・`eventName` : イベント名<br>・`ltvPointId` : LTV成果地点ID|任意のイベント名を指定する場合にはこちらを使用ください。|


### Public methods

|**Return**|**Method**|**Details**|
|:---:|:---|:---|
|AchievedLevelEvent|**addUserId** ( String id )<br><br>`id` : アプリ内のユーザーID|ユーザーIDを指定する場合に使用します。|
|AchievedLevelEvent|**addItemId** ( String id )<br><br>`id` : アイテムID|アイテムIDを指定する場合に使用します。<br>Facebook・Twitterとの連携を行う際に必要となります。|
|AchievedLevelEvent|**addTrackInfo** ( String eventLabel, int eventField, int mainLevel, int subLevel, String description) <br><br>・`eventLabel` : ゲーム内のイベント名称<br>・`eventField` : イベントに対するID<br>・`mainLevel` : メインレベル<br>・`subLevel` : サブレベル<br>・`description` : レベルの説明|複数の指定が可能です。<br>`eventField`の詳細は[Chartboostのサイト](http://partners.chartboost.com/#general-event-tracking-information)を参照|


---
[トップ](../../README.md)
