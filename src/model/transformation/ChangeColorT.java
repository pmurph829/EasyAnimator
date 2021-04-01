package model.transformation;
import model.shape.Shape;
import java.awt.*;

/**
 * Changes the color of a Shape over a specified range of frames.
 */
public class ChangeColorT extends AbstractTransformation {

  private Color startColor;
  private Color endColor;

  /**
   * Constructor for the ChangeColorT class.
   * @param shape the initial Shape object.
   * @param startFrame the starting frame of the transformation.
   * @param endFrame the ending frame of the transformation.
   * @param initialColor the starting color of the Shape.
   * @param finalColor the ending color of the Shape.
   */
  public ChangeColorT(Shape shape, int startFrame, int endFrame,
                      Color initialColor, Color finalColor) {
    super(shape, startFrame, endFrame);
    this.startColor = initialColor;
    this.endColor = finalColor;
  }

  private String toStringHelp(int r, int g, int b) {
    return String.format("(%d, %d, %d)", r, g, b);
  }

  @Override
  public String toString() {
    String start = toStringHelp(startColor.getRed(), startColor.getGreen(), startColor.getBlue());
    String end = toStringHelp(endColor.getRed(), endColor.getGreen(), endColor.getBlue());
    return super.toString("changes color", start, end);
  }

  @Override
  public Shape executeAtFrame(int frame) {
    if (frame < 0) {
      throw new IllegalArgumentException("Frame cannot be negative.");
    }
    int newR = this.getValueAtFrame(frame, this.startColor.getRed(), this.endColor.getRed());
    int newG = this.getValueAtFrame(frame, this.startColor.getGreen(), this.endColor.getGreen());
    int newB = this.getValueAtFrame(frame, this.startColor.getBlue(), this.endColor.getBlue());

    this.shape.setColor(newR, newG, newB);

    return this.shape;
  }
}
