package io.github.nelsoncrosby.qsui.components

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 * A component that contains text
 */
abstract class UITextComponent extends UIComponent {
    UITextComponent() {
    }

    UITextComponent(Rectangle bounds, String text, Vector2f textPos) {
        this(bounds, text, textPos, null);
    }

    UITextComponent(Rectangle bounds, String text, Vector2f textPos, Font font) {
        super(bounds);
        this.text = text;
        this.textPos = textPos
        this.font = font;
    }

    @Override
    void render(GameContainer gc, StateBasedGame game, Graphics gx) throws SlickException {
        Font before = gx.font
        if (font != null) gx.font = font
        gx.drawString(text, bounds.x+textPos.x as float, bounds.y+textPos.y as float)
        gx.font = before
    }

    String text;
    Vector2f textPos;
    Font font;

    /**
     *
     */
    static abstract class Builder<T extends UITextComponent> extends UIComponent.Builder<T> {
        Builder<T> text(String text) {
            inst.text = text
            return this;
        }

        Builder<T> textPos(Vector2f textPos) {
            inst.textPos = textPos
            return this;
        }

        Builder<T> font(Font font) {
            inst.font = font
            return this;
        }

        @Override
        T build() {
            if (inst.bounds == null) {
                inst.bounds = new Rectangle(0, 0, 0, 0)
            }
            final int PADDING = 10 // TODO: Make this an attribute
            if (inst.textPos == null) {
                inst.textPos = new Vector2f(PADDING, PADDING)
            }
            if (inst.bounds.width == 0 || inst.bounds.height == 0) {
                def font = inst.font
                if (font == null)
                    font = new Graphics(0, 0).font
                float width = font.getWidth(inst.text)
                float height = font.getHeight(inst.text)
                int pad = 2*PADDING
                inst.bounds.width = width + pad
                inst.bounds.height = height + pad
            }

            return super.build() as T
        }
    }
}
