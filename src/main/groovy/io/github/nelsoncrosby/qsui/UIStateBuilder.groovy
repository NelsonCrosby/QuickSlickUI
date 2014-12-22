package io.github.nelsoncrosby.qsui

/**
 *
 */
class UIStateBuilder {
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
}
