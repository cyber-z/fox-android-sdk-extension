package co.cyberz.fox.support.util.ids;

import android.content.Context;

import co.cyberz.fox.support.util.ids.imei.Imei;

/**
 * Created by Garhira on 2017/08/24.
 */
public class Ids {

    /**
     * IMEIの取得
     * @param c
     * @return
     */
    public static String getImei(Context c) {
        return Imei.get(c);
    }


}
