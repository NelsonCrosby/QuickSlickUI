package io.github.nelsoncrosby.qsui.components

import io.github.nelsoncrosby.slickutil.MouseButton
import org.newdawn.slick.Color
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.SlickException

/**
 * A component that contains text
 */
class UIButton extends UITextComponent {
    Closure onClicked
    Color bgColor

    UIButton() {}

    @Override
    boolean isAcceptingInput() {
        return true
    }

    @Override
    void mouseClicked(int button, int x, int y, int clickCount) {
        if (button == MouseButton.LEFT)
            onClicked.call(clickCount)
    }

    @Override
    void update(GameContainer gc, int delta) throws SlickException {

    }

    @Override
    void render(GameContainer gc, Graphics gx) throws SlickException {
        Color colorBefore = gx.color
        if (bgColor != null) gx.color = bgColor

        gx.fill(bounds)
        super.render(gc, gx)

        gx.color = colorBefore
    }

    /**
     *
     */
    static class Builder extends UITextComponent.Builder<UIButton> {
        Builder onClicked(Closure action) {
            inst.onClicked = action
            return this
        }

        Builder bgColor(Color bgColor) {
            inst.bgColor = bgColor
            return this
        }

        @Override
        protected UIButton getNewInstance() {
            return new UIButton()
        }
    }
}
