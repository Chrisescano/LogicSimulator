package com.christian.project.components.outputs;

/**
 * A component that turns on or off depending on its input. Can be used to provide output for circuits.
 */
public class Light {
    private boolean isToggled;

    /*-----Methods-----*/
    public void toggle() {
        isToggled = !isToggled;
    }
}
