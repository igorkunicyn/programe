import client.OperationWihtArrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MassTestArray {
    private int [] array;
    private OperationWihtArrays owa;

    public MassTestArray(int [] array){
        this.array = array;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,1,1,1,1,1}},
                {new int[]{4,4,4,4,}},
                {new int[]{1,4,4,1,1,4,3}}
        });
    }

    @Before
    public void init(){
        owa = new OperationWihtArrays();
    }

    @Test
    public void containOfArray(){
        Assert.assertFalse(owa.oneFourArray(array));
    }
//

}
