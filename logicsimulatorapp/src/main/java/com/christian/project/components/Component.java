package com.christian.project.components;

import java.util.List;

/**
 * A generic component that can represent anything from a logic gate to a full integrated circuit.
 */
public abstract class Component {
    protected Face facing;

    protected List<IOStream> inputs;
    protected List<IOStream> outputs;
}
