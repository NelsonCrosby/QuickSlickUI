package io.github.nelsoncrosby.qsui.components

import org.newdawn.slick.Color
import org.newdawn.slick.Font
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.SlickException
import org.newdawn.slick.geom.Rectangle
import org.newdawn.slick.geom.Vector2f
import org.newdawn.slick.state.StateBasedGame

/**
 * A component that contains text
 */
class UIButton extends UITextComponent {

    UIButton() {}

    @Override
    boolean isAcceptingInput() {
        return false
    }

    UIButton(Rectangle bounds, String text) {
        this(bounds, text, null)
    }

    UIButton(Rectangle bounds, String text, Font font) {
        super(bounds, text, new Vector2f(10, 10), font)
    }

    @Override
    void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {

    }

    @Override
    void render(GameContainer gc, StateBasedGame game, Graphics gx) throws SlickException {
        gx.color = Color.blue
        gx.fill(bounds)
        gx.color = Color.white
        super.render(gc, game, gx)
    }
    /**
     *
     */
    static class Builder extends UITextComponent.Builder<UIButton> {
        @Override
        protected UIButton getNewInstance() {
            return new UIButton()
        }
    }
}
