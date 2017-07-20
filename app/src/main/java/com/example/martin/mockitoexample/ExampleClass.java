package com.example.martin.mockitoexample;

/**
 * Created by Martin on 19/07/2017.
 */

public class ExampleClass implements IHandleCallbacks {

    private IExampleInterface exampleInterface;

    public ExampleClass(IExampleInterface exampleInterface){
        this.exampleInterface = exampleInterface;
    }

    public String getResult(int inputNumber) {
        return exampleInterface.getString(inputNumber);
    }

    public void callBackExample(ICallbackClass callbackClass){
        callbackClass.doSomething("my string", this);
    }

    @Override
    public void handle(int testParameter) {
        exampleInterface.getString(testParameter);
    }
}
