public interface Attachment {
    Boolean attachmentInUse();

    void raiseAttachment();

    void lowerAttachment();

    int getState();
}