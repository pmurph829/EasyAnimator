package cs5004.animator.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import cs5004.animator.model.canvas.ICanvas;

public abstract class AbstractTextView implements IView, TextView {

  protected ICanvas canvas;
  protected JFrame frame;
  protected JPanel panel;
  protected JScrollPane scrollPane;
  protected String text;
  protected float delay;

  /**
   * Super constructor for a TextView.
   *
   * @param canvas the canvas object containing the shape and transformation data.
   * @param delay
   */
  public AbstractTextView(ICanvas canvas, String outFile, float delay) {
    this.canvas = canvas;
    this.delay = delay;
    this.text = this.generateText(delay);

    if (outFile != null) {
      this.createFile(outFile);
    }

    this.frame = new JFrame("Easy Animator Text");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextArea textArea = new JTextArea(this.text);
    textArea.setEditable(false);

    this.scrollPane = new JScrollPane(textArea);
    this.frame.add(this.scrollPane);

    this.frame.pack();
    this.frame.setVisible(true);
  }

  @Override
  public void createFile(String filename) {
    // creates .txt file for Text and .xml file for SVG
    try {
      FileWriter newFile = new FileWriter(filename);

      BufferedWriter writer = new BufferedWriter(newFile);
      writer.write(this.text);

      writer.close();
    } catch (IOException e) {
      System.out.println("Error occurred.");
      e.printStackTrace();
    }
  }
}
