[TOP](../../../README.md)　>　[イベント計測の詳細](../../README.md)　>　Twitterのイベント計測

---

# Twitterのイベント計測

Twitterにおけるイベント計測は以下の5つとなっています。

* [1. View Product（商品閲覧イベント）実装方法](#view_content)
* [2. View Basket（買い物かご）実装方法](#add_to_cart)
* [3. AchievedLevel（Levelアップイベント）実装方法](#ahieved_level)
* [4. CompleteTutorial（チュートリアル完了イベント）実装方法](#comp_tutorial)
* [5. Track Transaction（商品購入イベント）実装方法](#purchase)

---

<div id="view_content"></div>
## 1. View Product（商品閲覧イベント）実装方法

View Product（単一商品閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 1.1 実装例

ViewProductイベントの実装は[`ViewContentEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewContentEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewContentEvent;
...

ViewContentEvent event = new ViewContentEvent(12345);
event.addUserId("USER_A001")
     .addProduct("111", null, null, 0, 0)
FoxTrack.sendEvent(event);
```

### 1.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|product.id|String|商品IDを設定します。|


<div id="add_to_cart"></div>
## 2. View Basket（買い物かご）実装方法

　View Basket（商品購入予定一覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 2.1 実装例

ViewBasketイベントの実装は[`AddToCartEvent`](/4.x/lang/ja/doc/sdk_api/extension/AddToCartEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AddToCartEvent;
...

AddToCartEvent event = new AddToCartEvent(12345);
event.addUserId("USER_A001")
     .addProduct("1234", null, null, 100, 1)
     .addProduct("3456", null, null, 200, 2)
     .addProduct("6789", null, null, 300, 3);
FoxTrack.sendEvent(event);
```

上記の実装で以下のJSON情報を生成し送信します。

```java
JSONObject eventInfo = new JSONObject("{" +
                                 "'fox_cvpoint':12345," +
                                 "'product':[" +
                                            "{'id':'1234','price':100,'quantity':1}," +
                                            "{'id':'3456','price':200,'quantity':2}," +
                                            "{'id':'6789','price':300,'quantity':3}" +
                                           "]," +
                                 "}");
```

### 2.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|product.id|String|商品IDを設定します。|
|product.price|double|該当商品の価格を設定します。|
|product.quantity|int|該当商品を買った個数を設定します。|

<div id="ahieved_level"></div>
## 3. AchievedLevel（Levelアップイベント）実装方法

レベルアップイベントが発生する箇所に、下記に従ってアクセス解析のイベント計測機能を実装してください。

### 3.1 実装例

AchievedLevel(レベルアップ)イベントは[`AchievedLevelEvent`](/4.x/lang/ja/doc/sdk_api/extension/AchievedLevelEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AchievedLevelEvent;
...

AchievedLevelEvent event = new AchievedLevelEvent(12345);
event.addUserId("USER_A001")
     .addTrackInfo(null, 0, 5, 0, null);
FoxTrack.sendEvent(event);
```

### 3.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|trackInfo.mainLevel|int|メインレベル|

<div id="comp_tutorial"></div>
## 4. CompleteTutorial（チュートリアル完了イベント）実装方法

CompleteTutorial（チュートリアル完了）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 4.1 実装例

CompleteTutorialイベントの実装は[`CompleteTutorialEvent`](/4.x/lang/ja/doc/sdk_api/extension/CompleteTutorialEvent.md)クラスを使用します。

```java
import co.cyberz.fox.support.event.CompleteTutorialEvent;
import co.cyberz.fox.FoxTrack;

CompleteTutorialEvent event = new CompleteTutorialEvent(12345);
JSONObject json = new JSONObject();
json.put("id", "item_id1");

event.addUserId("USER_A001")
     .addProduct(json);
FoxTrack.sendEvent(event);
```
### 4.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|product.id|String|商品IDを設定します。|

<div id="purchase"></div>
## 5. Track Transaction（商品購入イベント）実装方法

Track Transaction（商品購入）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 5.1 実装例

TrackTransactionイベントの実装は[`PurchaseEvent`](/4.x/lang/ja/doc/sdk_api/extension/PurchaseEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;
import co.cyberz.fox.support.event.json.DataFeed;
...

PurchaseEvent event = new PurchaseEvent(12345, null, 250, "JPY", 1, null);
JSONObject json = new JSONObject();
json.put("id", "item_id1");

event.addUserId("USER_A001")
     .addProduct(json);
FoxTrack.sendEvent(event);
```

### 5.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|product.id|String|商品IDを設定します。|

> ※ 商品購⼊イベントの price に⼊⼒する⾦額は必ず、Json データに指定した商品の総額 (price * quantity)となるよう指定してください。指定されていない場合、集計が正しく⾏われません。

---
[戻る](../../README.md#cooperation_medias)

[トップ](../../../README.md)
