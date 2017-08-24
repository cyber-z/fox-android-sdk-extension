package co.cyberz.fox.support.ids.imei;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by Garhira on 2017/08/24.
 */
public class Imei {

    public static String get(Context context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
        if (manager != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                return manager.getDeviceId();
            } else {
                return manager.getImei();
            }
        }
        return "";
    }
}
