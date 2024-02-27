package com.dynatrace;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class WriteLoadedClassToDiskAgent implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (className.contains("org/example/Main")) {
            try {
                FileUtils.writeByteArrayToFile(new File("Main.class"), classfileBuffer);
            } catch (IOException e) {
                throw new RuntimeException("Cannot write classfile");
            }
        }

        return classfileBuffer;
    }
}
