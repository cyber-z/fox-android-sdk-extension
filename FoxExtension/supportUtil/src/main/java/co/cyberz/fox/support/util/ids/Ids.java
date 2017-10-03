package co.cyberz.fox.support.util.ids;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import co.cyberz.fox.support.util.ids.imei.Imei;

/**
 * Created by Garhira on 2017/08/24.
 */
public class Ids {

    public static Map<String, String> getMap(Context c) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("_imei", getImei(c));
        return map;
    }

    /**
     * IMEIの取得
     * @param c
     * @return
     */
    public static String getImei(Context c) {
        return Imei.get(c);
    }

}
