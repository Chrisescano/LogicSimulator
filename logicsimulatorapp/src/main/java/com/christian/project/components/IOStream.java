package com.christian.project.components;

/**
 * Represents I/O of a component. Has a direction it is facing and has a width associated as well.
 */
public class IOStream {
    private int streamID;
    private int bitSize;
    private final boolean isInput;
    private Face direction;

    private long payload;

    public IOStream(final boolean isInput) {
        this.isInput = isInput;
        this.bitSize = 1;
        this.payload = 0L;
        this.streamID = 0;
    }

    /*-----Methods-----*/
    public int getPayloadBit(final int index) {
        if (index >= bitSize) return -1;
        long maskedData = payload & (1L << index);
        return maskedData > 0 ? 1 : 0;
    }

    public boolean togglePayloadBit(final int index) {
        if (index >= bitSize) return false;
        payload = payload ^ (1L << index);
        return true;
    }

    /*-----Getters-----*/
    public int ID() {
        return streamID;
    }

    public Face direction() {
        return direction;
    }

    public int bitSize() {
        return bitSize;
    }

    public boolean isInput() {
        return isInput;
    }

    public long payload() {
        return payload;
    }

    /*-----Setters-----*/
    public void setID(final int streamID) {
        this.streamID = streamID;
    }

    public void setDirection(final Face direction) {
        this.direction = direction;
    }

    public void setBitSize(final int bitSize) {
        this.bitSize = bitSize;
        payload = 0L;
    }

    public boolean setPayload(final long payload) {
        long maxPayload = (1L << bitSize + 1) - 1;
        if (payload > maxPayload) return false;
        else {
            this.payload = payload;
            return true;
        }
    }

    /*-----Debugging-----*/
    @Override
    public String toString() {
        return "IOStream{" +
                "streamID=" + streamID +
                ", bitSize=" + bitSize +
                ", isInput=" + isInput +
                ", direction=" + direction +
                ", payload=" + payload +
                '}';
    }
}
