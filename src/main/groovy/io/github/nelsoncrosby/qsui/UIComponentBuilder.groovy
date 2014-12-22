package io.github.nelsoncrosby.qsui

import org.newdawn.slick.geom.Rectangle

/**
 *
 * @param < T >
 */
abstract class UIComponentBuilder<T extends UIComponent> implements Builder<T> {
    Rectangle bounds

    UIComponentBuilder bounds(Rectangle bounds) {
        this.bounds = bounds
        return this
    }
}
