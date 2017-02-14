package levels;
import shapes.*;
public class Last_Terminous extends Level
{
    public Last_Terminous()
    {
        XSIZE = 1000;
        YSIZE = 700;
        Shape floor = new Rect(true,300,495,750,505);
        super.addBox(floor);
        Shape platform = new Rect(true,200,345,325,350);
        super.addBox(platform);
        Shape platform2 = new Rect(true,725,225,800,230);
        super.addBox(platform2);
    }
}