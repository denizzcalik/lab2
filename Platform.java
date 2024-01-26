public class Platform implements Attachment {
    private int platformAngle;

    public Platform(){
        this.platformAngle = 0;
    }

    public int getAngle(){
        return this.platformAngle;
    }

    @Override
    public void raiseAttachment(){
        this.platformAngle = Math.min(getAngle() + 10, 70);
    }
    @Override
    public void lowerAttachment(){
        this.platformAngle = Math.max(getAngle() - 10, 0);
    }
    
    @Override
    public Boolean attachmentInUse(){
        return this.platformAngle > 0;
    }


}

