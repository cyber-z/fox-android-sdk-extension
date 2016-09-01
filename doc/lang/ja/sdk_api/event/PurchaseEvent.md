# PurchaseEvent

public class PurchaseEvent

[java.lang.Object](https://developer.android.com/reference/java/lang/Object.html)<br>
　↳&nbsp;[co.cyberz.fox.FoxEvent](https://github.com/cyber-z/public-fox-android-sdk/blob/master/4.x/lang/ja/doc/sdk_api/README.md#foxevent)<br>
　　　↳&nbsp;[co.cyberz.fox.support.event.FoxBaseExtensionEvent](./FoxBaseExtensionEvent.md)<br>
　　　　　↳&nbsp;co.cyberz.fox.support.event.PurchaseEvent

### Public constructors

|**Constructor**|**Details**|
|:---|:---|
|**PurchaseEvent** ( Bundle skuDetails ) <br><br>・`skuDetails` : Storeに登録している商品リスト|・`skuDetails`は課金が可能な商品であるかのクエリ送信後のレスポンスを[`getSkuDetails`](https://developer.android.com/google/play/billing/billing_integrate.html#QueryDetails)で取得したBundleを引数とします。<br>・イベント名はデフォルトで"_purchase"が設定されます。|
|**PurchaseEvent** ( int ltvPointId, Bundle skuDetails ) <br><br>・`ltvPointId` : LTV成果地点ID<br>・`skuDetails` : Storeに登録している商品リスト|・`skuDetails`は課金が可能な商品であるかのクエリ送信後のレスポンスを[`getSkuDetails`](https://developer.android.com/google/play/billing/billing_integrate.html#QueryDetails)で取得したBundleを引数とします。<br>・イベント名はデフォルトで"_purchase"が設定されます。|
|**PurchaseEvent** ( String eventName, int ltvPointId, Bundle skuDetails ) <br><br>・`eventName` : イベント名<br>・`ltvPointId` : LTV成果地点ID<br>・`skuDetails` : Storeに登録している商品リスト|・`skuDetails`は課金が可能な商品であるかのクエリ送信後のレスポンスを[`getSkuDetails`](https://developer.android.com/google/play/billing/billing_integrate.html#QueryDetails)で取得したBundleを引数とします。|
|**PurchaseEvent** ( String itemName, double price, String currency, int quantity, String sku ) <br><br> ・`itemName` : 商品名<br>・`price` : 商品価格<br>・`currency` : 通貨<br>・`quantity` : 個数<br>・`sku` : 商品管理ID|・currencyは[`ISO 4217`](http://ja.wikipedia.org/wiki/ISO_4217)で定義された通貨コードを指定してください。<br>・イベント名はデフォルトで"_purchase"が設定されます。|
|**PurchaseEvent** ( int ltvPointId, String itemName, double price, String currency, int quantity, String sku ) <br><br> ・`ltvPointId` : LTV成果地点ID<br>・`itemName` : 商品名<br>・`price` : 商品価格<br>・`currency` : 通貨<br>・`quantity` : 個数<br>・`sku` : 商品管理ID|・currencyは[`ISO 4217`](http://ja.wikipedia.org/wiki/ISO_4217)で定義された通貨コードを指定してください。<br>・イベント名はデフォルトで"_purchase"が設定されます。|
|**PurchaseEvent** ( String eventName, int ltvPointId, String itemName, double price, String currency, int quantity, String sku ) <br><br> ・`eventName` : イベント名<br>・`ltvPointId` : LTV成果地点ID<br>・`itemName` : 商品名<br>・`price` : 商品価格<br>・`currency` : 通貨<br>・`quantity` : 個数<br>・`sku` : 商品管理ID|・currencyは[`ISO 4217`](http://ja.wikipedia.org/wiki/ISO_4217)で定義された通貨コードを指定してください。<br>・任意のイベント名を指定する場合にはこちらを使用ください。|


### Public methods

|**Return**|**Method**|**Details**|
|:---:|:---|:---|
|PurchaseEvent|**addUserId** ( String id )<br><br>`id` : アプリ内のユーザーID|ユーザーIDを指定する場合に使用します。|
|PurchaseEvent|**addItemId** ( String id )<br><br>`id` : アイテムID|アイテムIDを指定する場合に使用します。<br>・addProductメソッドを使用する場合は呼び出さなくて結構です。<br>・Facebook・Twitterとの連携を行う際に必要となります。|
|PurchaseEvent|**addCurrency** ( String currency )<br><br>`currency` : 通貨|商品価格の通貨を指定する場合に使用します。<br>[`ISO 4217`](http://ja.wikipedia.org/wiki/ISO_4217)で定義された通貨コードを指定してください。|
|PurchaseEvent|**addDin** ( String din )<br><br>`din` : 日付 From|日付の指定のある場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|PurchaseEvent|**addDout** ( String dout )<br><br>`dout` : 日付 To|日付の指定のある場合に使用します。<br>Criteo・DynamicRemarketingとの連携を行う際に必要となります。|
|PurchaseEvent|**addDestination** ( String destination )<br><br>`destination` : 行き先(目的地)|旅行アプリなど目的地を指定する場合に使用します。<br>DynamicRemarketingとの連携を行う際に必要となります。|
|PurchaseEvent|**addOrigin** ( String origin )<br><br>`origin` : 出発地点|旅行アプリなど出発地点を指定する場合に使用します。<br>DynamicRemarketingとの連携を行う際に必要となります。|
|PurchaseEvent|**addLocalizedTitle** ( String title )<br><br>`title` : 商品タイトル|GooglePlayのStoreに登録されている商品のタイトルを指定します。<br>Chartboostとの連携を行う際に必要となります。|
|PurchaseEvent|**addLocalizedDescription** ( String description )<br><br>`description` : 商品の詳細|GooglePlayのStoreに登録されている商品の詳細を指定します。<br>Chartboostとの連携を行う際に必要となります。|
|PurchaseEvent|**addReceiptValid** ( String valid )<br><br>`valid` : レシートの妥当性チェック有無|商品を購入後のレシート情報の妥当性判定を実施するかの有無を指定します。<br>Chartboostと連携を行う際に必要となります。|
|PurchaseEvent|**addReceipt** ( String receipt )<br><br>`receipt` : Storeから発行された文字列|商品を購入後に発行された文字列を指定します。<br>Chartboostと連携を行う際に必要となります。|
|PurchaseEvent|**addProduct** ( int id, String itemLocationId, String category, String category, double price, String currency )<br><br>・`id` : 商品ID<br>・`itemLocationId` : ロケーションID(商品の広告を特定の場所や地域に訴求したい場合に設定)<br>・`category` : カテゴリー<br>・`price` : 商品の価格<br>`currency` : 通貨|購入した商品の情報を指定する場合に使用します。<br>currencyは[`ISO 4217`](http://ja.wikipedia.org/wiki/ISO_4217)で定義された通貨コードを指定してください。<br>Criteo・DynamicRemarketing・Vizury・Dynalystとの連携を行う際に必要となります。|
|void|**setPurchaseData** ( Intent data )<br><br>`data` : 課金完了データ|課金完了後にGooglePlayからのレスポンスを受信したonActivityResult内にてコールします。<br>引数には購入情報が含まれているIntentを指定してください。<br>[詳細はこちら](https://developer.android.com/google/play/billing/billing_integrate.html#Purchase)の実装をご参照ください。|
|PurchaseEvent|**addCriteoPartnerId** ( String id )<br><br>`id` : CriteoアカウントID|Criteoとの連携を行う際に必要となります。CriteoアカウントIDが同一アプリで異なる場合は入力してください。|
|PurchaseEvent|**addDataFeed** ( JSONObject dataFeed )<br><br>`dataFeed` : リアルタイムデータフィード|Criteoとの連携を行う際に必要となります。|
|PurchaseEvent|**addCategoryId** ( String id )<br><br>`id` : カテゴリID|商品のカテゴリIDを指定します。<br>Vizuryと連携を行う際に必要となります。|
|PurchaseEvent|**addTransactionId** ( String id )<br><br>`id` : 成果ポストバック用トランザクションID|DynalystCommerceと連携を行う際に必要となります。|


---
[トップ](../../../README.md)
