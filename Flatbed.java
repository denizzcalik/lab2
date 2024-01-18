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

    public void activateFlatbed() {
        this.flatbedLevel = Boolean.TRUE;
    }
    public void inactivateFlatbed(){
        this.flatbedLevel = Boolean.FALSE;
    }
}
