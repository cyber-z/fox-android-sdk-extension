[TOP](../../../README.md)　>　[イベント計測の詳細](../../README.md)　>　Vizuryのイベント計測

---

# Vizuryのイベント計測

Vizuryにおけるイベント計測は以下の5つとなっています。

* [1. View Home（アプリトップ訪問イベント）実装方法](#view_toppage)
* [2. View Category（カテゴリページ閲覧イベント）実装方法](#view_category)
* [3. View Content（詳細ページ閲覧イベント）実装方法](#view_content)
* [4. Add To Cart（カート追加イベント）実装方法](#add_to_cart)
* [5. Purchase（課金イベント）実装方法](#purchase)

---

<div id="view_toppage"></div>
## 1. View Home（アプリトップ訪問イベント）実装方法

ViewHome（ホーム画面）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。<br>

### 1.1 実装例

ViewHomeイベントの実装は[`ViewToppageEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewToppageEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewToppageEvent;
...

ViewToppageEvent event = new ViewToppageEvent(12345);
FoxTrack.sendEvent(event);
```

### 1.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_view_toppage"を指定してください。<br>上記の例の場合、ViewToppageEventクラスでデフォルトで設定されています。|


<div id="view_category"></div>
## 2. View Category（カテゴリページ閲覧イベント）実装方法

ViewCategory（カテゴリページ閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 2.1 実装例

ViewCategoryイベントの実装は[`ViewCategoryEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewCategoryEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewCategoryEvent;
...

ViewCategoryEvent event = new ViewCategoryEvent(12345);
event.addUserId("USER_A001")
     .addCategoryId("furniture")
FoxTrack.sendEvent(event);
```

### 2.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_view_category"を指定してください。<br>上記の例の場合、ViewCategoryEventクラスでデフォルトで設定されています。|
|categoryId|String|カテゴリID|

<div id="view_content"></div>
## 3. View Content（詳細ページ閲覧イベント）実装方法

ViewContent（詳細ページ閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 3.1 実装例

ViewContentイベントの実装は[`ViewContentEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewContentEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewContentEvent;
...

ViewContentEvent event = new ViewContentEvent(12345);
event.addUserId("USER_A001")
     .addCategoryId("furniture")
     .addProduct("111", null, null, 0, 0);
FoxTrack.sendEvent(event);
```

### 3.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_view_content"を指定してください。<br>上記の例の場合、ViewContentEventクラスでデフォルトで設定されています。|
|categoryId|String|カテゴリID|
|product.id|String|商品ID<br>※商品情報は複数指定不可|


<div id="add_to_cart"></div>
## 4. Add To Cart（カート追加イベント）実装方法

AddToCart（カート追加）イベントが発生する箇所に、下記に従ってイベント計測機能を実装してください。

### 4.1 実装例

AddToCartイベントの実装は[`AddToCartEvent`](/4.x/lang/ja/doc/sdk_api/extension/AddToCartEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AddToCartEvent;
...

AddToCartEvent event = new AddToCartEvent(12345);
event.addUserId("USER_A001")
     .addCategoryId("furniture")
     .addProduct("111", null, null, 0, 0)
     .addProduct("121", null, null, 0, 0);
FoxTrack.sendEvent(event);
```

### 4.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_add_to_cart"を指定してください。<br>上記の例の場合、AddToCartEventクラスでデフォルトで設定されています。|
|categoryId|String|カテゴリID|
|product.id|String|商品ID<br>※商品情報は最大３つまで指定可能|

<div id="purchase"></div>
## 5. Purchase（課金イベント）実装方法

Purchase（商品購入）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 5.1 実装例

Purchase（商品購入）イベントは[`PurchaseEvent`](/4.x/lang/ja/doc/sdk_api/extension/PurchaseEvent.md)クラスを使用します。


```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;
...

PurchaseEvent event = new PurchaseEvent(12345);
event.addUserId("USER_A001")
     .addCategoryId("furniture")
     .addTransactionId("ABCDFE")
     .addProduct("111", null, null, 1500, 1);
FoxTrack.sendEvent(event);
```

### 5.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_purchase"を指定してください。<br>上記の例の場合、PurchaseEventクラスでデフォルトで設定されています。|
|categoryId|String|カテゴリID|
|transactionId|String|購入イベントを特定するID|
|product.id|String|商品ID<br>※商品情報は複数指定不可|


---
[戻る](../../README.md#cooperation_medias)

[トップ](../../../README.md)
