package co.cyberz.fox.support.event.json;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Garhira on 16/07/29.
 */
public class UserInfo extends JSONObject {

  private JSONObject extraInfo = new JSONObject();

  public void addUserId(String userId) throws JSONException {
    put("user_id", userId);
  }

  public void addExtraInfo(String key, String value) throws JSONException {
    this.extraInfo.put(key, value);
  }

  @Override
  public String toString() {
    try {
      if (extraInfo != null && 0 < extraInfo.length()) put("ext", extraInfo);
    } catch (JSONException e) {

    }
    return super.toString();
  }
}
