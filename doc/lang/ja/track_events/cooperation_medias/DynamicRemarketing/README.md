[TOP](../../../README.md)　>　[イベント計測の詳細](../../README.md)　>　DynamicRemarketingのイベント計測

---

# DynamicRemarketingのイベント計測

DynamicRemarketingにおけるイベント計測は以下の5つとなっています。

* [1. LaunchApp（アプリ起動イベント）実装方法](#launch_app)
* [2. Search（検索イベント）実装方法](#search)
* [3. View Listing（商品一覧表示イベント）実装方法](#view_listing)
* [4. View Product（商品表示イベント）実装方法](#view_content)
* [5. Add To Cart（カード追加イベント）実装方法](#add_to_cart)
* [6. Purchase（課金イベント）](#puchase)

---

<div id="launch_app"></di>
## 1. LaunchApp（アプリ起動イベント）実装方法

LaunchApp（アプリ起動）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。<br>

### 1.1 実装例

```java
import co.cyberz.fox.FoxTrack;

@Override
protected void onResume() {
	super.onResume();
  // 起動イベント計測
  JSONObject userInfo = new JSONObject();
  userInfo.put("_google_crm_id", "XXXXXXXX");
  FoxTrack.setUserInfo(userInfo);
  FoxTrack.session();
}
```

<div id="search"></div>
## 2. Search（検索イベント）実装方法

Search（検索）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。<br>

### 2.1 実装例

Searchイベントの実装は[`SearchEvent`](/4.x/lang/ja/doc/sdk_api/extension/SearchEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.SearchEvent;
...

SearchEvent event = new SearchEvent(12345);
event.addUserId("USER_A001")
     .addSearchTerm("XXXXXX")
     .addDestination("XXXXX")
     .addOrigin("XXXXXXXX")
     .addDin("YYYY-MM-DD")
     .addDout("YYYY-MM-DD")
     .addProduct("XXXX", "XXXXX", null, 0, 0);
FoxTrack.sendEvent(event);
```

### 2.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_search"を指定してください。<br>上記の例の場合、SearchEventクラスでデフォルトで設定されています。|
|searchTerm|String|検索文字列|
|destination|String|（必須）行先（旅行アプリなどで指定する場合）|
|origin|String|出発地点（旅行アプリなどで指定する場合）|
|din|String|日付　From　日付指定のある場合は入力|
|dout|String|日付　To　日付指定のある場合は入力|
|product.id|String|（必須）商品ID|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）|
|product.category|String|カテゴリ<br>※ここでは不要です。|
|product.price|double|商品価格<br>※ここでは不要です。|
|product.quantity|int|商品個数<br>※ここでは不要です。|


<div id="view_listing"></div>
## 3. View Listing（商品一覧表示イベント）実装方法]

　View Listing（検索結果・一覧画面）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 3.1 実装例

ViewListingイベントの実装は[`ViewListingEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewListingEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewListingEvent;
...

ViewListingEvent event = new ViewListingEvent(12345);
event.addUserId("USER_A001")
     .addDestination("XXXXX")
     .addOrigin("XXXXXXXX")
     .addDin("YYYY-MM-DD")
     .addDout("YYYY-MM-DD")
     .addProduct("XXX", "XXXXXX", null, 0, 0);
FoxTrack.sendEvent(event);
```

### 3.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|eventName|String|（必須）"_view_listing"を指定してください。<br>上記の例の場合、ViewListingEventクラスでデフォルトで設定されています。|
|destination|String|（必須）行先（旅行アプリなどで指定する場合）|
|origin|String|出発地点（旅行アプリなどで指定する場合）|
|din|String|⽇付の指定がある場合は⼊⼒してください。|
|dout|String|⽇付の指定がある場合は⼊⼒してください。|
|product.id|String|商品IDを設定します。|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）|
|product.category|String|カテゴリ<br>※ここでは不要です。|
|product.price|double|商品価格<br>※ここでは不要です。|
|product.quantity|int|商品個数<br>※ここでは不要です。|

<div id="view_content"></div>
## 4. View Product（商品表示イベント）実装方法]

View Product（商品表示）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 4.1 実装例

ViewProductイベントの実装は[`ViewContentEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewContentEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewContentEvent;
...

ViewContentEvent event = new ViewContentEvent(12345);
event.addUserId("USER_A001")
     .addDestination("XXXXX")
     .addOrigin("XXXXXXXX")
     .addDin("2016-01-02")
     .addDout("2016-01-05")
     .addProduct("XXX", "XXXXXX", null, 0, 0);
FoxTrack.sendEvent(event);
```

### 4.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|必須）"_view_content"を指定してください。<br>上記の例の場合、ViewContentEventクラスでデフォルトで設定されています。|
|destination|String|（必須）行先（旅行アプリなどで指定する場合）|
|origin|String|出発地点（旅行アプリなどで指定する場合）|
|din|String|⽇付の指定がある場合は⼊⼒してください。|
|dout|String|⽇付の指定がある場合は⼊⼒してください。|
|product.id|String|商品IDを設定します。|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）|
|product.category|String|カテゴリ<br>※ここでは不要です。|
|product.price|double|商品価格<br>※ここでは不要です。|
|product.quantity|int|商品個数<br>※ここでは不要です。|


<div id="add_to_cart"></div>
## 5. Add To Cart（カード追加イベント）実装方法]

AddToCart（カート追加）イベントが発生する箇所に、下記に従ってイベント計測機能を実装してください。

### 5.1 実装例

AddToCartイベントの実装は[`AddToCartEvent`](/4.x/lang/ja/doc/sdk_api/extension/AddToCartEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AddToCartEvent;
...

AddToCartEvent event = new AddToCartEvent(12345);
event.addUserId("USER_A001")
     .addDestination("XXXXX")
     .addOrigin("XXXXXXXX")
     .addDin("2016-01-02")
     .addDout("2016-01-05")
     .addProduct("XXX", "XXXXXX", null, 0, 0);
FoxTrack.sendEvent(event);
```

### 5.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_add_to_cart"を指定してください。<br>上記の例の場合、AddToCartEventクラスでデフォルトで設定されています。|
|destination|String|（必須）行先（旅行アプリなどで指定する場合）|
|origin|String|出発地点（旅行アプリなどで指定する場合）|
|din|String|⽇付の指定がある場合は⼊⼒してください。|
|dout|String|⽇付の指定がある場合は⼊⼒してください。|
|product.id|String|商品IDを設定します。|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）|
|product.category|String|カテゴリ<br>※ここでは不要です。|
|product.price|double|商品価格<br>※ここでは不要です。|
|product.quantity|int|商品個数<br>※ここでは不要です。|

<div id="puchase"></div>
## 6. Purchase（課金イベント）]

Purchase（商品購入）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 6.1 実装例

Purchase（商品購入）イベントは[`PurchaseEvent`](/4.x/lang/ja/doc/sdk_api/extension/PurchaseEvent.md)クラスを使用します。


```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;
...

PurchaseEvent event = new PurchaseEvent(12345);
event.addUserId("USER_A001")
     .addDestination("XXXXX")
     .addOrigin("XXXXXXXX")
     .addDin("2016-01-02")
     .addDout("2016-01-05")
     .addProduct("XXX", "XXXXXX", null, 1500, 1);
FoxTrack.sendEvent(event);
```

### 6.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_purchase"を指定してください。<br>上記の例の場合、PurchaseEventクラスでデフォルトで設定されています。|
|destination|String|（必須）行先（旅行アプリなどで指定する場合）|
|origin|String|出発地点（旅行アプリなどで指定する場合）|
|din|String|⽇付の指定がある場合は⼊⼒してください。|
|dout|String|⽇付の指定がある場合は⼊⼒してください。|
|product.id|String|商品IDを設定します。<br>※商品情報は複数指定不可|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）<br>※商品情報は複数指定不可|
|product.category|String|カテゴリ<br>ここでは不要です。|
|product.price|double|商品価格<br>※商品情報は複数指定不可|
|product.quantity|int|商品個数<br>※商品情報は複数指定不可|


---
[戻る](../../README.md#cooperation_medias)

[トップ](../../../README.md)
