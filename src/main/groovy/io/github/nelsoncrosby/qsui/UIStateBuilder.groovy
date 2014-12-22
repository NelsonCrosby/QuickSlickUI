package io.github.nelsoncrosby.qsui

/**
 *
 */
class UIStateBuilder implements Builder<UIState> {
    List<UIComponent> components

    UIStateBuilder add(Class<? extends UIComponent> componentClass, Object... constructorArgs) {
        UIComponent cmp = componentClass.newInstance(constructorArgs)
        return add(cmp)
    }

    UIStateBuilder add(UIComponent cmp) {
        components.add(cmp)
        return this
    }

    UIStateBuilder addAll(Collection<? extends UIComponent> c) {
        components.addAll(c)
        return this
    }

    /**
     * Generate the target
     *
     * @return A new instance of {@link UIState}
     */
    @Override
    UIState build() {
        return new UIState(components)
    }
}
