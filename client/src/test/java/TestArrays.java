import client.OperationWihtArrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrays {
    private static OperationWihtArrays owa;

    @Before
    public void init(){
        owa = new OperationWihtArrays();
    }

    @Test
    public void partOfArray(){
        Assert.assertArrayEquals(new int[]{1, 7},owa.newArray(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}));
    }

    @Test(expected = RuntimeException.class)
    public void notFourInArray(){
        owa.newArray(new int[]{1, 2, 6, 7, 2, 3, 9, 1, 7});
    }

    @Test
    public void nullOfArray(){
        Assert.assertArrayEquals(new int[]{},owa.newArray(new int[]{1, 2, 5, 6, 2, 3, 7, 1, 4}));
    }

    @Test
    public void containOfArray(){
        Assert.assertEquals(true,owa.oneFourArray(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }


    @Test
    public void nullOfArrayTwo(){
        Assert.assertEquals(false,owa.oneFourArray(new int[]{}));
    }

    @Test
    public void containOfArrayTwo(){
        Assert.assertEquals(false,owa.oneFourArray(new int[]{1, 3, 1, 4, 4, 1, 4, 4}));
    }

}
