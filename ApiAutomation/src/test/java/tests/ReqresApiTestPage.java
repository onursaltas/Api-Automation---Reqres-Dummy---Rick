package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ReqresApiTestPage extends ReqresApi {



    @Test
    public void T1_Put_User(){
        Put_User();
    }
    @Test
    public void T2_Patch_User(){
        Patch_User();
    }
    @Test
    public void T3_Delete_User(){
        Delete_User();
    }

}
