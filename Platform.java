public class Platform implements AttachmentInterface {
    private double platformAngle;

    public Platform(){
        this.platformAngle = 0;
    }

    public double getAngle(){
        return this.platformAngle;
    }

    public void raiseAngle(double amount){
        this.platformAngle = Math.min(getAngle() + amount, 70);
    }

    public void lowerAngle(double amount){
        this.platformAngle = Math.max(getAngle() - amount, 0);
    }
    @Override
    public Boolean attachmentInUse(){
        if (this.platformAngle == 0){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


}
