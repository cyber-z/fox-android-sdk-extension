package co.cyberz.fox.support.event;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.cyberz.fox.support.event.media.IChartBoost;
import co.cyberz.fox.support.util.StringUtil;

/**
 * Created by Garhira on 16/07/23.
 */
public class AchievedLevelEvent extends FoxBaseExtensionEvent implements IChartBoost {

  private JSONArray trackInfo;

  public AchievedLevelEvent() {
    this(0);
  }

  public AchievedLevelEvent(int ltvPointId) {
    this("_achieved_level", ltvPointId);
  }

  public AchievedLevelEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
    trackInfo = new JSONArray();
  }


  public AchievedLevelEvent addUserId(String id) {
    this.buid = id;
    addParam("user_id", id);
    return this;
  }

  public AchievedLevelEvent addItemId(String id) {
    this.sku = id;
    addParam("item_id", id);
    return this;
  }

  @Override
  public AchievedLevelEvent addTrackInfo(String eventLabel, int eventField, String mainLevel, String subLevel, String description) {
    try {
      JSONObject jo = new JSONObject();
      jo.put("event_label", StringUtil.nvl(eventLabel));
      jo.put("event_field", StringUtil.nvl(eventField));
      jo.put("main_level", StringUtil.nvl(mainLevel));
      jo.put("sub_level", StringUtil.nvl(subLevel));
      jo.put("description", StringUtil.nvl(description));
      jo.put("data_type", "level_info");
      trackInfo.put(jo);
      addParam("track_info", trackInfo);
    } catch(JSONException e) {
      Log.e("", e.getMessage());
    }
    return this;
  }

  @Override
  public AchievedLevelEvent addLocalizedTitle(String title) {
    return this;
  }

  @Override
  public AchievedLevelEvent addLocalizedDescription(String description) {
    return this;
  }

  @Override
  public AchievedLevelEvent addReceiptValid(boolean valid) {
    return this;
  }

  @Override
  public AchievedLevelEvent addReceipt(String receipt) {
    return this;
  }

}
