package Visitor.Assignment.digitalEvidenceSystem.visitor;


import Visitor.Assignment.digitalEvidenceSystem.core.*;

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

    public void visitAudioRecording(AudioRecording audio) {
        System.out.println("ANALYZING Audio: " + audio.getId());
        if (audio.isLongRecording()) {
            System.out.println("   ⏱️  Long recording - may need segmentation");
        }else{
            System.out.println("   Audio recording is fine");
        }
    }

    public void visitVideoRecording(VideoRecording video) {
        System.out.println("ANALYZING Video: " + video.getId());
        if (!video.hasAudio()) {
            System.out.println("   🔇 No audio - silent footage");
        }
        if (video.isSurveillanceFootage()) {
            System.out.println("   📹 Surveillance camera footage");
        }
    }
}
