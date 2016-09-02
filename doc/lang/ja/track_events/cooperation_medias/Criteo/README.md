[TOP](../../../README.md)　>　[イベント計測の詳細](../../README.md)　>　Criteoのイベント計測

---

# Criteoのイベント計測

Criteoにおけるイベント計測は以下の5つとなっています。

* [1. View Home(アプリトップ訪問イベント)実装方法](#view_toppage)
* [2. View Listing（複数商品閲覧イベント）実装方法](#view_listing)
* [3. View Product（商品閲覧イベント）実装方法](#view_content)
* [4. View Basket（買い物かご）実装方法](#add_to_cart)
* [5. Track Transaction（商品購入イベント）実装方法](#purchase)

---

<div id="view_toppage"></div>
## 1. View Home(アプリトップ訪問イベント)実装方法

ViewHome（ホーム画面）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。<br>

### 1.1 実装例

ViewHomeイベントの実装は[`ViewToppageEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewToppageEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewToppageEvent;
...

ViewToppageEvent event = new ViewToppageEvent(12345);
event.addUserId("USER_A001")
     .addCriteoPartnerId("XXXXX")
     .addDin("2016-01-02")
     .addDout("2016-01-05");
FoxTrack.sendEvent(event);
```

上記の実装で以下のJSON情報を生成し送信します。

```java
JSONObject eventInfo = new JSONObject("{" +
                                 "'din':'2016-01-02'," +
                                 "'dout':'2016-01-05'," +
                                 "'criteo_partner_id':'XXXXX'," +
                                 "'fox_cvpoint': '12345'" +
                                 "}");
```

### 1.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|din|String|日付の指定がある場合は入力（任意）|
|dout|String|日付の指定がある場合は入力（任意）|
|criteo_partner_id|String|CriteoアカウントIDが同一アプリで異なる場合は入力(任意)|


<div id="view_listing"></div>
## 2. View Listing（複数商品閲覧イベント）実装方法

　View Listing（検索結果・一覧画面）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。上位３つの商品が計測されます。

### 2.1 実装例

ViewListingイベントの実装は[`ViewListingEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewListingEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewListingEvent;
...

ViewListingEvent event = new ViewListingEvent(12345);
event.addUserId("USER_A001")
     .addCriteoPartnerId("XXXXX")
     .addDin("2016-01-02")
     .addDout("2016-01-05")
     .addProduct("111", null, "映画、ビデオ>DVD>スポーツ、レジャー", 0, 0)
     .addProduct("112", null, "映画、ビデオ>DVD>スポーツ、レジャー", 0, 0)
     .addProduct("113", null, "映画、ビデオ>DVD>スポーツ、レジャー", 0, 0);
FoxTrack.sendEvent(event);
```

上記の実装で以下のJSON情報を生成し送信します。

```java
JSONObject eventInfo = new JSONObject("{" +
                                 "'fox_cvpoint': '12345'," +
                                 "'product':[" +
                                        "{'id': '111'," +
                                        "'category':'映画、ビデオ>DVD>スポーツ、レジャー'}," +
                                        "{'id': '112'," +
                                         "'category':'映画、ビデオ>DVD>スポーツ、レジャー'}," +
                                        "{'id': '113'," +
                                         "'category':'映画、ビデオ>DVD>スポーツ、レジャー'}" +
                                 "]," +
                                 "'din':'2016-01-02'," +
                                 "'dout':'2016-01-05'," +
                                 "'criteo_partner_id':'XXXXX'" +
                                 "}");
```

### 2.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|product.id|String|商品IDを設定します。<br>データフィードと同じ商品IDを使⽤してください。|
|product.category|String|商品カテゴリを設定します。<br>データフィードと同じ商品カテゴリを使用してください。<br>１商品に対して複数カテゴリある場合はカンマ「,」区切り、階層がある場合は「>」で分割します。<br>例）映画、ビデオ>DVD>スポーツ、レジャーnullでも構いません。|
|din|String|⽇付の指定がある場合は⼊⼒してください。（任意）|
|dout|String|⽇付の指定がある場合は⼊⼒してください。（任意）|
|criteo_partner_id|String|Criteo アカウントID が同⼀アプリで異なる場合は⼊⼒(任意)|


<div id="view_content"></div>
## 3. View Product（商品閲覧イベント）実装方法

View Product（単一商品閲覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 3.1 実装例

ViewProductイベントの実装は[`ViewContentEvent`](/4.x/lang/ja/doc/sdk_api/extension/ViewContentEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.ViewContentEvent;
...

ViewContentEvent event = new ViewContentEvent(12345);
event.addUserId("USER_A001")
     .addCriteoPartnerId("XXXXX")
     .addDin("2016-01-02")
     .addDout("2016-01-05")
     .addProduct("111", null, null, 0, 0);
FoxTrack.sendEvent(event);
```

上記の実装で以下のJSON情報を生成し送信します。

```java
JSONObject eventInfo = new JSONObject("{" +
                                 "'fox_cvpoint':12345," +
                                 "'product':[{'id': '111'}]," +
                                 "'din':'2016-01-02'," +
                                 "'dout':'2016-01-05'," +
                                 "'criteo_partner_id':'XXXXX'" +
                                 "}");
```

### 3.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|product.id|String|商品IDを設定します。<br>データフィードと同じ商品IDを使⽤してください。|
|din|String|⽇付の指定がある場合は⼊⼒してください。（任意）|
|dout|String|⽇付の指定がある場合は⼊⼒してください。（任意）|
|criteo_partner_id|String|Criteo アカウントID が同⼀アプリで異なる場合は⼊⼒(任意)|


<div id="add_to_cart"></div>
## 4. View Basket（買い物かご）実装方法

　View Basket（商品購入予定一覧）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 4.1 実装例

ViewBasketイベントの実装は[`AddToCartEvent`](/4.x/lang/ja/doc/sdk_api/extension/AddToCartEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AddToCartEvent;
...

AddToCartEvent event = new AddToCartEvent(12345);
event.addUserId("USER_A001")
     .addCriteoPartnerId("XXXXX")
     .addCurrency("JPY")
     .addDin("2016-01-02")
     .addDout("2016-01-05")
     .addProduct("1234", null, null, 100, 1)
     .addProduct("3456", null, null, 200, 2)
     .addProduct("6789", null, null, 300, 3);
FoxTrack.sendEvent(event);
```

上記の実装で以下のJSON情報を生成し送信します。

```java
JSONObject eventInfo = new JSONObject("{" +
                                 "'currency':'JPY'," +
                                 "'fox_cvpoint':12345," +
                                 "'product':[" +
                                            "{'id':'1234','price':100,'quantity':1}," +
                                            "{'id':'3456','price':200,'quantity':2}," +
                                            "{'id':'6789','price':300,'quantity':3}" +
                                           "]," +
                                 "'din':'2016-01-02'," +
                                 "'dout':'2016-01-05'," +
                                 "'criteo_partner_id':'XXXXX'" +
                                 "}");
```

### 4.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:----------|:-----------:|:------------|
|currency|String|通貨<br>nullの場合、デフォルト “JPY”|
|product.id|String|商品IDを設定します。<br>データフィードと同じ商品IDを使⽤してください。|
|product.price|double|該当商品の価格を設定します。|
|product.quantity|int|該当商品を買った個数を設定します。|
|din|String|⽇付の指定がある場合は⼊⼒してください。（任意）|
|dout|String|⽇付の指定がある場合は⼊⼒してください。（任意）|
|criteo_partner_id|String|Criteo アカウントID が同⼀アプリで異なる場合は⼊⼒(任意)|

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

PurchaseEvent event = new PurchaseEvent(12345);
DataFeed df = new DataFeed();
df.addVersion("v1.0")
  .addProduct("12345",
              "U",
              "icecreame",
              "2016-04-01",
              "http://pngimg.com/upload/ice_cream_PNG5099.png",
              "food",
              null,
              null,
              2750,
              "JPY");
event.addTransactionId("ABCDFE")
     .addCriteoPartnerId("XXXXX")
     .addCurrency("JPY")
     .addDin("2016-01-02")
     .addDout("2016-01-05")
     .addProduct("1234", null, null, 550, 1)
     .addProduct("3456", null, null, 550, 2)
     .addProduct("6789", null, null, 550, 2)
     .addDataFeed(df);
FoxTrack.sendEvent(event);
```

上記の実装で以下のJSON情報を生成し送信します。

```java
JSONObject eventInfo = new JSONObject("{" +
                                      "'fox_cvpoint':'12345'," +
                                      "'transaction_id':'ABCDFE’," +
                                      "'product':[" +
                                                "{'id':'1234','price':550,'quantity':1}," +
                                                "{'id':'1235','price':550,'quantity':2}," +
                                                "{'id':'1236','price':550,'quantity':2}" +
                                                "]," +
                                      "'din':'2016-01-02'," +
                                      "'dout':'2016-01-05'," +
                                      "'criteo_partner_id':'XXXXX'" +
                                      "'datafeed' : {" +
                                                    "'version':'v1.0'," +
                                                    "'product':[" +
                                                               "{" +
                                                                "'id':'12345'" +
                                                                "'action':'U'" +
                                                                "'name':'icecreame'" +
                                                                "'expire':'2016-10-31'" +
                                                                "'effective':'2016-04-01'" +
                                                                "'img':'http://pngimg.com/upload/ice_cream_PNG5099.png'" +
                                                                "'category1':'food'" +
                                                                "'price':'2750'" +
                                                                "'currency':'JPY'"
                                                               "}"
                                                              "]" +
                                                    "}" +
                                      "}");
```

### 5.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventInfo (transaction.id)|JSONObject|注文番号、問い合わせ番号などのトランザクションID|
|eventInfo (product)|JSONArray|Product をキーとして商品IDを配列で設定します。
|product.id|String|商品IDを設定します。<br>データフィードと同じ商品IDを使⽤してください。|
|product.price|double|該当商品の価格を設定します。|
|product.quantity|int|該当商品を買った個数を設定します。|
|din|String|⽇付の指定がある場合は⼊⼒してください。（任意）|
|dout|String|⽇付の指定がある場合は⼊⼒してください。（任意）|
|criteo_partner_id|String|Criteo アカウントID が同⼀アプリで異なる場合は⼊⼒(任意)|
|datafeed|JSONObject|リアルタイムデータフィード (以下参照)|

### 5.3 データフィード詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|version|String|データフィードのバージョンを指定します。|
|product.id|String|データフィードのアイテムを一意に識別するIDです。|
|product.action|String|データフィードをどのように変更するかを入力します。<br>U:追加もしくは編集　D:削除|
|product.name|String|アイテム名です。<br>以下全て、削除の際はnullで構いません。|
|product.expire|String|アイテムの有効期限です。<br>「yyyy-MM-dd HH:mm:ss」もしくは「yyyy-MM-dd」の書式で日付を入力してください。nullでも構いません。|
|product.effective|String|アイテムの公開日時です。<br>これが設定された場合、公開日時になるまで商品はでません表示されません。<br>「yyyy-MM-dd HH:mm:ss」もしくは「yyyy-MM-dd」の書式で日付を入力してください。nullでも構いません。|
|product.img|String|アイテムの画像URLです。<br>nullでも構いません。|
|product.category1|String|第一階層のカテゴリを指定します。<br>nullでも構いません。|
|product.category2|String|第二階層のカテゴリを指定します。<br>nullでも構いません。|
|product.category3|String|第三階層のカテゴリを指定します。<br>nullでも構いません。|
|product.price)|double|アイテムの価格を指定します。<br>nullでも構いません。|
|product.currency)|String|アイテムの通貨コードを指定します。<br>nullの場合、JPYが適用されます。|
|product.{*任意*})|String|その他配信、分析に使用する項目を指定します。|

> ※ 商品購⼊イベントの price に⼊⼒する⾦額は必ず、Json データに指定した商品の総額 (price * quantity)となるよう指定してください。指定されていない場合、集計が正しく⾏われません。

---
[戻る](../../README.md#cooperation_medias)

[トップ](../../../README.md)
