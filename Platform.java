public class Platform implements AttachmentInterface {
    private int platformAngle;

    public Platform(){
        this.platformAngle = 0;
    }

    public int getAngle(){
        return this.platformAngle;
    }

    @Override
    public void raiseAttachment(){}
    @Override
    public void lowerAttachment(){}
    public void raiseAttachment(int amount){
        this.platformAngle = Math.min(getAngle() + amount, 70);
    }
    public void lowerAttachment(int amount){
        this.platformAngle = Math.max(getAngle() - amount, 0);
    }
    @Override
    public Boolean attachmentInUse(){
        return this.platformAngle > 0;
    }


}
