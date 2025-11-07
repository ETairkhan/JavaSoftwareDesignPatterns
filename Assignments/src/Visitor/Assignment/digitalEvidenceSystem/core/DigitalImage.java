package Visitor.Assignment.digitalEvidenceSystem.core;

import Visitor.Assignment.digitalEvidenceSystem.visitor.EvidenceVisitor;

public class DigitalImage implements EvidenceItem {
    private String id;
    private String location;
    private int sizeKB;

    public DigitalImage(String id, String location, int sizeKB) {
        this.id = id;
        this.location = location;
        this.sizeKB = sizeKB;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType(){
        return "Digital Image";
    }

    public int getSizeKB() {
        return sizeKB;
    }

    public String getLocation() {
        return location;
    }

    public void accept(EvidenceVisitor visitor){
        visitor.visitDigitalImage(this);
    }
}

