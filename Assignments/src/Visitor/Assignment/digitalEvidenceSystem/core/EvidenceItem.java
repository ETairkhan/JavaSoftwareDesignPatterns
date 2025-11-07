package Visitor.Assignment.digitalEvidenceSystem.core;

import Visitor.Assignment.digitalEvidenceSystem.visitor.EvidenceVisitor;

public interface EvidenceItem {
    String getId();
    String getType();
    void accept(EvidenceVisitor visitor);
}
