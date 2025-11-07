package Visitor.Assignment.digitalEvidenceSystem.visitor;

import Visitor.Assignment.digitalEvidenceSystem.core.DigitalImage;
import Visitor.Assignment.digitalEvidenceSystem.core.NetworkCapture;

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
}
