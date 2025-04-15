package org.example;

// Used for floors with single buttons
public class SingleFloor extends Floor{

    public SingleFloor(int floorNumber) {
        super(floorNumber);
    }

    // used to identify what kind of button this floor has. Used to avoid isinstance
    @Override
    public Boolean isSingle() {
        return true;
    }
}
