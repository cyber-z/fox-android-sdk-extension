package co.cyberz.fox.support.event.json;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import co.cyberz.util.string.StringUtil;


/**
 * Created by Garhira on 16/08/05.
 */
public class DataFeed extends JSONObject {

  public DataFeed addVersion(String version) {
    try {
      put("version", version);
    } catch (JSONException e) {
      Log.e("DataFeed addVersion", e.getMessage());
    }
    return this;
  }

  public DataFeed addProduct(String id, String action, String name, String expire, String effective, String img, String category1, String category2, String category3, double price, String currency) {
    return addProduct(id, action, name, expire, effective, img, category1, category2, category3, price, currency, null);
  }

  public DataFeed addProduct(String id, String action, String name, String expire, String effective, String img, String category1, String category2, String category3, double price, String currency, HashMap<String, String> params) {
    JSONObject jo = new JSONObject();
    try {
      jo.put("id", StringUtil.nvl(id)).put("action", StringUtil.nvl(action)).put("name", StringUtil.nvl(name)).put("expire", StringUtil.nvl(expire)).put("effective", StringUtil.nvl(effective)).put("img", StringUtil.nvl(img)).put("price", StringUtil.nvl(price)).put("currency", StringUtil.nvl(currency));
      if (!StringUtil.isEmpty(category1)) jo.put("ccategory1", StringUtil.nvl(category1));
      if (!StringUtil.isEmpty(category2)) jo.put("ccategory2", StringUtil.nvl(category2));
      if (!StringUtil.isEmpty(category3)) jo.put("ccategory3", StringUtil.nvl(category3));
      if (params != null && 0 < params.size()) {
        for(Map.Entry<String, String> p : params.entrySet()) {
          jo.put(p.getKey(), p.getValue());
        }
      }
    }catch(JSONException e) {
      Log.e("DataFeed addProduct", e.getMessage());
    }
    return addProduct(jo);
  }

  public DataFeed addProduct(JSONObject product) {

    try {
      JSONArray ja = this.getJSONArray("product");
      if (ja == null) {
        ja = new JSONArray().put(product);
      } else {
        ja.put(product);
      }
      put("product", ja);
    } catch (JSONException e) {
      Log.e("DataFeed addProduct", e.getMessage());
    }
    return this;
  }
}
