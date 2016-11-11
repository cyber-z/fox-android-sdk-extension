package co.cyberz.fox.support.firebase;

import co.cyberz.util.ids.XUniqHelper;

/**
 * Created by Amogh Rathore
 */


public class FirebaseHelper {

  /**
   * XuniqをStringで取得<br>
   * ローカルに保存されていなければnullを返す
   * @return
   */
  public static String getXuniq() {
    return XUniqHelper.getXuniq();
  }
}
