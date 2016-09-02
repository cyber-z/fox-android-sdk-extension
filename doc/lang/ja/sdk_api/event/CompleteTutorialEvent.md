# CompleteTutorialEvent

public class CompleteTutorialEvent

[java.lang.Object](https://developer.android.com/reference/java/lang/Object.html)<br>
　↳&nbsp;[co.cyberz.fox.FoxEvent](https://github.com/cyber-z/public-fox-android-sdk/blob/master/4.x/lang/ja/doc/sdk_api/README.md#foxevent)<br>
　　　↳&nbsp;[co.cyberz.fox.support.event.FoxBaseExtensionEvent](./FoxBaseExtensionEvent.md)<br>
　　　　　↳&nbsp;co.cyberz.fox.support.event.CompleteTutorialEvent

### Public constructors

|**Constructor**|**Details**|
|:---|:---|
|**CompleteTutorialEvent** ( )|イベント名はデフォルトで"_tutorial_comp"が設定されます。|
|**CompleteTutorialEvent** ( int ltvPointId ) <br><br> `ltvPointId` : LTV成果地点ID|・規定のイベント名を内部で定義しているため、媒体連携を行う場合はこちらをお使いください。<br>・イベント名はデフォルトで"_tutorial_comp"が設定されます。<br>・LTV成果地点IDは管理者が発行した値を指定ください。|
|**CompleteTutorialEvent** ( String eventName, int ltvPointId ) <br><br> `eventName` : イベント名<br>`ltvPointId` : LTV成果地点ID|任意のイベント名を指定する場合にはこちらを使用ください。|


### Public methods

|**Return**|**Method**|**Details**|
|:---:|:---|:---|
|CompleteTutorialEvent|**addUserId** ( String id )<br><br>`id` : アプリ内のユーザーID|ユーザーIDを指定する場合に使用します。|
|CompleteTutorialEvent|**addItemId** ( String id )<br><br>`id` : アイテムID|アイテムIDを指定する場合に使用します。|


---
[トップ](../../README.md)
