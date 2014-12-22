package io.github.nelsoncrosby.qsui

import io.github.nelsoncrosby.qsui.components.UIComponent
import io.github.nelsoncrosby.slickutil.GameComponent
import io.github.nelsoncrosby.slickutil.PCInputListener
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.Input
import org.newdawn.slick.SlickException
import org.newdawn.slick.state.StateBasedGame

/**
 *
 */
class UIState implements PCInputListener, GameComponent {
    List<UIComponent> components
    UIComponent keyFocused

    UIState(List<UIComponent> components) {
        this.components = components
    }

    /**
     * Render this component
     *
     * @param gc The container holding the game
     * @param game The game holding the current state
     * @param gx The graphics context to render to
     *
     * @throws SlickException Indicates a failure to render an artifact
     */
    @Override
    void render(GameContainer gc, StateBasedGame game, Graphics gx) throws SlickException {
        components.each { it.render(gc, game, gx) }
    }

    /**
     * Update this component
     *
     * @param gc The container holding the game
     * @param game The game holding the current state
     * @param delta The amount of time that has passed in milliseconds since last update
     *
     * @throws SlickException Indicates an internal error that will be reported through the
     * standard framework mechanism
     */
    @Override
    void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        components.each { it.update(gc, game, delta) }
    }

    /**
     * Notification that a key was pressed
     *
     * @param key The key code that was pressed (@see org.newdawn.slick.Input)
     * @param c The character of the key that was pressed
     */
    @Override
    void keyPressed(int key, char c) {
        if (keyFocused != null) {
            keyFocused.keyPressed(key, c)
        }
    }

    /**
     * Notification that a key was released
     *
     * @param key The key code that was released (@see org.newdawn.slick.Input)
     * @param c The character of the key that was released
     */
    @Override
    void keyReleased(int key, char c) {
        if (keyFocused != null) {
            keyFocused.keyReleased(key, c)
        }
    }

    protected UIComponent mouseFocused() {
        int mouseX = input.mouseX,
                mouseY = input.mouseY
        components.reverse().find {
            mouseX >= it.bounds.x && mouseX <= it.bounds.maxX &&
                    mouseY >= it.bounds.y && mouseY <= it.bounds.maxX
        }
    }

    /**
     * Notification that the mouse wheel position was updated
     *
     * @param change The amount of the wheel has moved
     */
    @Override
    void mouseWheelMoved(int change) {
        def focused = mouseFocused()
        if (focused != null) {
            focused.mouseWheelMoved(change)
        }
    }

    /**
     * Notification that a mouse button was clicked. Due to double click
     * handling the single click may be delayed slightly. For absolute notification
     * of single clicks use mousePressed().
     *
     * To be absolute this method should only be used when considering double clicks
     *
     * @param button The index of the button (starting at 0)
     * @param x The x position of the mouse when the button was pressed
     * @param y The y position of the mouse when the button was pressed
     * @param clickCount The number of times the button was clicked
     */
    @Override
    void mouseClicked(int button, int x, int y, int clickCount) {
        def focused = mouseFocused()
        if (focused != null) {
            focused.mouseClicked(button, x, y, clickCount)
        }
    }

    /**
     * Notification that a mouse button was pressed
     *
     * @param button The index of the button (starting at 0)
     * @param x The x position of the mouse when the button was pressed
     * @param y The y position of the mouse when the button was pressed
     */
    @Override
    void mousePressed(int button, int x, int y) {
        keyFocused = mouseFocused()
        def focused = mouseFocused()
        if (focused != null) {
            focused.mousePressed(button, x, y)
        }
    }

    /**
     * Notification that a mouse button was released
     *
     * @param button The index of the button (starting at 0)
     * @param x The x position of the mouse when the button was released
     * @param y The y position of the mouse when the button was released
     */
    @Override
    void mouseReleased(int button, int x, int y) {
        def focused = mouseFocused()
        if (focused != null) {
            focused.mouseReleased(button, x, y)
        }
    }

    /**
     * Notification that mouse cursor was moved
     *
     * @param oldx The old x position of the mouse
     * @param oldy The old y position of the mouse
     * @param newx The new x position of the mouse
     * @param newy The new y position of the mouse
     */
    @Override
    void mouseMoved(int oldx, int oldy, int newx, int newy) {
        def focused = mouseFocused()
        if (focused != null) {
            focused.mouseMoved(oldx, oldy, newx, newy)
        }
    }

    /**
     * Notification that mouse cursor was dragged
     *
     * @param oldx The old x position of the mouse
     * @param oldy The old y position of the mouse
     * @param newx The new x position of the mouse
     * @param newy The new y position of the mouse
     */
    @Override
    void mouseDragged(int oldx, int oldy, int newx, int newy) {
        def focused = mouseFocused()
        if (focused != null) {
            focused.mouseDragged(oldx, oldy, newx, newy)
        }
    }

    /** The input instance sending events */
    Input input

    /**
     * Check if this input listener is accepting input
     *
     * @return True if the input listener should recieve events
     */
    @Override
    boolean isAcceptingInput() {
        return true
    }

    /**
     * Notification that all input events have been sent for this frame
     */
    @Override
    void inputEnded() {
        components.each { it.inputEnded() }
    }

    /**
     * Notification that input is about to be processed
     */
    @Override
    void inputStarted() {
        components.each { it.inputStarted() }
    }
}
