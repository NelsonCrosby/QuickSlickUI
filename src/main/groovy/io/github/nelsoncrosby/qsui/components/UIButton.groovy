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
    Closure render
    Color bgColor

    protected UIButton() {}

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

        if (render == null) {
            gx.fill(bounds)
        } else {
            render.call(gx)
        }

        gx.color = colorBefore

        super.render(gc, gx)
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

        Builder render(Closure render) {
            inst.render = render
            return this
        }

        @Override
        protected UIButton getNewInstance() {
            return new UIButton()
        }

        @Override
        UIButton build() {
            inst.render.delegate = inst

            return super.build() as UIButton
        }
    }
}
