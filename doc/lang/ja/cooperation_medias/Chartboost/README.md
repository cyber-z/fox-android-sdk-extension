[TOP](../../README.md)　>　[イベント計測の詳細](../../track_events/README.md)　>　Chartboostのイベント計測

---

# Chartboostのイベント計測

Chartboostにおけるイベント計測は以下の2つとなっています。

* [1. Purchase（課金イベント）実装方法](#purchase)
* [2. AchievedLevel（Levelアップイベント）実装方法](#ahieved_level)

---

<div id="purchase"></div>
## 1. Purchase（課金イベント）実装方法

課金イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください<br>

### 1.1 実装例

Purchase（商品購入）イベントは[`PurchaseEvent`](/4.x/lang/ja/doc/sdk_api/extension/PurchaseEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;
...

PurchaseEvent event = new PurchaseEvent(12345, itemName, 250, "JPY", 1, sku);
event.addUserId("USER_A001")
     .addLocalizedTitle("XXXXX")
     .addLocalizedDescription("XXXXXX")
     .addReceiptValid(false)
     .addReceipt("XXXXXXX");
FoxTrack.sendEvent(event);
```

GooglePlayから発行されるオブジェクトを引数に課金計測を行う

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;
...

IInAppBillingService mService;
Bundle skuDetails;

...
  // 商品情報の取得例
  skuDetails = mService.getSkuDetails(3, getPackageName(), "inapp", querySkus);

...

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (requestCode == 1001) {
    // 課金計測
    PurchaseEvent event = new PurchaseEvent(12345, skuDetails);
    event.addUserId("USER_A001")
         .addReceiptValid(false)
         .addReceipt("XXXXXXX")
         .setPurchaseData(data);
    FoxTrack.sendEvent(event);
  }

}
...
```

### 1.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_purchase"を指定してください。<br>上記の例の場合、PurchaseEventクラスでデフォルトで設定されています。|
|price|double|(必須)価格|
|quantity|int|(必須)個数|
|currency|String|(必須)通貨<br>[`ISO 4217`](http://ja.wikipedia.org/wiki/ISO_4217)で定義された通貨コードを指定してください。|
|localizeTitle|String|購入アイテムの名称|
|localizeDescription|String|購入アイテムの説明|
|receiptValid|boolean|Receiptの妥当性判定を実施有無|
|receipt|String|Storeから発行された文字列|


<div id="ahieved_level"></div>
## 2. AchievedLevel（Levelアップイベント）実装方法

レベルアップイベントが発生する箇所に、下記に従ってアクセス解析のイベント計測機能を実装してください。

### 2.1 実装例

AchievedLevel(レベルアップ)イベントは[`AchievedLevelEvent`](/4.x/lang/ja/doc/sdk_api/extension/AchievedLevelEvent.md)クラスを使用します。

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.AchievedLevelEvent;
...

AchievedLevelEvent event = new AchievedLevelEvent(12345);
event.addUserId("USER_A001")
     .addTrackInfo("XXXXX", XX, XX, XX, "XXXXXXXXXX");
FoxTrack.sendEvent(event);
```

### 2.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_ahieved_level"を指定してください。<br>上記の例の場合、AchievedLevelEventクラスでデフォルトで設定されています。|
|eventLabel|String|（必須）ゲーム内のイベント名称|
|eventField|int|（必須）イベントに対応するID<br>詳細は[Chartboostのサイト](http://partners.chartboost.com/#general-event-tracking-information)を参照|
|mainLevel|int|（必須）メインレベル|
|subLevel|int|（必須）サブレベル|
|description|String|（必須）レベルの説明|


---
[戻る](../../track_events/README.md#cooperation_medias)

[トップ](../../README.md)
