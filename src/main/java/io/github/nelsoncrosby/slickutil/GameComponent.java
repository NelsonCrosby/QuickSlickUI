package io.github.nelsoncrosby.slickutil;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 */
public interface GameComponent {
    /**
     * Render this component
     *
     * @param gc The container holding the game
     * @param gx The graphics context to render to
     *
     * @throws SlickException Indicates a failure to render an artifact
     */
    public void render(GameContainer gc, Graphics gx) throws SlickException;

    /**
     * Update this component
     *
     * @param gc The container holding the game
     * @param delta The amount of time that has passed in milliseconds since last update
     *
     * @throws SlickException Indicates an internal error that will be reported through the
     * standard framework mechanism
     */
    public void update(GameContainer gc, int delta) throws SlickException;
}
