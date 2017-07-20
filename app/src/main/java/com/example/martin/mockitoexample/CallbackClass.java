package com.example.martin.mockitoexample;

/**
 * Created by Martin on 19/07/2017.
 */

public class CallbackClass implements ICallbackClass {
    public void doSomething(String value, IHandleCallbacks callback){
        callback.handle(1);
    }
}
