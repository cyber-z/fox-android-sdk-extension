# ViewToppageEvent

public class ViewToppageEvent

[java.lang.Object](https://developer.android.com/reference/java/lang/Object.html)<br>
　↳&nbsp;[co.cyberz.fox.FoxEvent](https://github.com/cyber-z/public-fox-android-sdk/blob/master/4.x/lang/ja/doc/sdk_api/README.md#foxevent)<br>
　　　↳&nbsp;[co.cyberz.fox.support.event.FoxBaseExtensionEvent](./FoxBaseExtensionEvent.md)<br>
　　　　　↳&nbsp;co.cyberz.fox.support.event.ViewToppageEvent

### Public constructors

|**Constructor**|**Details**|
|:---|:---|
|**ViewToppageEvent** ( )|イベント名はデフォルトで"_view_toppage"が設定されます。|
|**ViewToppageEvent** ( int ltvPointId ) <br><br> `ltvPointId` : LTV成果地点ID|・規定のイベント名を内部で定義しているため、媒体連携を行う場合はこちらのコンストラクターをお使いください。<br>・LTV成果地点IDは管理者が発行した値を指定ください。<br>・イベント名はデフォルトで"_view_toppage"が設定されます。|
|**ViewToppageEvent** ( String eventName, int ltvPointId ) <br><br> `eventName` : イベント名<br>`ltvPointId` : LTV成果地点ID|任意のイベント名を指定する場合にはこちらを使用ください。|

### Public methods

|**Return**|**Method**|**Details**|
|:---:|:---|:---|
|ViewToppageEvent|**addUserId** ( String id )<br><br>`id` : アプリ内のユーザーID|ユーザーIDを指定する場合に使用します。|
|ViewToppageEvent|**addDin** ( String din )<br><br>`din` : 日付 From|日付の指定のある場合に使用します。<br>Criteoとの連携を行う際に必要となります。|
|ViewToppageEvent|**addDout** ( String dout )<br><br>`dout` : 日付 To|日付の指定のある場合に使用します。<br>Criteoとの連携を行う際に必要となります。|
|ViewToppageEvent|**addCriteoPartnerId** ( String id )<br><br>`id` : CriteoアカウントID|Criteoとの連携を行う際に必要となります。CriteoアカウントIDが同一アプリで異なる場合は入力してください。|

---
[トップ](../../../README.md)
