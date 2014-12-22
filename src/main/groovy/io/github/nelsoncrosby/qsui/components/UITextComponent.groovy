package io.github.nelsoncrosby.qsui.components

import org.newdawn.slick.*
import org.newdawn.slick.geom.Rectangle
import org.newdawn.slick.geom.Vector2f

/**
 * A component that contains text
 */
abstract class UITextComponent extends UIComponent {
    String text
    Color textColor
    Vector2f textPos
    Font font

    protected UITextComponent() {}

    @Override
    void render(GameContainer gc, Graphics gx) throws SlickException {
        Font fontBefore = gx.font
        if (font != null) gx.font = font

        Color colorBefore = gx.color
        if (textColor != null) gx.color = textColor

        gx.drawString(text, bounds.x+textPos.x as float, bounds.y+textPos.y as float)

        gx.font = fontBefore
        gx.color = colorBefore
    }

    /**
     *
     */
    static abstract class Builder<T extends UITextComponent> extends UIComponent.Builder<T> {
        Builder<T> text(String text) {
            inst.text = text
            return this;
        }

        Builder<T> textColor(Color textColor) {
            inst.textColor = textColor
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
            final Font defaultFont = new Graphics(0, 0).font

            if (inst.bounds == null) {
                inst.bounds = new Rectangle(0, 0, 0, 0)
            }

            final int PADDING = 10 // TODO: Make this an attribute
            int pad = 2*PADDING
            if (inst.textPos == null) {
                inst.textPos = new Vector2f(PADDING, PADDING)
            }

            if (inst.bounds.width == 0) {
                def font = inst.font
                if (font == null) font = defaultFont
                float width = font.getWidth(inst.text)
                inst.bounds.width = width + pad
            }
            if (inst.bounds.height == 0) {
                def font = inst.font
                if (font == null) font = defaultFont
                float height = font.getHeight(inst.text)
                inst.bounds.height = height + pad
            }

            return super.build() as T
        }
    }
}
