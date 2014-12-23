package io.github.nelsoncrosby.qsui.components

import io.github.nelsoncrosby.slickutil.GameComponent
import io.github.nelsoncrosby.slickutil.PCInputListener
import org.newdawn.slick.*
import org.newdawn.slick.geom.Rectangle

/**
 *
 */
abstract class UIComponent implements PCInputListener, GameComponent {
    Rectangle bounds

    protected UIComponent() {}

    /**
     * Notification that a key was pressed
     *
     * @param key The key code that was pressed (@see org.newdawn.slick.Input)
     * @param c The character of the key that was pressed
     */
    @Override
    void keyPressed(int key, char c) {

    }

    /**
     * Notification that a key was released
     *
     * @param key The key code that was released (@see org.newdawn.slick.Input)
     * @param c The character of the key that was released
     */
    @Override
    void keyReleased(int key, char c) {

    }

    /**
     * Notification that the mouse wheel position was updated
     *
     * @param change The amount of the wheel has moved
     */
    @Override
    void mouseWheelMoved(int change) {

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
        return false
    }

    /**
     * Notification that all input events have been sent for this frame
     */
    @Override
    void inputEnded() {

    }

    /**
     * Notification that input is about to be processed
     */
    @Override
    void inputStarted() {

    }

    /**
     *
     * @param < T >
     */
    abstract static class Builder<T extends UIComponent> extends io.github.nelsoncrosby.qsui.Builder<T> {
        Builder<T> bounds(Rectangle bounds) {
            inst.bounds = bounds
            return this
        }
        Builder<T> bounds(float x, float y, float width = 0, float height = 0) {
            return this.bounds(new Rectangle(x, y, width, height))
        }
    }
}
