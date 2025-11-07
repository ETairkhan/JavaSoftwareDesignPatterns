package Visitor.Assignment.digitalEvidenceSystem.core;

import Visitor.Assignment.digitalEvidenceSystem.visitor.EvidenceVisitor;

public class AudioRecording implements EvidenceItem {
    private String id;
    private String location;
    private int durationSeconds;
    private String quality;

    public AudioRecording(String id, String location, int durationSeconds) {
        this.id = id;
        this.location = location;
        this.durationSeconds = durationSeconds;
        this.quality = "Standard";
    }

    public String getId() { return id; }
    public String getType() { return "Audio Recording"; }
    public String getLocation() { return location; }
    public int getDurationSeconds() { return durationSeconds; }
    public String getQuality() { return quality; }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void accept(EvidenceVisitor visitor) {
        visitor.visitAudioRecording(this);
    }

    public boolean isLongRecording() {
        return durationSeconds > 300; // longer than 5 minutes
    }
}