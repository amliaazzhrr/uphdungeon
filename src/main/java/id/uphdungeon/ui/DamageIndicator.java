package id.uphdungeon.ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class DamageIndicator {
  String text;
  int x, y;
  int lifetimeFrame;
  float alpha = 1.0f;
  int yOffset = 0;

  public DamageIndicator(String text, int x, int y) {
    this.text = text;
    this.x = x;
    this.y = y;
    this.lifetimeFrame = 60; // 1 s @ 60 FPS
  }

  public void update() {
    lifetimeFrame--;
    yOffset++;
    y--;

    if (lifetimeFrame < 30) {
      alpha = lifetimeFrame / 30.0f;
    }
  }

  public void draw(Graphics2D g2) {
    g2.setFont(new Font("Arial", Font.BOLD, 14));
    int stringWidth = g2.getFontMetrics().stringWidth(text);

    // center text
    int drawX = x - (stringWidth / 2);

    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    g2.setColor(Color.RED);
    g2.drawString(text, drawX, y);
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f)); // reset alpha
  }

  public boolean isFinished() {
    return lifetimeFrame <= 0;
  }
}
