package Visitor.Assignment.digitalEvidenceSystem.visitor;

import Visitor.Assignment.digitalEvidenceSystem.core.DigitalImage;
import Visitor.Assignment.digitalEvidenceSystem.core.NetworkCapture;

public interface EvidenceVisitor {
    void visitDigitalImage(DigitalImage digitalImage);
    void visitNetworkCapture(NetworkCapture networkCapture);

}
