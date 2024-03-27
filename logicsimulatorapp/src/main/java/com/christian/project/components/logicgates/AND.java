package com.christian.project.components.logicgates;

import com.christian.project.components.Component;
import com.christian.project.components.Face;
import com.christian.project.components.IOStream;

import java.util.ArrayList;
import java.util.Collections;

public class AND extends Component {

    public AND() {
        this.facing = Face.EAST;
        this.inputs = new ArrayList<>(2);
        inputs.add(new IOStream(true, 1, Face.EAST));
        inputs.add(new IOStream(true, 1, Face.EAST));

        this.outputs = Collections.singletonList(new IOStream(false, 1, Face.WEST));
    }

    /*--Methods--*/
    public boolean changeNumberOfInputs(final int numberOfInputs) {
        if (numberOfInputs > 64 || numberOfInputs < 2) return false;

        inputs.clear();
        for (int index = 0; index < numberOfInputs; index++) {
            inputs.add(new IOStream(true, 1, Face.EAST));
        }
        return true;
    }

    public boolean setInputValue(final int inputIndex, final long value) {
        if (inputIndex > inputs.size() - 1 || inputIndex < 0) return false;
        return inputs.get(inputIndex).setValue(value);
    }

    public long getOutput() {
        long result = inputs.get(0).getValueByBandWidth();
        for (int index = 1; index < inputs.size(); index++) {
            result = result & inputs.get(index).getValueByBandWidth();
        }
        return result;
    }

    public boolean setBandWidth(final int bandWidth) {
        boolean validBandWidth = outputs.get(0).setBandWidth(bandWidth);
        if (validBandWidth) {
            outputs.get(0).setValue(0L);
            for (IOStream input : inputs) {
                input.setBandWidth(bandWidth);
                input.setValue(0L);
            }
            return true;
        }
        return false;
    }
}
