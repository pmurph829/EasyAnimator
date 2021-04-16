package cs5004.animator.view;

public interface AnimationView {

  void reset();

  void play();

  void pause();

  void playFromFrame(float frame, float speed, boolean reverse); // might get rid of the speed?
}
