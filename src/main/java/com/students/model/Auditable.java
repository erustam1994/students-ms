package com.students.model;

public interface Auditable {

    Audit getAudit();
    void setAudit(Audit audit);
}
