package com.example.martin.mockitoexample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Martin on 16/07/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitoExampleTest {

    @Captor
    ArgumentCaptor<IHandleCallbacks> argCaptor;

    @Captor
    ArgumentCaptor<String> stringCaptor;

    @Test
    public void MyTest(){
        IExampleInterface exampleInterface = mock(IExampleInterface.class);

        int expectedInt = 1;
        when(exampleInterface.GetNumber()).thenReturn(expectedInt);

        String expectedString = "a string";
        when(exampleInterface.getString(anyInt())).thenReturn(expectedString);

        int inputNumber = 2;
        when(exampleInterface.getString(inputNumber)).thenReturn(expectedString);

        ExampleClass exampleClass = new ExampleClass(exampleInterface);
        String result = exampleClass.getResult(inputNumber);

        verify(exampleInterface, times(1)).getString(anyInt());

        //Assert.assertEquals(expectedString, result);
    }

    @Test
    public void callBackExample(){
        IExampleInterface exampleInterface = mock(IExampleInterface.class);
        ExampleClass exampleClass = new ExampleClass(exampleInterface);

        ICallbackClass callbackClass = mock(ICallbackClass.class);
        exampleClass.callBackExample(callbackClass);

        verify(callbackClass, times(1)).doSomething(stringCaptor.capture(), argCaptor.capture());

        IHandleCallbacks callback = argCaptor.getValue();
        callback.handle(1);

        verify(exampleInterface, times(1)).getString(1);
    }
}
