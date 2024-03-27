package com.christian.project.components;

/**
 * Represents I/O of a component. Has a direction it is facing and has a width associated as well.
 */
public final class IOStream {
    private boolean isInput;
    private int bandWidth;
    private long value;
    private Face facing;

    public IOStream(final boolean isInput, final int bandWidth, final Face facing) {
        this.isInput = isInput;
        this.bandWidth = bandWidth;
        this.facing = facing;
    }

    /*--Methods--*/
    public long getValueByBandWidth() {
        long mask = (1L << bandWidth) - 1;
        return value & mask;
    }

    public boolean setValue(long value) {
        if (valueFitsBandWidth(value)) {
            this.value = value;
            return true;
        }
        return false;
    }

    public boolean setBandWidth(final int bandWidth) {
        if (bandWidth > 64 || bandWidth < 2) return false;
        this.bandWidth = bandWidth;
        this.value = 0L;
        return true;
    }

    /*--Utility--*/
    private boolean valueFitsBandWidth(long value) {
        long maxValueGivenBandWidth = (1L << bandWidth) - 1;
        return maxValueGivenBandWidth >= value && value >= 0;
    }

    /*--Getters--*/
    public boolean isInput() {
        return isInput;
    }

    public int getBandWidth() {
        return bandWidth;
    }

    public Face getFacing() {
        return facing;
    }

    /*--Setters--*/
    public void setFacing(Face facing) {
        this.facing = facing;
    }
}
