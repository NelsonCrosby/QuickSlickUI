package io.github.nelsoncrosby.qsui

import io.github.nelsoncrosby.qsui.components.UIComponent

/**
 *
 */
class UIStateBuilder extends Builder<UIState> {
    @Override
    protected UIState getNewInstance() {
        return new UIState(new ArrayList<UIComponent>())
    }

    UIStateBuilder add(UIComponent cmp) {
        inst.components.add(cmp)
        return this
    }

    UIStateBuilder addAll(Collection<? extends UIComponent> c) {
        inst.components.addAll(c)
        return this
    }
}
