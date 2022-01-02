package schoolrecords;

public class Mark {
    private MarkType markType;
    private String markTypeString;
    private Subject subject;
    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        this.markType = markType;
        if (subject == null || tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markTypeString, Subject subject, Tutor tutor) {
        this.markTypeString = markTypeString;
        this.subject = subject;
        this.tutor = tutor;
    }

    public String toString(){
        return markType.getName()+"("+markType.getValue()+")";
    }

    public MarkType getMarkType() {
        return markType;
    }

    public String getMarkTypeString() {
        return markTypeString;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
