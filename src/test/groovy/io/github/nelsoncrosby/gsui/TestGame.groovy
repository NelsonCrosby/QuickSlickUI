package io.github.nelsoncrosby.gsui

import io.github.nelsoncrosby.qsui.UIState
import io.github.nelsoncrosby.qsui.UIStateBuilder
import io.github.nelsoncrosby.qsui.components.UIButton
import org.newdawn.slick.AppGameContainer
import org.newdawn.slick.BasicGame
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.SlickException
import org.newdawn.slick.geom.Rectangle

/**
 *
 */
class TestGame extends BasicGame {
    UIState ui

    /**
     * Create a new basic game
     *
     * @param title The title for the game
     */
    TestGame() {
        super('TestGame')
    }

    @Override
    void init(GameContainer gc) throws SlickException {
        ui = new UIStateBuilder()
                .add(
                        new UIButton.Builder()
                                .onClicked { println 'Hello, World!' }
                                .text("Hello, World!")
                                .bounds(new Rectangle(10, 10, 0, 0))
                                .build()
                )
                .build()
        ui.input = gc.input
        gc.input.addKeyListener(ui)
        gc.input.addMouseListener(ui)
    }

    @Override
    void update(GameContainer gc, int delta) throws SlickException {
        ui.update(gc, null, delta)
    }

    @Override
    void render(GameContainer gc, Graphics gx) throws SlickException {
        ui.render(gc, null, gx)
    }

    static void main(String[] args) {
        AppGameContainer gc = new AppGameContainer(new TestGame(), 500, 500, false)
        gc.start()
    }
}
