package Visitor.Assignment.digitalEvidenceSystem.visitor;

import Visitor.Assignment.digitalEvidenceSystem.core.*;

public class ExportVisitor implements EvidenceVisitor {
    public void visitDigitalImage(DigitalImage image){
        System.out.println("Exporting Image: " + image.getId());
        System.out.println(" Location " + image.getLocation());
        System.out.println(" Size: " + image.getSizeKB() + "KB");
        System.out.println(" Format: JPEG");

    }

    public void visitNetworkCapture(NetworkCapture networkCapture){
        System.out.println("Exporting Network" + networkCapture.getId());
        System.out.println(" Source: " + networkCapture.getSource());
        System.out.println(" Duration: " + networkCapture.getDurationMinutes() + "minutes");
        System.out.println(" Format: PCAP");
    }

    public void visitAudioRecording(AudioRecording audio) {
        System.out.println("Exporting Audio: " + audio.getId());
        System.out.println(" Duration: " + audio.getDurationSeconds() + " seconds");
    }

    public void visitVideoRecording(VideoRecording video) {
        System.out.println("Exporting Video: " + video.getId());
        System.out.println(" Camera: " + video.getCameraId());
        System.out.println(" Audio: " + (video.hasAudio() ? "Yes" : "No"));
    }
}
