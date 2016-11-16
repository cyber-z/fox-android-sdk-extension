[TOP](../README.md)　>　イベント計測の詳細

---

# イベント計測の詳細

以下、各種イベントを実装する際の詳細を説明します。<br>
F.O.Xによるエンゲージメント計測やダイナミック配信連携を行う際に必要となる実装も含まれます。本実装を行うことで、媒体を横断したイベント計測連携が可能となります。

* **[1. 従来の実装との差異(エンゲージメント計測)](#example)**
* **[2. 対応しているイベント計測](#supported_events)**
* **[3. 連携している媒体](#cooperation_medias)**


<div id="example"></div>
## 1. 従来の実装との差異(エンゲージメント計測)

これまでの媒体連携を目的としたイベント計測の実装を、本プラグインを利用することで簡易化することが可能となります。<br>
下記は課金イベントのエンゲージメント計測の実装例です。

**従来の実装例(Criteoにおける商品購入)**

```java
import org.json.JSONObject;
import co.cyberz.fox.Fox;
import co.cyberz.fox.service.FoxEvent;

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
FoxEvent purchaseEvent = new FoxEvent("_purchase", 12345);
purchaseEvent.buid = "USER_A001";
purchaseEvent.price = 2750;
purchaseEvent.quantity = 1;
purchaseEvent.orderId = "ABCDFE";
purchaseEvent.eventInfo = eventInfo;
Fox.trackEvent(purchaseEvent);
```

**本プラグインでの実装例**

```java
import co.cyberz.fox.Fox;
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
Fox.trackEvent(event);
```

<div id="supported_events"></div>
## 2. 対応しているイベント計測

プラグインでサポートしているイベントは以下の通りです。<br>

> #### 1. [ViewToppage(ホーム画面表示)イベント](./01_view_toppage/README.md)
> #### 2. [ViewListing(複数商品閲覧)イベント](./02_view_listing/README.md)
> #### 3. [ViewProduct(商品閲覧)イベント](./03_view_product/README.md)
> #### 4. [ViewBasket(買い物かご閲覧)イベント](./04_view_basket/README.md)
> #### 5. [TrackTransaction(商品購入)イベント](./05_track_transaction/README.md)
> #### 6. [AchieveLevel(レベルアップ)イベント](./06_achieve_level/README.md)
> #### 7. [ViewCategory(カテゴリページ)イベント](./07_view_category/README.md)
> #### 8. [TutorialCompletion(チュートリアル)イベント](./08_tutorial_completion/README.md)
> #### 9. [Search(検索)イベント](./09_search/README.md)

<div id="cooperation_medias"></div>
## 3. 連携している媒体

連携している媒体別での各種イベント計測の実装方法は以下を参照ください。<br>

**[媒体別実装方法]**

> #### ・[Facebook](./cooperation_medias/Facebook/README.md)
> #### ・[Twitter](./cooperation_medias/Twitter/README.md)
> #### ・[Chartboost](./cooperation_medias/Chartboost/README.md)
> #### ・[Criteo](./cooperation_medias/Criteo/README.md)
> #### ・[DynalystCommerce](./cooperation_medias/DynalystCommerce/README.md)
> #### ・[DynalystGames](./cooperation_medias/DynalystGames/README.md)
> #### ・[DynamicRemarketing](./cooperation_medias/DynamicRemarketing/README.md)
> #### ・[Vizury](./cooperation_medias/Vizury/README.md)

---
[トップ](../README.md)
