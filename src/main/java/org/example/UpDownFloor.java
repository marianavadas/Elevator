package org.example;

// Used for floors with up/down buttons
public class UpDownFloor extends Floor {

    public UpDownFloor(int floorNumber, String direction) {
        super(floorNumber);
        this.direction = direction;
    }

    // used to identify what kind of button this floor has. Used to avoid isinstance
    @Override
    public Boolean isMultiple() {
        return true;
    }


}
