package Visitor.Assignment.digitalEvidenceSystem.Application;


import Visitor.Assignment.digitalEvidenceSystem.core.*;
import Visitor.Assignment.digitalEvidenceSystem.core.NetworkCapture;
import Visitor.Assignment.digitalEvidenceSystem.visitor.AnalyzeVisitor;
import Visitor.Assignment.digitalEvidenceSystem.visitor.EvidenceVisitor;
import Visitor.Assignment.digitalEvidenceSystem.visitor.ExportVisitor;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<EvidenceItem> allEvidence = new ArrayList<>();

    public void export(){
        EvidenceVisitor exportVisitor = new ExportVisitor();
        System.out.println("Exporting evidence:");
        System.out.println("===================");
        for (EvidenceItem evidence : allEvidence){
            evidence.accept(exportVisitor);
            System.out.println();
        }
    }

    public void analyze(){
        EvidenceVisitor analyzeVisitor = new AnalyzeVisitor();
        System.out.println("Analyzing evidence:");
        System.out.println("===================");
        for (EvidenceItem evidence : allEvidence){
            evidence.accept(analyzeVisitor);
            System.out.println();
        }
    }

    public void addEvidence(EvidenceItem evidence){
        allEvidence.add(evidence);
    }


    public void demo() {
        DigitalImage image1 = new DigitalImage("IMG-001", "Crime Scene A", 1500);
        DigitalImage image2 = new DigitalImage("IMG-002", "Evidence Locker", 500);
        NetworkCapture capture1 = new NetworkCapture("NET-001", "Server Room", 45);
        NetworkCapture capture2 = new NetworkCapture("NET-002", "Office Network", 120);


        addEvidence(image1);
        addEvidence(image2);
        addEvidence(capture1);
        addEvidence(capture2);
        addEvidence(new AudioRecording("AUD-001", "Room 101", 180));
        addEvidence(new AudioRecording("AUD-002", "Hallway", 600));

        addEvidence(new VideoRecording("VID-001", "CAM-001", 30));
        VideoRecording silentVideo = new VideoRecording("VID-002", "CAM-002", 15);
        silentVideo.setHasAudio(false);
        addEvidence(silentVideo);

        System.out.println("✅ Added " + allEvidence.size() + " evidence items\n");

        analyze();
        System.out.println();
        export();
    }

}
