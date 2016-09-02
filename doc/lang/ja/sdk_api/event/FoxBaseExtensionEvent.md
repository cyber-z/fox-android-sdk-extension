# FoxBaseExtensionEvent

public class FoxBaseExtensionEvent

[java.lang.Object](https://developer.android.com/reference/java/lang/Object.html)<br>
　↳&nbsp;[co.cyberz.fox.FoxEvent](https://github.com/cyber-z/public-fox-android-sdk/blob/master/4.x/lang/ja/doc/sdk_api/README.md#foxevent)<br>
　　　↳&nbsp;co.cyberz.fox.support.event.FoxBaseExtensionEvent

### Public constructors

|**Constructor**|
|:---|:---|
|**FoxBaseExtensionEvent** (String eventName, int ltvPointId)<br><br>`eventName` : イベント名<br>`ltvPointId` : LTV成果地点ID|

### Public methods

|**Return**|**Method**|**Details**|
|:---:|:---|:---|
|FoxBaseExtensionEvent|**addProduct** ( JSONObject product )<br><br>`product` : 商品情報のJSON|イベント計測に必要となる商品情報を格納したJSONObjectを追加する。|
|FoxBaseExtensionEvent|**addParam** ( String key, String value )<br><br>・`key` : パラメータ名<br>・`value` : パラメータ値|任意のKey/Valueを追加する|
|FoxBaseExtensionEvent|**addParam** ( String key, double value )<br><br>・`key` : パラメータ名<br>・`value` : パラメータ値|任意のKey/Valueを追加する|
|FoxBaseExtensionEvent|**addParam** ( String key, boolean value )<br><br>・`key` : パラメータ名<br>・`value` : パラメータ値|任意のKey/Valueを追加する|
|FoxBaseExtensionEvent|**addParam** ( String key, JSONObject value )<br><br>・`key` : パラメータ名<br>・`value` : パラメータ値|任意のKey/Valueを追加する|
|FoxBaseExtensionEvent|**addParam** ( String key, JSONArray value )<br><br>・`key` : パラメータ名<br>・`value` : パラメータ値|任意のKey/Valueを追加する|

---
[戻る](../../track_events/README.md)

[トップ](../../README.md)
