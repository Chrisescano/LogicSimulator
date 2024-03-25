package com.christian.project.components;


import java.util.List;

/**
 * A generic component that can represent anything from a logic gate to a full integrated circuit.
 */
public abstract class Component {
    private List<IOStream> inputs;
    private List<IOStream> outputs;

    public Component() {}

    /*-----Abstract Methods-----*/

    /*-----Methods-----*/
    public void addIOStream(final IOStream stream) {
        if (stream.isInput()) {
            int id = getTailingStreamID(inputs) + 1;
            stream.setID(id);
            inputs.add(stream);
        } else {
            int id = getTailingStreamID(outputs) + 1;
            stream.setID(id);
            outputs.add(stream);
        }
    }

    /*-----Utility-----*/
    private int getTailingStreamID(final List<IOStream> streams) {
        return streams.isEmpty() ? 0 : streams.get(streams.size() - 1).ID();
    }

    /*-----Debugging-----*/
    @Override
    public String toString() {
        return "Component{" +
                "inputs=" + inputs +
                ", outputs=" + outputs +
                '}';
    }
}
