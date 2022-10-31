package com.example.naomidejong562748endassignment.model;

import java.time.LocalDate;

public class LendOut {
    private int itemcode;
    private int identifier;
    private LocalDate lendDate;

    public LendOut(int itemcode, int identifier, LocalDate lendDate) {
        this.itemcode = itemcode;
        this.identifier = identifier;
        this.lendDate = lendDate;
    }

    //setters
    public void setItemCode(int itemcode) {
        this.itemcode = itemcode;
    }
    public void setIdentifier(){this.identifier = identifier;}
    public void setLendDate(){this.lendDate = lendDate;}

    //getters
    public int getItemcode() {return itemcode;}
    public int getIdentifier() {return identifier;}
    public LocalDate getLendDate() {return lendDate;}
}
