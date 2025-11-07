package Visitor.Assignment.digitalEvidenceSystem.visitor;


import Visitor.Assignment.digitalEvidenceSystem.core.DigitalImage;
import Visitor.Assignment.digitalEvidenceSystem.core.NetworkCapture;

public class AnalyzeVisitor implements EvidenceVisitor {
    public void visitDigitalImage(DigitalImage digitalImage){
        System.out.println("ANALYZING Image: " + digitalImage.getId());

        if (digitalImage.getSizeKB() > 1000){
            System.out.println("   ⚠️  Large file - may need compression");
        }else{
            System.out.println("   ✅ Size is optimal");
        }

    }

    public void visitNetworkCapture(NetworkCapture capture) {
        System.out.println("ANALYZING Network: " + capture.getId());

        if (capture.getDurationMinutes() > 60) {
            System.out.println("   ⚠️  Long capture - check for relevant data");
        } else {
            System.out.println("   ✅ Duration is reasonable");
        }
    }
}
