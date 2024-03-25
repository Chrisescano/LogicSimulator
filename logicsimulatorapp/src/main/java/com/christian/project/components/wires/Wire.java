package com.christian.project.components.wires;

/**
 * A component that helps signals travel from a source to a destination.
 */
public class Wire {
    private boolean isToggled;

    public void toggle() {
        isToggled = !isToggled;
    }
}
