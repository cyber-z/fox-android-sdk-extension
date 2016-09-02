# ViewCategoryEvent

public class ViewCategoryEvent

[java.lang.Object](https://developer.android.com/reference/java/lang/Object.html)<br>
　↳&nbsp;[co.cyberz.fox.FoxEvent](https://github.com/cyber-z/public-fox-android-sdk/blob/master/4.x/lang/ja/doc/sdk_api/README.md#foxevent)<br>
　　　↳&nbsp;[co.cyberz.fox.support.event.FoxBaseExtensionEvent](./FoxBaseExtensionEvent.md)<br>
　　　　　↳&nbsp;co.cyberz.fox.support.event.ViewCategoryEvent

### Public constructors

|**Constructor**|**Details**|
|:---|:---|
|**ViewCategoryEvent** ( )|イベント名はデフォルトで"_view_category"が設定されます。|
|**ViewCategoryEvent** ( int ltvPointId ) <br><br> `ltvPointId` : LTV成果地点ID|・規定のイベント名を内部で定義しているため、媒体連携を行う場合はこちらをお使いください。<br>・イベント名はデフォルトで"_view_category"が設定されます。<br>・LTV成果地点IDは管理者が発行した値を指定ください。|
|**ViewCategoryEvent** ( String eventName, int ltvPointId ) <br><br> `eventName` : イベント名<br>`ltvPointId` : LTV成果地点ID|こちらはコンストラクターです。任意のイベント名を指定する場合にはこちらを使用ください。|


### Public methods

|**Return**|**Method**|**Details**|
|:---:|:---|:---|
|ViewCategoryEvent|**addUserId** ( String id )<br><br>`id` : アプリ内のユーザーID|ユーザーIDを指定する場合に使用します。|
|ViewCategoryEvent|**addCategoryId** ( String id )<br><br>`id` : カテゴリID|閲覧したカテゴリIDを指定する場合に使用します。<br>Vizuryと連携を行う際に必要となります。|


---
[トップ](../../README.md)
