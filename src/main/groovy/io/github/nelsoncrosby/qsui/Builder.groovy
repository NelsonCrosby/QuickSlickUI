package io.github.nelsoncrosby.qsui

/**
 *
 */
interface Builder<T> {
    /**
     * Generate the target
     *
     * @return A new instance of {@link T}
     */
    T build()
}
