package Visitor.Assignment.digitalEvidenceSystem.core;

import Visitor.Assignment.digitalEvidenceSystem.visitor.EvidenceVisitor;

public class NetworkCapture implements EvidenceItem {
    private String id;
    private String source;
    private int durationMinutes;

    public NetworkCapture(String id, String source, int durationMinutes){
        this.id = id;
        this.source = source;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getType(){
        return "Network Capture";
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public String getSource() {
        return source;
    }

    public void accept(EvidenceVisitor visitor){
        visitor.visitNetworkCapture(this);
    }
}
