[TOP](../../README.md)　>　[イベント計測の詳細](../../track_events/README.md)　>　DynalystCommerceのイベント計測

---

# DynalystCommerceのイベント計測

DynalystCommerceにおけるイベント計測は以下の6つとなっています。

* [1. Item View（商品閲覧イベント）実装方法](#view_content)
* [2. Conversion（商品購入イベント）実装方法](#purchase)
* [3. Cart View（カート閲覧イベント）実装方法](#add_to_cart)
* [4. Home View（トップページ閲覧イベント）実装方法](#view_toppage)
* [5. Catalog View（商品一覧閲覧イベント）実装方法](#view_listing)
* [6. Search View（検索閲覧イベント）実装方法](#search)

---

<div id="view_content"></div>
1. Item View（商品閲覧イベント）実装方法

Item View（商品閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 1.1 実装方法

Item Viewイベントの実装は[`ViewContentEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewContentEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewContentEvent;
...

ViewContentEvent event = new ViewContentEvent(12345);
event.addUserId("USER_A001")
     .addProduct("XXX", null, null, 0, 0);
FoxTrack.sendEvent(event);
```

### 1.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|必須）"_view_content"を指定してください。<br>上記の例の場合、ViewContentEventクラスでデフォルトで設定されています。|
|product.id|String|商品IDを設定します。|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）|
|product.category|String|カテゴリ<br>※ここでは不要です。|
|product.price|double|商品価格<br>※ここでは不要です。|
|product.quantity|int|商品個数<br>※ここでは不要です。|


<div id="purchase"></div>
## 2. Conversion（商品購入イベント）実装方法]

Conversion（商品購入）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 2.1 実装例

Conversion（商品購入）イベントは[`PurchaseEvent`](/4.x/lang/ja/doc/sdk_api/extension/PurchaseEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;
...

PurchaseEvent event = new PurchaseEvent(12345);
event.addUserId("USER_A001")
     .addTransactionId("XXXXXXXXXXX")
     .addProduct("XXX", null, null, 250, 1);
FoxTrack.sendEvent(event);
```

### 2.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_purchase"を指定してください。<br>上記の例の場合、PurchaseEventクラスでデフォルトで設定されています。|
|transactionId|String|成果ポストバック⽤トランザクションID|
|product.id|String|（必須）商品IDを設定します。<br>※商品情報は複数指定不可|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）<br>ここでは不要です。|
|product.category|String|カテゴリ<br>ここでは不要です。|
|product.price|double|商品価格<br>※商品単価×個数の合計値となるよう指定|
|product.quantity|int|商品個数<br>※必ず`1`を指定|

<div id="add_to_cart"></div>
## 3. Cart View（カート閲覧イベント）実装方法

Cart View（カート閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装してください。

### 3.1 実装例

Cart Viewイベントの実装は[`AddToCartEvent`](/4.x/lang/ja/doc/sdk_api/extension/AddToCartEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AddToCartEvent;
...

AddToCartEvent event = new AddToCartEvent(12345);
event.addUserId("USER_A001")
     .addProduct("XXX", null, null, 250, 1);
FoxTrack.sendEvent(event);
```


### 2.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_add_to_cart"を指定してください。<br>上記の例の場合、AddToCartEventクラスでデフォルトで設定されています。|
|product.id|String|（必須）商品IDを設定します。<br>※商品情報は複数指定不可|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）<br>ここでは不要です。|
|product.category|String|カテゴリ<br>ここでは不要です。|
|product.price|double|商品価格<br>※商品単価×個数の合計値となるよう指定|
|product.quantity|int|商品個数<br>※必ず`1`を指定|


<div id="view_toppage"></div>
## 4. Home View（トップページ閲覧イベント）実装方法

Home Viewイベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 4.1 実装例

Home Viewイベントの実装は[`ViewToppageEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewToppageEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewToppageEvent;
...

ViewToppageEvent event = new ViewToppageEvent(12345);
FoxTrack.sendEvent(event);
```


### 4.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_view_toppage"を指定してください。<br>上記の例の場合、ViewToppageEventクラスでデフォルトで設定されています。|


<div id="view_listing"></div>
## 5. Catalog View（商品一覧閲覧イベント）実装方法

Catalog View（商品一覧閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 5.1 実装例

Catalog Viewイベントの実装は[`ViewListingEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewListingEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewListingEvent;
...

ViewListingEvent event = new ViewListingEvent(12345);
event.addUserId("USER_A001")
     .addProduct("XXX", null, null, 0, 0);
FoxTrack.sendEvent(event);
```

### 5.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|eventName|String|（必須）"_view_listing"を指定してください。<br>上記の例の場合、ViewListingEventクラスでデフォルトで設定されています。|
|product.id|String|（必須）商品IDを設定します。|
|product.itemLocationId|String|ロケーションID（商品の広告を特定の場所や地域に訴求したい場合に設定）<br>※ここでは不要です。|
|product.category|String|カテゴリ<br>※ここでは不要です。|
|product.price|double|商品価格<br>※ここでは不要です。|
|product.quantity|int|商品個数<br>※ここでは不要です。|


<div id="search"></div>
## 6. Search View（検索閲覧イベント）実装方法

Search View（検索閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 6.1 実装例

Search Viewイベントの実装は[`SearchEvent`](/4.x/lang/ja/doc/sdk_api/extension/SearchEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.SearchEvent;
...

SearchEvent event = new SearchEvent(12345);
event.addUserId("USER_A001")
FoxTrack.sendEvent(event);
```

### 6.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|eventName|String|（必須）"_search"を指定してください。<br>上記の例の場合、SearchEventクラスでデフォルトで設定されています。|


---
[戻る](../../track_events/README.md#cooperation_medias)

[トップ](../../README.md)
