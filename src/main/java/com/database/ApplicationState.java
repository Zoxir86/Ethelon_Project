package com.database;

public final class ApplicationState {
    public static final String PENDING = "P";               // Awaiting approval by NGO.
    public static final String APPROVED = "A";              // Approved by NGO.
    public static final String DISAPPROVED = "D";           // Disapproved by NGO.
    public static final String WITHDRAWN = "W";             // Withdrawn by Volunteer.
    public static final String CANCELLED = "C";             // Cancelled by Administrator.
}
