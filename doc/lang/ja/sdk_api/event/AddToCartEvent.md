# AddToCartEvent

public class AddToCartEvent

[java.lang.Object](https://developer.android.com/reference/java/lang/Object.html)<br>
　↳&nbsp;[co.cyberz.fox.FoxEvent](https://github.com/cyber-z/public-fox-android-sdk/blob/master/4.x/lang/ja/doc/sdk_api/README.md#foxevent)<br>
　　　↳&nbsp;[co.cyberz.fox.support.event.FoxBaseExtensionEvent](./FoxBaseExtensionEvent.md)<br>
　　　　　↳&nbsp;co.cyberz.fox.support.event.AddToCartEvent

### Public constructors

|**Constructor**|**Details**|
|:---|:---|
|**AddToCartEvent** ( )|イベント名はデフォルトで"_add_to_cart"が設定されます。|
|**AddToCartEvent** ( int ltvPointId ) <br><br> `ltvPointId` : LTV成果地点ID|・規定のイベント名を内部で定義しているため、媒体連携を行う場合はこちらをお使いください。<br>・イベント名はデフォルトで"_add_to_cart"が設定されます。<br>・LTV成果地点IDは管理者が発行した値を指定ください。|
|**AddToCartEvent** ( String eventName, int ltvPointId ) <br><br> ・`eventName` : イベント名<br>・`ltvPointId` : LTV成果地点ID|任意のイベント名を指定する場合にはこちらを使用ください。|


### Public methods

|**Return**|**Method**|**Details**|
|:---:|:---|:---|
|AddToCartEvent|**addUserId** ( String id )<br><br>`id` : アプリ内のユーザーID|ユーザーIDを指定する場合に使用します。|
|AddToCartEvent|**addItemId** ( String id )<br><br>`id` : アイテムID|アイテムIDを指定する場合に使用します。<br>・addProductメソッドを使用する場合は呼び出さなくて結構です。<br>・Facebook・Twitterとの連携を行う際に必要となります。|
|AddToCartEvent|**addCurrency** ( String currency )<br><br>`currency` : 通貨|商品の価格の通貨を指定する場合に使用します。<br>・Criteoとの連携を行う際に必要となります。<br>・[`ISO 4217`](http://ja.wikipedia.org/wiki/ISO_4217)で定義された通貨コードを指定してください。|
|AddToCartEvent|**addDin** ( String din )<br><br>`din` : 日付 From|日付の指定のある場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|AddToCartEvent|**addDout** ( String dout )<br><br>`dout` : 日付 To|日付の指定のある場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|AddToCartEvent|**addDestination** ( String destination )<br><br>`destination` : 行き先(目的地)|旅行アプリなど目的地を指定する場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|AddToCartEvent|**addOrigin** ( String origin )<br><br>`Origin` : 出発地点|旅行アプリなど出発地点を指定する場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|AddToCartEvent|**addProduct** ( int id, String itemLocationId, String category, double price, int quantity )<br><br>・`id` : 商品ID<br>・`itemLocationId` : ロケーションID(商品の広告を特定の場所や地域に訴求したい場合に設定)<br>・`category` : 商品のカテゴリ<br>・`price` : 商品の価格<br>・`quantity` : 個数|閲覧した商品の情報を指定する場合に使用します。<br>Criteo・DynamicRemarketing・Dynalystとの連携を行う際に必要となります。|
|AddToCartEvent|**addCategoryId** ( String id )<br><br>`id` : カテゴリID|商品のカテゴリIDを指定します。<br>Vizuryと連携を行う際に必要となります。|
|AddToCartEvent|**addCriteoPartnerId** ( String id )<br><br>`id` : CriteoアカウントID|Criteoとの連携を行う際に必要となります。CriteoアカウントIDが同一アプリで異なる場合は入力してください。|

---
[トップ](../../../README.md)
