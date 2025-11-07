package Visitor.Assignment.digitalEvidenceSystem.core;

import Visitor.Assignment.digitalEvidenceSystem.visitor.EvidenceVisitor;

public class VideoRecording implements EvidenceItem {
    private String id;
    private String cameraId;
    private int durationMinutes;
    private boolean hasAudio;

    public VideoRecording(String id, String cameraId, int durationMinutes) {
        this.id = id;
        this.cameraId = cameraId;
        this.durationMinutes = durationMinutes;
        this.hasAudio = true;
    }

    public String getId() { return id; }
    public String getType() { return "Video Recording"; }
    public String getCameraId() { return cameraId; }
    public int getDurationMinutes() { return durationMinutes; }
    public boolean hasAudio() { return hasAudio; }

    public void setHasAudio(boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    public void accept(EvidenceVisitor visitor) {
        visitor.visitVideoRecording(this);
    }

    public boolean isSurveillanceFootage() {
        return cameraId.startsWith("CAM-");
    }
}