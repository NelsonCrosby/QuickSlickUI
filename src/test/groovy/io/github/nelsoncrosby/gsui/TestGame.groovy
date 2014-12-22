package io.github.nelsoncrosby.gsui

import io.github.nelsoncrosby.qsui.UIState

import io.github.nelsoncrosby.qsui.components.UIButton
import org.newdawn.slick.*

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
        ui = new UIState.Builder()
                .add(
                        new UIButton.Builder()
                                .onClicked { println 'Hello, World!' }
                                .bgColor(Color.blue)
                                .render { Graphics gx ->
                                    gx.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10)
                                }
                                .text("Hello, World!")
                                .textColor(Color.white)
                                .bounds(10, 10)
                                .build()
                )
                .build()
        ui.input = gc.input
        gc.input.addKeyListener(ui)
        gc.input.addMouseListener(ui)
    }

    @Override
    void update(GameContainer gc, int delta) throws SlickException {
        ui.update(gc, delta)
    }

    @Override
    void render(GameContainer gc, Graphics gx) throws SlickException {
        ui.render(gc, gx)
    }

    static void main(String[] args) {
        AppGameContainer gc = new AppGameContainer(new TestGame(), 500, 500, false)
        gc.start()
    }
}
