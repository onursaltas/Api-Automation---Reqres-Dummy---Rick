package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class RickAndMortyApiTestPage extends RickAndMortyApi {



    @Test
    public void T1_Get_Character(){
        Get_Character();
    }
    @Test
    public void T2_Get_List_Character(){
        Get_List_Character();
    }
    @Test
    public void T3_Get_Id_Character(){
        Get_Id_Character();
    }
}
