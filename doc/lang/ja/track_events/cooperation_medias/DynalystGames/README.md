[TOP](../../../README.md)　>　[イベント計測の詳細](../../README.md)　>　DynalystGamesのイベント計測

---

# DynalystGamesのイベント計測

DynalysGamesにおけるイベント計測は以下の5つとなっています。

* [1. LaunchApp（アプリ起動イベント）実装方法](#launch_app)
* [2. CompleteTutorial（チュートリアル完了イベント）実装方法](#comp_tutorial)
* [3. Purchase（課金イベント）](#puchase)
* [4. PurchasePage（課金ページイベント）](#puchase_page)
* [5. UserInfo（ユーザー情報通知イベント）](#user_info)

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

  JSONObject ext = new JSONObject();
  ext.put("XXXX", "XXXXXXX")
     .put("XX", "XXXXXXXXX");
  JSONObject userInfo = new JSONObject();
  userInfo.put("guid", "XXXXXXX");
          .put("adnt", 0)
          .put("ext", ext);
  FoxTrack.setUserInfo(userInfo);
  FoxTrack.session();
}  
```

### 1.2 イベント情報詳細

**UserInfo(JSONObject)**

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|guid|String|（任意）ゲームユーザID|
|gdnt|int|アプリオプトアウト。オプトアウトする場合は`1`、指定しない場合は`0`を設定してください。|
|ext|JSONObject|（任意）ユーザーデータ。具体的な値はDynalystにご相談ください。|

<div id="comp_tutorial"></div>
## 2. CompleteTutorial（チュートリアル完了イベント）実装方法

CompleteTutorial（チュートリアル完了）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 2.1 実装例

CompleteTutorialイベントの実装は[`CompleteTutorialEvent`](/4.x/lang/ja/doc/sdk_api/extension/CompleteTutorialEvent.md)クラスを使用します。

```java
import co.cyberz.fox.support.event.CompleteTutorialEvent;
import co.cyberz.fox.FoxTrack;

JSONObject ext = new JSONObject();
ext.put("XXXX", "XXXXXXX")
   .put("XX", "XXXXXXXXX");
JSONObject userInfo = new JSONObject();
userInfo.put("guid", "XXXXXXX")
        .put("ext", ext);
FoxTrack.setUserInfo(userInfo);
CompleteTutorialEvent event = new CompleteTutorialEvent(12345);
FoxTrack.sendEvent(event);
```

### 2.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_tutorial_comp"を指定してください。<br>上記の例の場合、CompleteTutorialEventクラスでデフォルトで設定されています。|

**UserInfo(JSONObject)**

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|guid|String|（任意）ゲームユーザID|
|ext|JSONObject|（任意）ユーザーデータ。具体的な値はDynalystにご相談ください。|

<div id="puchase"></div>
## 3. Purchase（課金イベント）]

Purchase（商品購入）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 3.1 実装例

Purchase（商品購入）イベントは[`PurchaseEvent`](/4.x/lang/ja/doc/sdk_api/extension/PurchaseEvent.md)クラスを使用します。


```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.support.event.PurchaseEvent;
...

JSONObject ext = new JSONObject();
ext.put("XXXX", "XXXXXXX")
   .put("XX", "XXXXXXXXX");
JSONObject userInfo = new JSONObject();
userInfo.put("guid", "XXXXXXX")
        .put("ext", ext);
FoxTrack.setUserInfo(userInfo);

PurchaseEvent event = new PurchaseEvent(12345, null, 250, "JPY", 1, null);
event.addUserId("USER_A001");
FoxTrack.sendEvent(event);
```

### 3.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_purchase"を指定してください。<br>上記の例の場合、PurchaseEventクラスでデフォルトで設定されています。|
|price|double|（必須）商品価格|
|currency|String|（必須）通貨|
|quantity|int|（必須）商品個数|

**UserInfo(JSONObject)**

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|guid|String|（任意）ゲームユーザID|
|ext|JSONObject|（任意）ユーザーデータ。具体的な値はDynalystにご相談ください。|



<div id="puchase_page"></div>
## 4. PurchasePage（課金ページイベント）

PurchasePage（課金ページ）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 4.1 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.service.FoxEvent;

JSONObject ext = new JSONObject();
ext.put("XXXX", "XXXXXXX")
   .put("XX", "XXXXXXXXX");
JSONObject userInfo = new JSONObject();
userInfo.put("guid", "XXXXXXX")
        .put("ext", ext);
FoxTrack.setUserInfo(userInfo);

JSONObject eventInfo = new JSONObject();
// dynalyst_advertiser_idを設定
eventInfo("dynalyst_advertiser_id", "XXXXXXXXXXXXXXX");
// イベント名, LTV成果地点ID
FoxEvent event = new FoxEvent("_purchase_shop", 12345);
event.eventInfo = eventInfo;
FoxTrack.sendEvent(event);
```

### 4.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_purchase_shop"を指定してください。|

**UserInfo(JSONObject)**

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|guid|String|（任意）ゲームユーザID|
|ext|JSONObject|（任意）ユーザーデータ。具体的な値はDynalystにご相談ください。|

**EventInfo(JSONObject)**

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|dynalyst_advertiser_id|JSONObject|（必須）Dynalystから発行されるID|


<div id="user_info"></div>
## 5. UserInfo（ユーザー情報通知イベント）

UserInfo（ユーザー情報通知）イベントが発生する箇所に、下記に従ってイベント計測機能を実装ください。

### 5.1 実装例

```java
import co.cyberz.fox.FoxTrack;
import co.cyberz.fox.service.FoxEvent;

JSONObject ext = new JSONObject();
ext.put("XXXX", "XXXXXXX")
   .put("XX", "XXXXXXXXX");
JSONObject userInfo = new JSONObject();
userInfo.put("guid", "XXXXXXX")
        .put("ext", ext);
FoxTrack.setUserInfo(userInfo);
// イベント名, LTV成果地点ID
FoxEvent event = new FoxEvent("_user_info", 12345);
event.eventInfo = eventInfo;
FoxTrack.sendEvent(event);
```

### 5.2 イベント情報詳細

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|eventName|String|（必須）"_user_info"を指定してください。|

**UserInfo(JSONObject)**

| 引数 | 型 | 概要 |
|:---|:---:|:---|
|guid|String|（任意）ゲームユーザID|
|ext|JSONObject|（必須）ユーザーデータ。具体的な値はDynalystにご相談ください。|


---
[戻る](../../README.md#cooperation_medias)

[トップ](../../../README.md)
