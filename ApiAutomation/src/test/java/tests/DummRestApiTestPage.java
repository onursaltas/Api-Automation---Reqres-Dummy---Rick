package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class DummRestApiTestPage extends DummyRestApi {


    @Test
    public void T1_Get_Employees(){
        Get_Employees();
    }
    @Test
    public void T2_Post_Create(){
        Post_Create();
    }
    @Test
    public void T3_T2_Post_Create(){
        Post_Create_2();
    }

}
