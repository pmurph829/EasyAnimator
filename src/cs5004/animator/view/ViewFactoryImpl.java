package cs5004.animator.view;

import cs5004.animator.model.canvas.ICanvas;

/** Implementation of the ViewFactory interface. */
public class ViewFactoryImpl implements ViewFactory {

  private final ICanvas canvas;

  /**
   * Constructor for the ViewFactoryImpl.
   *
   * @param c the canvas with all the view information.
   */
  public ViewFactoryImpl(ICanvas c) {
    this.canvas = c;
  }

  @Override
  public IView create(String viewType, String outFile, float delay) {
    try {
      switch (viewType) {
        case "text":
          return new TextView(this.canvas, outFile);
        case "svg":
          return new SVGView(this.canvas, outFile, delay);
        case "visual":
          return new VisualView(this.canvas, delay);
      }
      throw new IllegalArgumentException("No view was specified!");
    } catch (NullPointerException e) {
      System.out.println("Error creating view");
      e.printStackTrace();
      return null;
    }
  }
}
