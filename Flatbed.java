public class Flatbed implements Attachment {
    private Boolean flatbedLevel;

    public Flatbed() {
        this.flatbedLevel = Boolean.FALSE;
    }

    @Override
    public Boolean attachmentInUse(){
        return this.flatbedLevel;
    }
    @Override
    public void raiseAttachment() {
        this.flatbedLevel = Boolean.TRUE;
    }
    @Override
    public void lowerAttachment(){
        this.flatbedLevel = Boolean.FALSE;
    }
}
