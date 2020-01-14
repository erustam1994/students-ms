package com.students.model;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditListener {

    @PrePersist
    public void prePersist(Auditable auditable) {
        Audit audit = (auditable.getAudit() == null) ? new Audit() : auditable.getAudit();
        auditable.setAudit(audit);

        audit.setCreatedAt(LocalDateTime.now());
        audit.setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(Auditable auditable) {
        Audit audit = (auditable.getAudit() == null) ? new Audit() : auditable.getAudit();
        auditable.setAudit(audit);

        audit.setUpdatedAt(LocalDateTime.now());
    }

}
