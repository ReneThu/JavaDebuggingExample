package com.dynatrace.secret;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {

    public MyTransformer() {
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        if (className.contains("org/example/Main")) {
            ClassReader classReader = new ClassReader(classfileBuffer);
            final ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
            classReader.accept(new MyVisitor(classWriter, className, "addTwo"), ClassReader.EXPAND_FRAMES);
            return classWriter.toByteArray();
        }

        return classfileBuffer;
    }
}
