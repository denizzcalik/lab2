public class Flatbed implements AttachmentInterface{
    private Boolean flatbedLevel;

    public Flatbed() {
        this.flatbedLevel = Boolean.FALSE;
    }

    @Override
    public Boolean attachmentInUse(){
        if (this.flatbedLevel){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
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
