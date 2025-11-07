package Visitor.Assignment.digitalEvidenceSystem.visitor;

import Visitor.Assignment.digitalEvidenceSystem.core.*;

public interface EvidenceVisitor {
    void visitDigitalImage(DigitalImage digitalImage);
    void visitNetworkCapture(NetworkCapture networkCapture);
    void visitAudioRecording(AudioRecording audioRecording);
    void visitVideoRecording(VideoRecording videoRecording);
}
