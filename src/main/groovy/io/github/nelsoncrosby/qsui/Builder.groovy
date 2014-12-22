package io.github.nelsoncrosby.qsui

/**
 *
 */
abstract class Builder<T> {
    T inst

    protected abstract T getNewInstance()

    Builder() {
        inst = getNewInstance()
    }

    /**
     * Generate the target
     *
     * @return A new instance of {@link T}
     */
    T build() {
        return inst
    }
}
