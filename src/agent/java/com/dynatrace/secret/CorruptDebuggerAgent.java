package com.dynatrace.secret;


import com.dynatrace.WriteLoadedClassToDiskAgent;

import java.lang.instrument.Instrumentation;

public class CorruptDebuggerAgent {
    private static final boolean ENABLE_CORRUPTION = true;

    public static void premain(String arguments, Instrumentation instrumentation) {
        if (ENABLE_CORRUPTION) {
            instrumentation.addTransformer(new MyTransformer());
            if (arguments != null && arguments.contains("WriteToDisk")) {
                instrumentation.addTransformer(new WriteLoadedClassToDiskAgent());
            }
        }
    }
}
