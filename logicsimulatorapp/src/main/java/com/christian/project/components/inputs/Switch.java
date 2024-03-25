package com.christian.project.components.inputs;

/**
 * A component that turns on or off. Can be used to provide input to circuits.
 */
public class Switch {
    private boolean isToggled;

    /*-----Methods-----*/
    public void toggle() {
        isToggled = !isToggled;
    }
}
