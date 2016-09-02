package co.cyberz.fox.support.event;

/**
 * Created by Garhira on 16/07/23.
 */
public class CompleteTutorialEvent extends FoxBaseExtensionEvent {

  public CompleteTutorialEvent() {
    this(0);
  }

  public CompleteTutorialEvent(int ltvPointId) {
    this("_tutorial_comp", ltvPointId);
  }

  public CompleteTutorialEvent(String eventName, int ltvPointId) {
    super(eventName, ltvPointId);
  }

  public CompleteTutorialEvent addUserId(String userId) {
    this.buid = userId;
    addParam("user_id", userId);
    return this;
  }

  public CompleteTutorialEvent addItemId(String itemId) {
    this.label = itemId;
    addParam("item_id", itemId);
    return this;
  }

}
